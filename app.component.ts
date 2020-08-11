import { Component } from '@angular/core';
import { DataService } from './services/data.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { finalize } from 'rxjs/operators';
import { Router } from '@angular/router';
import { FormControl, Validators, ReactiveFormsModule } from '@angular/forms';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'StockMarketCharting';
  constructor(private data: DataService, private http: HttpClient, private router: Router) {
    }
    // logout() {
      //this.data.authenticate(undefined, undefined);
    //   this.http.post('logout', {}).pipe(finalize(() => {
    //       this.data.authenticated = false;
    //       this.router.navigateByUrl('/login');
    //   })).subscribe();
   // }

}
