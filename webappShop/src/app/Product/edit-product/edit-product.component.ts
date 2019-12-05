import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClientService } from 'src/app/service/http-client.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/modelClass/product';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {

  product:Product;
  productForm: FormGroup;
  codeValue:string;
  flag=true;
  constructor(private formBuild: FormBuilder, private httpService: HttpClientService,private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    //this.product={code:"a1",name:"apple",type:11,brand:"a1a1",quantityType:111,ratePerQuantity:11,stockCount:111,addDate:new Date("2323/03/03"),aisle:"a1",shelf:"1",dateOfManufacture:new Date("2323/03/03"),dateOfExpiry:new Date("2323/03/03"),image:"https://images.unsplash.com/photo-1528735602780-2552fd46c7af"}
    let code = this.route.snapshot.paramMap.get('code')
     if(code!='null')
     {
       console.log(code)
      
    
    this.httpService.getProductByCode(code).subscribe(
      (data) =>
      {
        data.addDate = new Date(data.addDate)
        data.dateOfManufacture=new Date(data.dateOfManufacture)
        data.dateOfExpiry=new Date(data.dateOfExpiry)
        this.product = data;
        this.formGroupDeclaration();  
        console.log(data)
      },
      (error)=>
      {
        console.log(error);
      }
    )
  }
    this.codeValue="null"
    this.product={code:"",name:"",type:null,brand:"",quantityType:null,ratePerQuantity:null,stockCount:null,addDate:new Date(),aisle:"",shelf:"",dateOfManufacture:new Date(),dateOfExpiry:new Date(),image:""}
    this.formGroupDeclaration();
  }

  formGroupDeclaration()
  {
    this.productForm = this.formBuild.group({  
      name: [this.product.name, [
        Validators.required,
        Validators.minLength(1),
        Validators.maxLength(50)
      ]],
       code: [this.product.code, [
       Validators.required,
         Validators.minLength(1),
         Validators.maxLength(50)
       ]],
      type: [this.product.type, [
        Validators.required
      ]],
      brand: [this.product.brand, [
        Validators.required,
        Validators.minLength(1),
        Validators.maxLength(50)
      ]],
      quantityType:[this.product.quantityType,[
        Validators.required
      ]],
      ratePerQuantity: [this.product.ratePerQuantity, [
        Validators.required
      ]],
      stockCount: [this.product.stockCount, [
        Validators.required
      ]],
      addDate: [this.product.addDate.toISOString().substring(0,10), [
        Validators.required
      ]],
      aisle: [this.product.aisle, [
        Validators.required,
        Validators.minLength(1),
        Validators.maxLength(15)
      ]],
      shelf: [this.product.shelf, [
        Validators.required,
        Validators.minLength(1),
        Validators.maxLength(15)
      ]],
      dateOfManufacture: [this.product.dateOfManufacture.toISOString().substring(0,10), [
        Validators.required
      ]],
      dateOfExpiry: [this.product.dateOfExpiry.toISOString().substring(0,10), [
        Validators.required
      ]],
      image: [this.product.image, [
        Validators.required
      ]]
    })
  }

  /*formGroupDeclaration2()
  {
    this.productForm = this.formBuild.group({  
      name: [null, [
        Validators.required,
        Validators.minLength(1),
        Validators.maxLength(50)
      ]],
       code: [null, [
         Validators.required,
         Validators.minLength(1),
         Validators.maxLength(50)
       ]],
      type: [null, [
        Validators.required
      ]],
      brand: [null, [
        Validators.required,
        Validators.minLength(1),
        Validators.maxLength(50)
      ]],
      quantityType:[null,[
        Validators.required
      ]],
      ratePerQuantity: [null, [
        Validators.required
      ]],
      stockCount: [null, [
        Validators.required
      ]],
      addDate: [null, [
        Validators.required
      ]],
      aisle: [null, [
        Validators.required,
        Validators.minLength(1),
        Validators.maxLength(15)
      ]],
      shelf: [null, [
        Validators.required,
        Validators.minLength(1),
        Validators.maxLength(15)
      ]],
      dateOfManufacture: [null, [
        Validators.required
      ]],
      dateOfExpiry: [null, [
        Validators.required
      ]],
      image: [null, [
        Validators.required
      ]]
    })
  }*/



   get code() {
     return this.productForm.get('code');
   }
  get name() {
    return this.productForm.get('name');
  }
  get type() {
    return this.productForm.get('type');
  }
  get brand() {
    return this.productForm.get('brand');
  }
  get quantityType(){
    return this.productForm.get('quantityType');
  }
  get ratePerQuantity() {
    return this.productForm.get('ratePerQuantity');
  }
  get stockCount() {
    return this.productForm.get('stockCount');
  }
  get addDate() {
    return this.productForm.get('addDate');
  }
  get aisle() {
    return this.productForm.get('aisle');
  }
  get shelf() {
    return this.productForm.get('shelf');
  }
  get dateOfManufacture() {
    return this.productForm.get('dateOfManufacture');
  }
  get dateOfExpiry() {
    return this.productForm.get('dateOfExpiry');
  }
  get image() {
    return this.productForm.get('image');
  }
  onSubmit() {
    console.profileEnd("onSubmit")
    let newProduct: Product = {
      code: this.productForm.value["code"], name: this.productForm.value["name"],
      type: +this.productForm.value["type"], brand: this.productForm.value["brand"],quantityType:+this.productForm.value["quantityType"],
      ratePerQuantity: this.productForm.value["ratePerQuantity"], stockCount: +this.productForm.value["stockCount"],
      addDate: new Date(this.productForm.value["addDate"]), aisle: this.productForm.value["aisle"],
      shelf: this.productForm.value["shelf"], dateOfManufacture: new Date(this.productForm.value["dateOfManufacture"]),
      dateOfExpiry: new Date(this.productForm.value["dateOfExpiry"]), image: this.productForm.value["image"]
    }
    if(this.codeValue!="null")
    {
      this.httpService.saveModifiedProduct(newProduct).subscribe(
        (data)=>
        {
          console.log(data)
          this.router.navigate(['search-bar'])
        }
      )
    }
    else
    {
      this.httpService.addNewProduct(newProduct).subscribe(
        (data)=>
        {
          console.log(data)
          this.router.navigate(['search-bar'])
        }
      )
    }
    
    this.flag = false
  }






}
