import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './component/home/home.component';
import { HeaderComponent } from './component/header/header.component';
import { AuthComponent } from './component/auth/auth.component';
import { LoadingSpinnerComponent } from './component/shared/loading-spinner/loading-spinner.component';
import { AuthInterceptorService } from './service/auth-interceptor.service';
import { UserComponent } from './component/user/user.component';
import { HelloComponent } from './component/user/hello/hello.component';
import { UserDetailComponent } from './component/user/user-detail/user-detail.component';
import { AllUserComponent } from './component/user/all-user/all-user.component';
import { UserService } from './service/user.service';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AuthComponent,
    LoadingSpinnerComponent,
    UserComponent,
    HomeComponent,
    HelloComponent,
    UserDetailComponent,
    AllUserComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    UserService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
