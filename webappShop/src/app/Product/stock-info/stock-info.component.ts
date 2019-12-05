import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Product } from 'src/app/modelClass/product';
import { AuthService } from 'src/app/service/auth.service';
import { HttpClientService } from 'src/app/service/http-client.service';

@Component({
  selector: 'app-stock-info',
  templateUrl: './stock-info.component.html',
  styleUrls: ['./stock-info.component.css']
})
export class StockInfoComponent implements OnInit {

  product:Product[];
  //@Output() deleteClicked = new EventEmitter();
  isAdmin:boolean;
  constructor(private authService:AuthService,private httpService:HttpClientService) { }

  ngOnInit() {
    this.isAdmin = this.authService.isAdmin;
    console.log(this.isAdmin)
    this.httpService.getAllProducts().subscribe(
      (data:Product[])=>
      {
        for(let pro of data)
        {
          pro.addDate=new Date(pro.addDate)
          pro.dateOfManufacture=new Date(pro.dateOfManufacture)
          pro.dateOfExpiry=new Date( pro.dateOfExpiry)
        }
        this.product=data;
        this.getData();
      }
    )
  }

  getData()
  {
    this.httpService.getSubject().subscribe(
      (data)=>
      {
        this.product=data;
      }
    )
  }

  delete(code:string)
  {
    console.log(code)
    this.httpService.deleteProduct(code).subscribe(
      (data)=>
      {
        console.log(data)
        data=this.ngOnInit();
        
      }
    )
    //this.ngOnInit();
  }

}

