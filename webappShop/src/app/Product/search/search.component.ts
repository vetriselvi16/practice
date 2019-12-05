import { Component, OnInit } from '@angular/core';
import { HttpClientService } from 'src/app/service/http-client.service';
import { Product } from 'src/app/modelClass/product';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  products:Product[];
  listOfProduct:Product[];
  searchKey: string;
  sortKey: string;

  constructor(private httpService:HttpClientService) { }


  ngOnInit() {
    this.httpService.getAllProducts().subscribe(
      (data:Product[]) =>
      {
        for(let pro of data)
        {
          pro.addDate = new Date(pro.addDate)
          pro.dateOfManufacture = new Date(pro.dateOfManufacture)
          pro.dateOfExpiry = new Date(pro.dateOfExpiry)
        }
        this.listOfProduct=data;
        this.products = this.listOfProduct;
      }
    )
  }

  search()
  {
    console.log("search")
    this.products = this.listOfProduct.filter(pro=>pro.name.toLocaleLowerCase().includes(this.searchKey.toLocaleLowerCase()));
    this.httpService.getSubject().next(this.products)
  }

  sortFunction()
  {
    if (this.sortKey == "name") 
    {
      this.products = this.products.sort((a: Product, b: Product): number => {
        if (a.name > b.name)
          return 1;
        else
          return -1;
      })
      this.httpService.getSubject().next(this.products)
    }
    if (this.sortKey == "stock") {
      this.products = this.products.sort((a: Product, b: Product): number => {
        if (a.stockCount > b.stockCount)
          return 1;
        else
          return -1;
      })
      for(let pro of this.products)
      {
        console.log(pro.stockCount)
      }
      this.httpService.getSubject().next(this.products)
    }

    if (this.sortKey == "price") {
      this.products = this.products.sort((a: Product, b: Product): number => {
        if (a.ratePerQuantity > b.ratePerQuantity)
          return 1;
        else
          return -1;
      })
      this.httpService.getSubject().next(this.products)
    }

  }
}
