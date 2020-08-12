import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { AuthComponent } from './component/auth/auth.component';
import { AuthGuard } from './service/auth.guard';
import { UserComponent } from './component/user/user.component';
import { HelloComponent } from './component/user/hello/hello.component';
import { UserDetailComponent } from './component/user/user-detail/user-detail.component';
import { AllUserComponent } from './component/user/all-user/all-user.component';
import { WhatsappComponent } from './component/whatsapp/whatsapp.component';
import { WhatsappSendComponent } from './component/whatsapp/whatsapp-send/whatsapp-send.component';
import { WhatsappRecieveComponent } from './component/whatsapp/whatsapp-recieve/whatsapp-recieve.component';
import { AdminComponent } from './component/admin/admin.component';
import { AddUserComponent } from './component/admin/add-user/add-user.component';
import { ViewUsersComponent } from './component/admin/view-users/view-users.component';
import { ResetPasswordComponent } from './component/auth/reset-password/reset-password.component';
const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'auth', component: AuthComponent },
  { path: 'resetPassword', component: ResetPasswordComponent },
  { path: 'whatsapp', component: WhatsappComponent , canActivate: [AuthGuard],
  children: [
    { path: 'send', component: WhatsappSendComponent },
    { path: 'recieve', component: WhatsappRecieveComponent } ] 
  },
  { path: 'admin', component: AdminComponent , canActivate: [AuthGuard],
  children: [
    { path: 'add', component: AddUserComponent },
    { path: 'view', component: AllUserComponent } ] 
  },
  { path: 'user', component: UserComponent, canActivate: [AuthGuard],
  children: [
    { path: 'hello', component: HelloComponent },
    { path: 'detail', component: UserDetailComponent },
    { path: 'all', component: AllUserComponent } ] }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
