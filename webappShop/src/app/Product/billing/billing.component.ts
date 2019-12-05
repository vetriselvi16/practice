import { Component, OnInit } from '@angular/core';
import { HttpClientService } from 'src/app/service/http-client.service';
import { Product } from 'src/app/modelClass/product';
import { Bill } from 'src/app/modelClass/bill';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { User } from 'src/app/modelClass/user';

@Component({
  selector: 'app-billing',
  templateUrl: './billing.component.html',
  styleUrls: ['./billing.component.css']
})
export class BillingComponent implements OnInit {

  form:FormGroup;
  number:boolean;
  product:Product[];
  //quantityKey:number;
  filterKey:number;
  codeKey:string;
  //contactKey:number;
  totalAmount:number=0;
  add:boolean=false;
  filteredList:Product[];
  billing:Bill={code:[],quantity:[],totalAmount:null,contactNumber:null};
  amount: number;
  constructor(private httpService:HttpClientService, private formBuilder:FormBuilder) { }

  ngOnInit() {
    this.httpService.getAllProducts().subscribe(
      (data:Product[])=>
      {
        for(let pro of data)
        {
          pro.addDate=new Date(pro.addDate)
          pro.dateOfManufacture=new Date(pro.dateOfManufacture)
          pro.dateOfExpiry=new Date( pro.dateOfExpiry)
        }
        this.filteredList = data;
        this.product=this.filteredList;
      }
    )
    this.form=this.formBuilder.group({
      contactNumber:['',[
        Validators.required,
        Validators.minLength(10),
        Validators.maxLength(10)
      ]],
      quantity:['',[
        Validators.required,
        //Validators.maxLength(15)
      ]]
    })
  }

  filterFunction()
  {
    this.product = this.filteredList.filter(pro=>pro.type == this.filterKey)
    for(let pro of this.product)
    {
      console.log(pro.name)
    }
  }

  codeSearch()
  {
    this.product = this.filteredList.filter(pro=>pro.code.toLocaleLowerCase() == this.codeKey.toLocaleLowerCase());
  }

  get contactNumber() {
    return this.form.get('contactNumber');
  }
  get quantity() {
    return this.form.get('quantity');
  }

  bill(code:string,rate:number)
  {
    console.log(code)
    console.log(rate)
    console.log(this.form.value["quantity"])
    this.amount=(rate*this.form.value["quantity"])
    console.log(this.amount)
    this.totalAmount=this.totalAmount+this.amount
    console.log(this.totalAmount)
    this.billing.code.push(code)
    this.billing.quantity.push(this.form.value["quantity"]);
    this.form.value["quantity"]=null;
  }

  

  submit()
  {
    this.billing.totalAmount=this.totalAmount;
    this.billing.contactNumber=this.form.value["contactNumber"];
    console.log(this.billing)
    this.httpService.generateBill(this.billing).subscribe(
      (data)=>
      {
        console.log("inSumbit")
      }
    )
    this.form.value["contactNumber"]=null;
    this.amount=null;
    this.totalAmount=null;
    this.ngOnInit()
  }
  /*products:Product[];
  productsC:Product[];
  code1:string;
  user:User[];
  isBill:boolean=false;
  isItem1:boolean=false;
  isItem:boolean=false;
  searchTypeKey:string;
  searchCodeKey:string;
  searchCodeList:Product[];
  searchTypeList:Product[];
  totalKey:number;
  tot:number;
  form:FormGroup;
  quant1:number;
  rpq2:number;
  bill1:Bill[];
  billing:Bill={code:[],quantity:[],totalAmount:null,contactNumber:null};
  totalAmount:number=0;

  constructor(private formBuilder:FormBuilder,private productService:HttpClientService) { }

  ngOnInit() {
  this.list();
this.form=this.formBuilder.group({
  contactNumber:['',[
    Validators.required,
    Validators.minLength(10),
    Validators.maxLength(10)
  ]],
  total_amount:['',[
    Validators.required,
  ]],
  quantity:['',[
    Validators.required,
    Validators.maxLength(15)
  ]]
})
}
list(){
  this.productService.getAllProducts().subscribe(
    data=>{
      this.productsC=data;
      this.products=this.productsC;

    }
  )
}
get contactNumber() {
  return this.form.get('contactNumber');
}
get total_amount() {
  return this.form.get('total_amount');
}
get quantity() {
  return this.form.get('quantity');
}
searchByType(){
  this.products=this.productsC.filter(item=>item.code.includes(this.searchCodeKey));
}
searchByCode(){
  this.products=this.productsC.filter(item=>item.code.toLocaleLowerCase().includes(this.searchCodeKey.toLocaleLowerCase()));  
}
submit(code:string,rpq1:number){
  console.log("in item submit method")
  this.code1=code;
  this.rpq2=rpq1;
  this.quant1=this.form.value["quantity"];
  this.tot=(this.quant1*this.rpq2);
  console.log(this.tot);
  this.totalAmount=this.totalAmount+this.tot;
  console.log(this.totalAmount);
  this.billing.code.push(code);
  this.billing.quantity.push(this.quant1);
  this.quant1=0;
  this.isItem1=true;
}
generate(){
  console.log("in bill generate");

  this.billing.totalAmount=this.totalAmount;
  this.billing.contactNumber=this.form.value["contactNumber"];
  console.log("this.billing.contact");
  console.log(this.billing)
  this.productService.generateBill(this.billing).subscribe(
    data=>{
      console.log("in generate bill.ts");
    }
  )
  this.tot=0;
  this.totalAmount=0;
  this.list();
  this.isBill=true;

}
*/

}
