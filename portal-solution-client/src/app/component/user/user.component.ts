import { Component, OnInit } from '@angular/core';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  data : Object;
  error : null;
  constructor(private userService : UserService) { }

  ngOnInit() {
  }

  hello(){
    this.data = null;
    this.userService.hello().subscribe(
      (data)=>{
        this.error =null;
    },
    errorMessage => {
      console.log(errorMessage);
      this.error = errorMessage;
    }
    );
  }

  getUserDetail(){
    this.data = null;
    this.userService.getUserDetail().subscribe(
      (data)=>{
        this.error =null;
    },
    errorMessage => {
      console.log(errorMessage);
      this.error = errorMessage;
    }
    );
  }

  getAllUser(){
    this.data = null;
    this.userService.getAllUser().subscribe(
      (data)=>{
        this.error =null;
      },
      errorMessage => {
        console.log(errorMessage);
        this.error = errorMessage;
      }
      );
  }
}
