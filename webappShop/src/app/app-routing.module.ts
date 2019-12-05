import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './site/login/login.component';
import { SignupComponent } from './site/signup/signup.component';
import { SearchComponent } from './Product/search/search.component';
import { PendingRequestComponent } from './Manager/pending-request/pending-request.component';
import { WelcomeComponent } from './Product/welcome/welcome.component';
import { EditProductComponent } from './Product/edit-product/edit-product.component';
import { AuthGaurdService } from './service/auth-gaurd.service';
import { BillingComponent } from './Product/billing/billing.component';


const routes: Routes = [
  { path: 'login',component: LoginComponent},
  { path: 'signup', component: SignupComponent},
  { path: 'search-bar',component: SearchComponent},
  {path: 'pending-request',component:PendingRequestComponent},
  {path: 'welcome',component:WelcomeComponent},
  {path: 'edit/:code',component:EditProductComponent},
  {path: 'billing' , component:BillingComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
