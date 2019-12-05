import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpClientService } from './http-client.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isAdmin:boolean = false;
  loggedInUser={loggedOut:true};
  validCredentials:boolean=false;
  redirectUrl = '/';
  loggedIn:boolean = false;
  private token: string;
  error: string = "Login Failed";
  status:boolean;
  status2:boolean=false;
  url:string=environment.baseUrl+"/authentication-service";

  constructor(private userService:UserService,public router: Router,private httpClient:HttpClient,private httpService:HttpClientService) { }

  authenticateSpring(userId:string,password:string):Observable<any> {
    let credentials = btoa(userId+':'+password);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic '+credentials)
    return this.httpClient.get(this.url+"/authentication",{headers})
  }
  public setToken(token: string) {
    this.httpService.setToken(token);
    this.token = token;
  }
  public getToken() {
    return this.token;
  }

  authenticateUser(user) 
  {
    console.log("hi");
    this.authenticateSpring(user.userId,user.password).subscribe(
      (data)=>{
        this.validCredentials = true;
        console.log(this.validCredentials) ;      

        if(data.token == null)
        {
          if(data.status == 'P')
          {
            this.status=true;
            console.log("pending");
          }
          else if(data.status == 'D')
          {
            this.status=false;
            console.log("denied")
          }
        }
        else
        {
          this.loggedIn = true;
          this.loggedInUser = user
          this.setToken(data.token);
          console.log(data.token);

          if(data.role == 'USER')
          {
            this.isAdmin = false;
            this.router.navigate(['search-bar']);
          }
          else if(data.role == 'ADMIN')
          {
            this.isAdmin = true;
            this.router.navigate(['search-bar']);
          }
          else if(data.role == 'SUPER USER')
          {
            this.router.navigate(['pending-request']);
          }
        }
       },
       (error)=>{
         this.validCredentials = false;
         console.log(error);
         this.loggedIn = false;
         if(error.status == 401)
         {
           this.status2=true;
           console.log(this.status2);
         }
      }
      )
  }

  logout() {
    this.loggedInUser = {loggedOut:true};
    //this.productService.isAdmin = false;
    this.loggedIn = false;
    //this.productService.isLoggedIn = false;
   // this.productService.clickedOnAdd = false;
    //this.productService.addedToCart = false;
    this.setToken(null)
    this.router.navigate(['login']);
  }

}
