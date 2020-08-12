import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { Subscription } from 'rxjs';
import { UserDetail } from 'src/app/model/user-detail.model';

@Component({
  selector: 'app-all-user',
  templateUrl: './all-user.component.html',
  styleUrls: ['./all-user.component.css']
})
export class AllUserComponent implements OnInit {
  subscription : Subscription
  allUser : UserDetail[];
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.allUser= null;
    this.subscription = this.userService.allUsersChanged
      .subscribe(
        (allUser: UserDetail[]) => {
          this.allUser = allUser;
        }
      );

    this.allUser = this.userService.fetchAllUser();
  }

}
