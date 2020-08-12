import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  error = null;
  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  getAllUser(){
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
