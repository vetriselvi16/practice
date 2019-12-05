import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { User } from 'src/app/modelClass/user';
import { HttpClientService } from 'src/app/service/http-client.service';

@Component({
  selector: 'app-pending-request',
  templateUrl: './pending-request.component.html',
  styleUrls: ['./pending-request.component.css']
})
export class PendingRequestComponent implements OnInit {

  userList:User[];
  empty:boolean=false;
  value:String;
  constructor(private httpService:HttpClientService) { }

  ngOnInit() {

    this.httpService.pendingRequestObservable().subscribe(
      (data:User[]) =>
      {
        this.userList=data;
        //this.getList();
      }
    );
  }
  // getList() {
  //   this.httpService.getSubject().subscribe((data) => {
  //     this.userList = data;
  //   });
  // }
  response(user:User , newStatus:string)
  {
    console.log(user,newStatus)
    
    let newUser:User ={firstname: user.firstname,lastname:user.lastname,age:user.age,gender:user.gender,contactNumber:user.contactNumber,
      userId:user.userId,password:user.password,userType:user.userType, status:newStatus,secretQues1:user.secretQues1,secretAns1:user.secretAns1,
      secretQues2:user.secretQues2,secretAns2:user.secretAns2,secretQues3:user.secretQues3,secretAns3:user.secretAns3
    }
    console.log(newUser)
    /*if(status == 'A')
    {
      alert('approved')
    }
    else if(status == 'D')
    {
      alert('reject')
    }*/
    this.httpService.responseForRequest(newUser).subscribe(
      (data) => {
        data=this.httpService.pendingRequestObservable().subscribe(
          (data:User[]) =>
          {
            this.userList=data;
            console.log(this.userList)
          })
      });
  }
}
