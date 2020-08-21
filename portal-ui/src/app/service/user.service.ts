import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { catchError, tap } from 'rxjs/operators';
import { throwError, Subject } from 'rxjs';
import { UserDetail } from '../model/user-detail.model';
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  //private helloData : string;

  userDetailsChanged = new Subject<UserDetail>();
  allUsersChanged = new Subject<UserDetail[]>();
  private  userDetail : UserDetail;
  private allUser : UserDetail[];
  constructor(private http: HttpClient) {}

  hello() {
    return this.http
      .get(
        `${environment.serverUrl}/hello`
      )
      .pipe(
        catchError(this.handleError),
        tap(resData => {
          //this.helloData = JSON.stringify(resData);
        })
      );
  }

  getAllUser() {
    this.allUser = null;
    return this.http
      .get<UserDetail[]>(
        `${environment.serverUrl}/admin/getAllUser`
      )
      .pipe(
        catchError(this.handleError),
        tap(resData => {
           this.allUser = resData;
           this.allUsersChanged.next(this.allUser.slice());
        })
      );
  }
  
  getUserDetail() {
    this.userDetail = null;
    return this.http
      .post<UserDetail>(
        `${environment.serverUrl}/user/getUser?username=user`, {}
      )
      .pipe(
        catchError(this.handleError),
        tap(resData => {
          this.userDetail = resData;
          this.userDetailsChanged.next(this.userDetail);
        })
      );
  }

  fetchUserDetail(){
    return this.userDetail;
  }

  fetchAllUser(){
    return this.allUser.slice();
  }

  private handleError(errorRes: HttpErrorResponse) {
    let errorMessage = 'An unknown error occurred!';
    if (!errorRes.error || !errorRes.error.error) {
      return throwError(errorMessage);
    }
    if(errorRes.status===403){
      return throwError("You are not Authorized to see this information");
    }
    switch (errorRes.error.error.message) {
      case 'EMAIL_EXISTS':
        errorMessage = 'This email exists already';
        break;
      case 'EMAIL_NOT_FOUND':
        errorMessage = 'This email does not exist.';
        break;
      case 'INVALID_PASSWORD':
        errorMessage = 'This password is not correct.';
        break;
    }
    return throwError(errorMessage);
  }
}
