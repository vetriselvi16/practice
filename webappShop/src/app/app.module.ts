import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './site/login/login.component';
import { SignupComponent } from './site/signup/signup.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SearchComponent } from './Product/search/search.component';
import { PendingRequestComponent } from './Manager/pending-request/pending-request.component';
import { WelcomeComponent } from './Product/welcome/welcome.component';

import { StockInfoComponent } from './Product/stock-info/stock-info.component';
import { EditProductComponent } from './Product/edit-product/edit-product.component';
import { BillingComponent } from './Product/billing/billing.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    SearchComponent,
    PendingRequestComponent,
    WelcomeComponent,
 
    StockInfoComponent,
    EditProductComponent,
    BillingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
