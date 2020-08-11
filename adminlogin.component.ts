import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { variable } from '@angular/compiler/src/output/output_ast';
import { DataService } from '../../services/data.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { finalize } from 'rxjs/operators';
//import { AuthGuard } from '../../auth.guard';


@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {
  msg: String = "";
  credentials = {email: '', password: ''};
  constructor(private router:Router,private data: DataService,private http: HttpClient) { 
  }

  ngOnInit(): void {
  }
  go(){
    this.data.checkadmin(this.credentials).subscribe(data=>{
      if(data=="sucess"){
        this.router.navigateByUrl('/adminpage');
        return true;
      }else{
        this.msg="Enter valid username and password"
      }
    });
}

}
  /*// login() {
  //   this.data.authenticate(this.credentials, () => {
  //       this.router.navigateByUrl('/');
  //   });
  //   return false;
  // }
  
  go(){
    this.data.checkadmin(this.email,this.password).subscribe(data=>{console.log(data);/*if(data=='sucess'){this.router.navigateByUrl('/adminpage')}else{
      this.enable=true;
    }
  });
    //this.router.navigateByUrl('/adminpage').then(nav => {
      //console.log(nav); // true if navigation is successful
    //}, err => {
      //console.log(err) // when there's an error
   // });
}
*/
