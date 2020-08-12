import { Component, OnInit } from '@angular/core';
import { UserDetail } from 'src/app/model/user-detail.model';
import { UserService } from '../../../service/user.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {
    userDetail: UserDetail;
    subscription: Subscription;
  constructor(private userService: UserService) { 

  }

  ngOnInit() {
    this.userDetail = null;
    this.subscription = this.userService.userDetailsChanged
      .subscribe(
        (userDetail: UserDetail) => {
          this.userDetail = userDetail;
        }
      );

    this.userDetail = this.userService.fetchUserDetail();
      }

}
