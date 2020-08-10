import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import { throwError, Subject } from 'rxjs';

export interface WhatsappResponseData {
  success: string;
}

export interface WhatsappRecieveResponseData {
  fromContact: string;
  toContact: string;
  message: string;
}

@Injectable({
  providedIn: 'root'
})
export class WhatsappService {

  allWhatsappRecieveChanged = new Subject<WhatsappRecieveResponseData[]>();
  private messages : WhatsappRecieveResponseData[];

  constructor(private http: HttpClient) { }

  sendMessage(phoneNumber: number, message: string): any {
    return this.http
    .post<WhatsappResponseData>(
      'http://localhost:8080/whatsapp/send',
      {
        phoneNumber: phoneNumber,
        message: message
      }
    )
    .pipe(
      catchError(this.handleError),
      tap(resData => {
    
      })
    );
  }

  recieveMessage(): any {
    return this.http
    .get<WhatsappRecieveResponseData[]>(
      'http://localhost:8080/fetchMessage'
    )
    .pipe(
      catchError(this.handleError),
      tap(resData => {
        this.messages = resData;
        this.allWhatsappRecieveChanged.next(this.messages.slice())
      })
    );
  }

  fetchMessages(){
    return this.messages.slice();
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
      default :
        errorMessage = errorRes.error.message;
    }
    return throwError(errorMessage);
  }
}
