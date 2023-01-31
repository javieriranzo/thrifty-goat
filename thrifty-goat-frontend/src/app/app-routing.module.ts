import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ThriftyGoatLoginComponent } from './thrifty-goat-login/thrifty-goat-login.component'; 

const routes: Routes = [
  {path: 'Login', component: ThriftyGoatLoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
