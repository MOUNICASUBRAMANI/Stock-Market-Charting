import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Injectable } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { AdminloginComponent } from './components/adminlogin/adminlogin.component';
import { UserloginComponent } from './components/userlogin/userlogin.component';
import { CreateaccountComponent } from './components/createaccount/createaccount.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AdminpageComponent } from './components/adminpage/adminpage.component';
import { UserpageComponent } from './components/userpage/userpage.component';
import { DataService } from './services/data.service';
import { HttpClientModule,HttpInterceptor,HttpHandler,HttpRequest,HttpXhrBackend,HTTP_INTERCEPTORS } from '@angular/common/Http';
import { FormsModule, ReactiveFormsModule } from '@angular/Forms';
import { CompanyFormComponent } from './components/company-form/company-form.component';
//import { AuthGuard } from './auth.guard';
//import { DatePipe } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AdminloginComponent,
    UserloginComponent,
    CreateaccountComponent,
    NavbarComponent,
    AdminpageComponent,
    UserpageComponent,
    CompanyFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }

