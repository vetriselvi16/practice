import { Injectable } from '@angular/core';
import { CanActivate, RouterStateSnapshot, ActivatedRouteSnapshot, Router } from '@angular/router';
import { AuthService } from './auth.service';
import { Observable, Observer } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGaurdService implements CanActivate{

path: import("@angular/router").ActivatedRouteSnapshot[];
route: import("@angular/router").ActivatedRouteSnapshot;
constructor(private authService: AuthService, private router:Router) { }
canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
// retain the url that is requested for authorization
this.authService.redirectUrl = state.url;

console.log('URL', state.url);
return Observable.create((observer: Observer<boolean>) => {
if (this.authService.loggedIn) {
console.log('Logged in');
observer.next(true);
} else {
console.log('Not Logged in');
this.router.navigate(['login'], { queryParams: { from: state.url.substr(1) } });
}
});
} 
}
