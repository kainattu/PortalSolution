import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';

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
      // catchError(this.handleError),
      tap(resData => {
    
      })
    );
  }
}
