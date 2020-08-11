import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { DataService } from '../../services/data.service';
@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit {
  credentials = {email: '', password: ''};
  msg : String='';
  constructor(private router:Router,private data: DataService,) { }

  ngOnInit(): void {
  }
  user(){
    this.data.checkuser(this.credentials).subscribe(data=>{
      if(data=="sucess"){
        console.log("success")
        sessionStorage.setItem("email",this.credentials.email);
        sessionStorage.setItem("password",this.credentials.password);
        this.router.navigateByUrl('/userpage');
      }else{
        this.msg="Enter valid username and password"
      }
    });
}
}
