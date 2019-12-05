import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signUpForm: FormGroup;
  constructor(private userService:UserService, private formBuilder:FormBuilder) { }

  ngOnInit() {

    this.signUpForm = this.formBuilder.group({
      firstname:['',[
        Validators.required,Validators.minLength(2),Validators.maxLength(50)
      ]],
      lastname:['',[
        Validators.required,Validators.minLength(2),Validators.maxLength(50)
      ]],
      age:['',[
        Validators.required,Validators.minLength(2)
      ]],
      gender:['',[
        Validators.required
      ]],
      contactNumber:['',[
        Validators.required,Validators.minLength(10),Validators.maxLength(10)
      ]],
      userId:['',[
        Validators.required,Validators.minLength(2),Validators.maxLength(50)
      ]],
      password:['',[
        Validators.required,Validators.minLength(2),Validators.maxLength(50)
      ]],
      confirmPassword:['',[
        Validators.required,Validators.minLength(2),Validators.maxLength(50),
        this.matchConfirmPassword.bind(this)
      ]],
      userType:['',[
        Validators.required//,Validators.minLength(1),Validators.maxLength(1)
      ]],
    })

  }
  get firstname() {
    return this.signUpForm.get('firstname');
  }
  get lastname() {
    return this.signUpForm.get('lastname');
  }
  get age() {
    return this.signUpForm.get('age');
  }
  get gender()
  {
    return this.signUpForm.get('gender');
  }
  get contactNumber()
  {
    return this.signUpForm.get('contactNumber');
  }
  get userId()
  {
    return this.signUpForm.get('userId');
  }
  get password() {
    return this.signUpForm.get('password');
  }
  get confirmPassword() {
    return this.signUpForm.get('confirmPassword');
  }
  get userType()
  {
    return this.signUpForm.get('userType');
  }
  matchConfirmPassword(formControl: FormControl): { [s: string]: boolean } {
    if (this.signUpForm) {
      if (formControl.value && formControl.value.length > 0 && formControl.value !== this.signUpForm.get('password').value) {
        return { 'nomatch': true };
      }
    }
    return null;
  }
  // isUsernameTaken(formControl: FormControl): { [s: string]: boolean } {
  //     if (formControl.value === 'ADMIN') {
  //         return { 'userNameTaken': true };
  //       } else {
  //         return null;
  //       }
  //     }

}
