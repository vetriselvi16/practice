import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { User } from '../modelClass/user';
import { AuthService } from './auth.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  user:User[];
  userRole:string;
  userExists:boolean = true;
  url:string=environment.baseUrl+"/authentication-service"
  
  constructor(private http:HttpClient,private router:Router) { }

  addUser(user:any) {
    let userDetails:User = {firstname:user["firstname"],lastname:user["lastname"],
    age:user["age"], gender:user["gender"],contactNumber:user["contactNumber"],
    userId:user["userId"],password:user["password"],userType:user["userType"],
    status:user["status"],secretQues1:user["secretQues1"],secretAns1:user["secretAns1"],
    secretQues2:user["secretQues2"],secretAns2:user["secretAns2"],
    secretQues3:user["secretQues3"],secretAns3:user["secretAns3"]};
    this.addUserObservable(userDetails).subscribe(
      (data) => {
        this.userExists = data; 
        console.log(this.userExists)       
        if(data)
          this.router.navigate(['login'])
      },
      (error)=>{
        console.log(error);
      }
    )
  }
  addUserObservable(user:any): Observable<any> {
    console.log(user);
    if(user.userType =='Customer')
    {
      user.userType="U";
      user.status="A"
    }
    else if(user.userType =='Store Manager')
    {
      user.userType="A";
      user.status="P"
    }
    return this.http.post(this.url+"/user",user);
  }

  
}


