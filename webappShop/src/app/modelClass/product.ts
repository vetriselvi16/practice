export interface Product
{
    code:string;
    name:string;
    type:number;
    brand:string;
    quantityType:number;
    ratePerQuantity:number;
    stockCount:number;
    addDate:Date;
    aisle:string;
    shelf:string;
    dateOfManufacture:Date;
    dateOfExpiry:Date;
    image:string;
}