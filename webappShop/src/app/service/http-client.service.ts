import { Injectable } from '@angular/core';
import { User } from '../modelClass/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { Product } from '../modelClass/product';
import { Bill } from '../modelClass/bill';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  private subject = new Subject<Product[]>();
  user:User[];
  url:string=environment.baseUrl+"/shop-service"
  private token:string = "";
  public setToken(token: string) {
    this.token = token;
  }
  public getToken() {
    return this.token;
  }
  constructor(private http:HttpClient,private router:Router,) { }

  getSubject(): Subject<any> {
    return this.subject;
  }
  pendingRequestObservable():Observable<any>
  {
    let headers = new HttpHeaders();
    console.log(this.getToken());
    headers = headers.set('Authorization', 'Bearer '+this.getToken());
    return this.http.get<User[]>(this.url+"/super",{headers});
  }
  responseForRequest(user:User):Observable<any>
  {
    let headers = new HttpHeaders();
    console.log(this.getToken());
    headers = headers.set('Authorization', 'Bearer '+this.getToken());
    return this.http.put<User>(this.url+"/super",user,{headers});
  }
  getAllProducts():Observable<any>
  {
    let headers = new HttpHeaders();
    console.log(this.getToken());
    headers = headers.set('Authorization', 'Bearer '+this.getToken());
    return this.http.get<Product[]>(this.url+"/product",{headers});
  }
  getProductByCode(code:string):Observable<any>
  {
    let headers = new HttpHeaders();
    console.log(this.getToken());
    headers = headers.set('Authorization', 'Bearer '+this.getToken());
    return this.http.get<Product[]>(this.url+"/product/"+code,{headers});
  }
  saveModifiedProduct(product:Product):Observable<any>
  {
    let headers = new HttpHeaders();
    console.log(this.getToken());
    headers = headers.set('Authorization', 'Bearer '+this.getToken());
    return this.http.put<Product>(this.url+"/product",product,{headers});
  }
  addNewProduct(product:Product):Observable<any>
  {
    let headers = new HttpHeaders();
    console.log(this.getToken());
    headers = headers.set('Authorization', 'Bearer '+this.getToken());
    return this.http.post<Product>(this.url+"/product/new",product,{headers});
  }
  deleteProduct(code:string):Observable<any>
  {
    let headers = new HttpHeaders();
    console.log(this.getToken());
    headers = headers.set('Authorization', 'Bearer '+this.getToken());
    return this.http.delete<Product[]>(this.url+"/product/"+code,{headers});
  }

  generateBill(bill:Bill):Observable<any>
  {
    let headers = new HttpHeaders();
    console.log(this.getToken());
    headers = headers.set('Authorization', 'Bearer '+this.getToken());
    return this.http.post<Product[]>(this.url+"/bill",bill,{headers});
  }
}
