import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router:Router,private formBuild:FormBuilder,private authService:AuthService) { }

  loginForm:FormGroup

  ngOnInit() {
    this.authService.status2 = false;
    this.loginForm = this.formBuild.group({
      userId: ['',[
        Validators.required
      ]],
      password: ['',[
        Validators.required
      ]]
    })
  }

  get userId(){
    return this.loginForm.get('userId');
  }
  get password(){
    return this.loginForm.get('password');
  }

  toSignup() {
    this.router.navigate(['signup'])
  }
}
