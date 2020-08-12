import { Role } from './role.model';

export class UserDetail {
  public username: string;
  public email: string;
  public mobileNo: string;
  public roles: Role[];

  constructor(username: string, email: string, mobileNo: string, roles: Role[]) {
    this.username = username;
    this.email = email;
    this.mobileNo = mobileNo;
    this.roles = roles;
  }
}
