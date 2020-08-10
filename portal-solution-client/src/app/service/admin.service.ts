import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { tap, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  addUser(username:string,email:string,mobileNo:number,roles:string[]): any {
    return this.http
    .post(
      'http://localhost:8080/register',
      {
        username: username,
        email: email,
        mobileNo: mobileNo,
        roles: roles,
        password: 'password'
      }
    )
    .pipe(
      catchError(this.handleError),
      tap(resData => {
    
      })
    );
  }

  private handleError(errorRes: HttpErrorResponse) {
    let errorMessage = 'An unknown error occurred!';
    switch (errorRes.error.code) {
      case 'USER_EXISTS':
        errorMessage = errorRes.error.message;
        break;
      default:
        errorMessage = errorRes.error.message;
    }
    return throwError(errorMessage);
  }
}
