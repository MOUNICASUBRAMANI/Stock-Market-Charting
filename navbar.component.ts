import { Component, OnInit,Output, Input, EventEmitter } from '@angular/core';
import { DataService } from '../../services/data.service';
import { Company } from '../../models/Company';
import { componentFactoryName } from '@angular/compiler';
import { CompanyFormComponent } from '../company-form/company-form.component';
import { combineAll, findIndex } from 'rxjs/operators';
import { HttpResponse, HttpEventType, HttpErrorResponse } from '@angular/common/http';
import { Ipo } from '../../models/IPO';
import { Router, RouterModule } from '@angular/router';
//import { Chart } from 'chart.js'


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  data: boolean= false;
  company: boolean= false;
  exchange: boolean= false;
  ipo: boolean= false;
  new: boolean= false;
  //com1: Company;
  com1: Company ={

    id: 0,
    compname: '' ,
    turnover: '',
    ceo: '',
    board_of_dir:'',
    stockexchange: '',
    sector:'',
    writeup: '',
    stockcode:''
  };
  com: Company[];
  ipos: Ipo[];
  edit: boolean= false;
  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };
  selectedFile = null;
  changeImage = false;
  error : boolean = false;
  sucess : boolean = false;
  ipodata: Ipo= {
    id:0,comp_name:'',stock_exchange:'',price:'',no_of_shares:'',opendate:null,remarks:''};

  @Output() newcompany: EventEmitter<Company> = new EventEmitter();
  @Input() current: Company;

  constructor(private data1: DataService,private router:Router) { }

  ngOnInit() {
  
      this.data1.getcompany().subscribe(com=>{this.com=com});
      //this.data1.chart().subscribe(result=>console.log(result));
  

  }
  importData(){
    this.data = true;
    this.company = false;
    this.exchange = false;
    this.new=false;
    this.ipo = false;
  }
  manageCompany(){
    this.data = false;
    this.company = true;
    this.exchange = false;
    this.ipo = false;
    this.new=false;
  }
  manageExchange(){
    this.data = false;
    this.company = false;
    this.exchange = true;
    this.ipo = false;
    this.new=false;
  }
  updateIpoDetails(){
    this.data = false;
    this.company = false;
    this.exchange = false;
    this.ipo = true;
    this.new=false;
  }
  createcompany(){
    this.data = false;
    this.company = false;
    this.exchange = false;
    this.ipo = false;
    this.new=true;
  }
  addNewCompany(){
    if(this.edit){
      let res1=this.data1.editcompany(this.com1);
      res1.subscribe(data1=>console.log("success",data1));
      this.edit = false;
    }
    else{
    let res1=this.data1.addCompany(this.com1);
    res1.subscribe(data1=>console.log("success",data1));
    this.com.push(this.com1);
    }this.manageCompany();
}
  editcompany(comp2:Company){
    this.edit=true;
    this.com1=comp2;
    this.createcompany();
  }

  deletecompany(comp2:Company){
    //this.com.splice(this.com.findIndex(comp2),1);
    let res1=this.data1.deletecompany(comp2);
      res1.subscribe(data1=>console.log("success",data1));
  }
  change($event) {
    this.changeImage = true;
  }
  changedImage(event) {
    this.selectedFile = event.target.files[0];
  }
  upload() {
    this.progress.percentage = 0;
    this.currentFileUpload = this.selectedFiles.item(0);
    this.data1.pushFile(this.currentFileUpload).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
         alert('File Successfully Uploaded');
         this.sucess = true;
      }
      else if (event instanceof HttpErrorResponse){
        this.error=true;}
      this.selectedFiles = undefined;
     }
    );
  }
  selectFile(event) {
    this.selectedFiles = event.target.files;
    this.error=false;
    this.sucess=false;
  }
  addNewIpo(){
    console.log("MALK")
    this.data1.addIpo(this.ipodata).subscribe(data1=>console.log("success",data1));
    this.updateIpoDetails();
  }
  logout(){
    this.router.navigateByUrl('/userlogin')
  }

}
