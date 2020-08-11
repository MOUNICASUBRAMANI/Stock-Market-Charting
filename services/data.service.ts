import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders, HttpEvent } from '@angular/common/http';
import { Company } from '../models/Company';
import { Ipo } from '../models/Ipo';
import { Profile } from '../models/Profile';
//import { map } from 'rxjs/operators';
import 'rxjs/add/operator/map';
import { Observable, of, Subject } from 'rxjs';
//import { Observable } from 'rxjs/Oservable';

const options= {
  headers: new HttpHeaders({'content-type': 'application/json'})
}
@Injectable({
  providedIn: 'root'
})
export class DataService {

  url : string = "http://localhost:8080/demo/users"
  link: string ="http://localhost:8080/demo/allcom"
  comp : string = "http://localhost:8080/demo/addcom"
  //authenticated = false;
  //USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'

  public username: String;
  public password: String;
  constructor(private http: HttpClient) { }

 

  public addUser(Name: string, mobile_no: string, Email: string, Password: string) {
    var userType='user';
    return this.http.post<any>(this.url,{"name":Name,"mobile_no":mobile_no,"email":Email,"password":Password,"user_type":userType}, {responseType: 'text' as 'json'});
    //subscribe(data => {console.log("success");},error => {console.log("error",error);});

  }

  public addCompany(com1: any ) {

    return this.http.post<any>(this.comp,com1,options);
    //subscribe(data => {console.log("success");},error => {console.log("error",error);});

  }

  public checkadmin(credentials : any) {
    return this.http.post<any>("http://localhost:8080/demo/checkadmin",credentials, {responseType: 'text' as 'json'});
    //subscribe(data => {console.log("success");},error => {console.log("error",error);});

  }

  public checkuser(credentials : any) {
    return this.http.post<any>("http://localhost:8080/demo/checkuser",credentials, {responseType: 'text' as 'json'});
    //subscribe(data => {console.log("success");},error => {console.log("error",error);});

  }

  public getProfile(credentials : any) {
    return this.http.post<any>("http://localhost:8080/demo/profile",credentials);
    //subscribe(data => {console.log("success");},error => {console.log("error",error);});

  }

  // public checkuser(credentials : any) {
  //   return this.http.get<any>("http://localhost:8080/demo/checkuser",{ headers: { authorization: this.createBasicAuthToken(credentials.username, credentials.password) } }).pipe(map((res) => {
  //     this.username = credentials.username;
  //     this.password = credentials.password;
  //     this.registerSuccessfulLogin(credentials.username, credentials.password);
  //   }));

  // }

  // createBasicAuthToken(username: String, password: String) {
  //   return 'Basic ' + window.btoa(username + ":" + password)
  // }

  // registerSuccessfulLogin(username, password) {
  //   sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username)
  // }

  // logout() {
  //   sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
  //   this.username = null;
  //   this.password = null;
  // }

  // isUserLoggedIn() {
  //   let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
  //   if (user === null) return false
  //   return true
  // }

  // getLoggedInUserName() {
  //   let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
  //   if (user === null) return ''
  //   return user
  // }

  

  public getcompany(){
    return this.http.get<Company[]>(this.link)
  }

  public getIpo(){
    return this.http.get<Ipo[]>("http://localhost:8080/demo/allipo")
  }

  public editcompany(com1: Company){
    return this.http.put<Company[]>("http://localhost:8080/demo/updatecom",com1)
  }

  public editprof(prof: Profile){
    return this.http.put<Profile[]>("http://localhost:8080/demo/updateprofile",prof,{responseType: 'text' as 'json'})
  }

  public addIpo(ipo: Ipo){
    return this.http.post<Ipo[]>("http://localhost:8080/demo/addipo",ipo,options)
  }

  public deletecompany(com1: Company){
    return this.http.delete<Company[]>("http://localhost:8080/demo/deletecom/"+com1.id)
  }

  public pushFile(file: File){
    const data: FormData = new FormData();
    data.append('file', file);
    return this.http.post<HttpEvent<{}>>("http://localhost:8080/demo/file",data,{
      reportProgress: true,
      responseType: 'text' as 'json'
      })
  }

  generate(com:string,company_name:string,exchange:string,FromDate:Date,LastDate:Date) {
      
      return this.http.post<any>("http://localhost:8080/demo/map",{"com":com,"company_name":company_name,"stock_exchange":exchange,"FromDate":FromDate,"ToDate":LastDate});
  }
  getcomp(compname:string){
    console.log("get")
    return this.http.post<any>("http://localhost:8080/demo/company",{"compname":compname});
  }
  stockmap(){
    
      return this.http.get("http://localhost:8080/demo/allstock")
        .map(result => result);

  }

}
