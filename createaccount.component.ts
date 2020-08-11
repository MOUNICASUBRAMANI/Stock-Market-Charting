import { Component, OnInit } from '@angular/core';
import { DataService } from '../../services/data.service';
import { variable } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-createaccount',
  templateUrl: './createaccount.component.html',
  styleUrls: ['./createaccount.component.css']
})
export class CreateaccountComponent implements OnInit {
  Name: string
  mobile_no: string
  Email: string
  Password: string
  msg : string=''
  
  mes: any
  constructor(private data: DataService) { }

  ngOnInit() {
  }

  addNewUser(){
      let res=this.data.addUser(this.Name, this.mobile_no, this.Email, this.Password);
      res.subscribe(data=>{if(data=="sucess"){
        this.msg="User Created Succesfully"
      }else{
        this.msg="User Already exist! Retry again ";
      }
    });
  }

}
