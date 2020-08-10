import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AdminService } from 'src/app/service/admin.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  constructor(private adminService: AdminService) { }

  ngOnInit() {
  }
  error = null;
  success = null;
  
  onSubmit(form: NgForm) {
    if (!form.valid) {
      return;
    }
    console.log(form.value);
    const email = form.value.email;
    const username = form.value.username;
    const mobileNo = form.value.mobileNo;
    const roles = form.value.roles;

    let obs: Observable<any>;
    this.error = null;
    this.success = null
    
    obs = this.adminService.addUser(username,email,mobileNo,roles);
  
    obs.subscribe(
      resData => {
        // console.log(resData);
        // this.success = resData;
      },
      errorMessage => {
        // console.log(errorMessage);
        this.error = errorMessage;
      }
    );

    form.reset();
  }
}
