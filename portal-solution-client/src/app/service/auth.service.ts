import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { catchError, tap } from 'rxjs/operators';
import { throwError, BehaviorSubject } from 'rxjs';

import { User } from '../model/user.model';

export interface AuthResponseData {
  email: string;
  token: string;
  expiresIn: string;
  username: string;
  registered?: boolean;
  firstTimeLogin?: boolean
}

@Injectable({ providedIn: 'root' })
export class AuthService {
  user = new BehaviorSubject<User>(null);
  private tokenExpirationTimer: any;

  constructor(private http: HttpClient, private router: Router) {}

  signup(username: string, password: string, email: string) {
    return this.http
      .post<AuthResponseData>(
        'http://localhost:8080/register',
        {
          username: username,
          email: email,
          password: password
        }
      )
      .pipe(
        catchError(this.handleError),
        tap(resData => {
          this.handleAuthentication(
            resData.username,
            resData.email,
            resData.token,
            +resData.expiresIn
          );
        })
      );
  }

  login(username: string, password: string) {
    return this.http
      .post<AuthResponseData>(
        'http://localhost:8080/authenticate',
        {
          username: username,
          password: password
        }
      )
      .pipe(
        catchError(this.handleError),
        tap(resData => {
          if(resData.firstTimeLogin){
            this.router.navigate(['/resetPassword']);
          }
          else {
            this.handleAuthentication(
              resData.username,
              resData.email,
              resData.token,
              +resData.expiresIn
            );
          }
        })
      );
  }

  autoLogin() {
    const userData: {
      username: string;
      email: string;
      _token: string;
      _tokenExpirationDate: string;
    } = JSON.parse(localStorage.getItem('userData'));
    if (!userData) {
      return;
    }

    const loadedUser = new User(
      userData.username,
      userData.email,
      userData._token,
      new Date(userData._tokenExpirationDate)
    );

    if (loadedUser.token) {
      this.user.next(loadedUser);
      const expirationDuration =
        new Date(userData._tokenExpirationDate).getTime() -
        new Date().getTime();
      this.autoLogout(expirationDuration);
    }
  }

  resetPassword(username: string, oldPassword: string, newPassword: string) {
    return this.http
      .post<AuthResponseData>(
        'http://localhost:8080/resetPassword',
        {
          username: username,
          password: oldPassword,
          newPassword: newPassword
        }
      )
      .pipe(
        catchError(this.handleError),
        tap(resData => {
          
        })
      );
  }


  logout() {
    this.user.next(null);
    this.router.navigate(['/auth']);
    localStorage.removeItem('userData');
    if (this.tokenExpirationTimer) {
      clearTimeout(this.tokenExpirationTimer);
    }
    this.tokenExpirationTimer = null;
  }

  autoLogout(expirationDuration: number) {
    this.tokenExpirationTimer = setTimeout(() => {
      this.logout();
    }, expirationDuration);
  }

  private handleAuthentication(
    username: string,
    email: string,
    token: string,
    expiresIn: number
  ) {
    const expirationDate = new Date(new Date().getTime() + expiresIn * 1000);
    const user = new User(username, email, token, expirationDate);
    this.user.next(user);
    this.autoLogout(expiresIn * 1000);
    localStorage.setItem('userData', JSON.stringify(user));
  }

  private handleError(errorRes: HttpErrorResponse) {
    let errorMessage = 'An unknown error occurred!';
    // if (!errorRes.error || !errorRes.error.error) {
    //   return throwError(errorMessage);
    // }
    switch (errorRes.error.code) {
      case 'BAD_CREDENTIAL':
        errorMessage = errorRes.error.message;
        break;
      case 'DISABLED':
        errorMessage = errorRes.error.message;
        break;
      case 'INVALID_PASSWORD':
        errorMessage = 'This password is not correct.';
        break;
      default:
        errorMessage = errorRes.error.message;
    }
    return throwError(errorMessage);
  }
}
