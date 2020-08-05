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

const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'auth', component: AuthComponent },
  { path: 'whatsapp', component: WhatsappComponent , canActivate: [AuthGuard]},
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
