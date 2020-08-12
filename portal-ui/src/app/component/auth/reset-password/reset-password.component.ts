import { Component, OnInit, ViewChild } from '@angular/core';
import { AuthService, AuthResponseData } from 'src/app/service/auth.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {
  isLoading = false;
  error: string = null;
  username: string;
  oldPassword: string;
  @ViewChild('authForm', {static:true}) authForm: NgForm;
  
  constructor(private authService: AuthService,private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
  //   this.username = this.route.snapshot.paramMap.get('username');
  //   this.oldPassword = this.route.snapshot.paramMap.get('oldPassword');
  //   this.authForm.form.patchValue({  
  //     username: this.username,  
  //     oldPassword: this.oldPassword
  // });  
  }

  onSubmit(form: NgForm) {
    if (!form.valid) {
      return;
    }
    const newPassword = form.value.newPassword;
    const confirmPassword = form.value.confirmPassword;

    if(newPassword===confirmPassword) {
      const username = form.value.username;
      const oldPassword = form.value.password;
  
      let authObs: Observable<AuthResponseData>;
  
      this.isLoading = true;
  
     authObs = this.authService.resetPassword(username, oldPassword, newPassword);
  
      authObs.subscribe(
        resData => {
          console.log(resData);
          this.isLoading = false;
          this.router.navigate(['/auth']);
        },
        errorMessage => {
          console.log(errorMessage);
          this.error = errorMessage;
          this.isLoading = false;
        }
      );
    }
    else{
      this.error = "New password do not match with Confirm Password";
    }

    form.reset();
  }

}
