import { Component, OnInit, Input} from '@angular/core';
import { DataService } from '../../services/data.service';
import { HttpResponse, HttpEventType, HttpErrorResponse } from '@angular/common/http';
import { Chart } from 'chart.js';
import { Stock } from '../../models/Stock';
import { Ipo } from '../../models/IPO';
import { Profile } from '../../models/Profile';
import { UserloginComponent } from '../userlogin/userlogin.component';
import { Router, RouterModule } from '@angular/router';
import { Observable, of, Subject } from 'rxjs';
import 'rxjs/Rx';
//import { DatePipe } from '@angular/common';
//import 'rxjs/add/operator/map';
@Component({
  selector: 'app-userpage',
  templateUrl: './userpage.component.html',
  styleUrls: ['./userpage.component.css'],
  
})
export class UserpageComponent implements OnInit  {
  ipos: boolean= false;
  company: boolean= false;
  sector: boolean= false;
  others: boolean= false;
  Profile:boolean=false;
  FromDate : Date;
  LastDate : Date;
  compname:string;
  data: any;
  com:string;
  exchange:string;
  company_option: string[];
  exchange_option: string[];
  company_name:string;
  profile1:Profile[];
  chart = [];
  date =[];
  detail:boolean = false;
  detail1:boolean = false;
  current_price =[];
  date1 =[];
  current_price1 =[];
  stock:Stock[];
  ipo_details:Ipo[];
  compName1: string;
  compName2: string;
  chartType: string;
  credentials = {email: '', password: ''};
  ipodata: Ipo= {
    id:0,comp_name:'',stock_exchange:'',price:'',no_of_shares:'',opendate:null,remarks:''};
  companyData ={ id:'',compname:'',turnover:'',ceo:'',board_of_dir:'',stockexchange:'',secor:'',writeup:'',stockcode:''};
  profile = {name: '',
  mobile_no: '',
  email: '',
  password: '',
id:0};
  constructor(private data2: DataService,private router:Router) {
   }

  ngOnInit(): void {
     this.company_option=['Company','Sector'];
     this.exchange_option=['BSE','NSE'];
     this.data2.getIpo().subscribe(com=>{this.ipo_details=com});
    // this.exchange=this.exchange_option[0];
    // this.com=this.company_option[0];
    //this.getData();
  }
  // getData(): void {
  //   this.data2.get().subscribe(data => {
  //     this.data = data;
  //   });
  // }
  ipo(){
    this.ipos = true;
    this.company = false;
    this.sector = false;
    this.others = false;
    this.detail=false;
    this.detail1=false;
    this.Profile=false;
  }
  compareCompany(){
    this.ipos = false;
    this.company = true;
    this.sector = false;
    this.others = false;
    this.detail=false;
    this.detail1=false;
    this.Profile=false;
  }
  search(){
    this.ipos = false;
    this.detail=false;
    this.company = false;
    this.sector = true;
    this.others = false;
    this.detail1=false;
    this.Profile=false;
  }
  editprofile(){
    this.ipos = false;
    this.detail=false;
    this.company = false;
    this.sector = false;
    this.others = false;
    this.detail1=false;
    this.Profile=true;

  }
  other(){
    this.credentials.email=sessionStorage.getItem("email");
    this.credentials.password=sessionStorage.getItem("password");
    this.data2.getProfile(this.credentials).subscribe(data=>{this.profile.name=data.name;
      this.profile.email=data.email;
      this.profile.password=data.password;
      this.profile.mobile_no=data.mobile_no;
      this.profile.id=data.id;
    });
    this.ipos = false;
    this.company = false;
    this.sector = false;
    this.others = true;
    this.detail=false;
    this.detail1=false;
  }
  edit(){
    let res1=this.data2.editprof(this.profile);
      res1.subscribe(data1=>console.log("success",data1));
      //this.profile1.push(this.profile);
      this.Profile=false;
  }

  logout(){
    this.router.navigateByUrl('/userlogin')
  }
  addData(){
    this.compName1=this.company_name
    let res1=this.data2.generate(this.com,this.company_name,this.exchange,this.FromDate,this.LastDate);
    res1.subscribe((res: Stock[]) => { 
      res.forEach(y => {
        this.date1.push(y.date);
        this.current_price1.push(y.currentprice);
      });
  });
  this.com='';
  this.company_name='';
  this.exchange='';
  this.FromDate=null;
  this.LastDate=null;
}
  generate() {
      this.compName2=this.company_name
      this.chartType='line';
      console.log(this.compName2);
     let res1=this.data2.generate(this.com,this.company_name,this.exchange,this.FromDate,this.LastDate);
     res1.subscribe((res: Stock[]) => { 
      res.forEach(y => {
        this.date.push(y.date);
        this.current_price.push(y.currentprice);
      });
      this.chart = new Chart('canvas', {
        type: 'line',
        data: {
          labels: this.date,
          datasets: [
            {
              data: this.current_price,
              label:this.compName1,
              borderColor: 'red',
              fill: false
            },
            {
              data: this.current_price1,
              label:this.compName2,
              borderColor: 'blue',
              fill: false
            }
          ]
        },
        options: {
          legend: {
            display: true
          },
          scales: {
            xAxes: [{
              title:'Date',
              display: true
            }],
            yAxes: [{
              title:'Stock Price',
              display: true
            }],
          }
        }
      });
    });
  }
  getCompany(){
    this.detail1=true;
    let res1=this.data2.getcomp(this.compname);
    res1.subscribe((res=>{this.companyData=res
    console.log(this.companyData)})) ;
    this.compname=''
    
  }
  ipodetail(detail1:Ipo){
    this.detail=true;
    this.data2.getIpo().subscribe(com=>{this.ipo_details=com});
    this.ipodata=detail1;
  }
  

}
      