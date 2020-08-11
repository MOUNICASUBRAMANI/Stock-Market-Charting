import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AdminloginComponent } from './components/adminlogin/adminlogin.component';

import { HomeComponent } from './components/home/home.component';

import { UserloginComponent } from './components/userlogin/userlogin.component';

import {CreateaccountComponent } from './components/createaccount/createaccount.component';

import {AdminpageComponent } from './components/adminpage/adminpage.component';

import {NavbarComponent } from './components/navbar/navbar.component';

import {UserpageComponent } from './components/userpage/userpage.component';

//import { AuthGuard } from './auth.guard';

const routes: Routes = [
  {path : '', component: HomeComponent},

  {path : 'adminlogin', component: AdminloginComponent},

  {path : 'userlogin', component: UserloginComponent},
  {path : 'createaccount', component: CreateaccountComponent},
  {path : 'adminpage', component: AdminpageComponent},
  {path : 'navbar', component: NavbarComponent},
  {path : 'userpage', component: UserpageComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
