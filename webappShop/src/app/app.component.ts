import { Component, OnInit } from '@angular/core';
import { AuthService } from './service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  code:string='null';
  ngOnInit(): void {
    this.loggedIn();
    this.router.navigate(['welcome']);
  }

  constructor(private authService:AuthService,public router: Router){}
  title = 'webappShop';
  isLoggedIn:boolean = false;

  loggedIn():boolean {
    if(!this.authService.loggedInUser.loggedOut){
      this.isLoggedIn = true;
      return true
    }
    else{
      this.isLoggedIn = false;
      return false;
    }
  }
}
