import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginScreenComponent } from './login-screen/login-screen.component';
import { HomeScreenComponent } from './home-screen/home-screen.component';
import { CustomersScreenComponent } from './customers-screen/customers-screen.component';
import { ProductsScreenComponent } from './products-screen/products-screen.component';
import { BillingScreenComponent } from './billing-screen/billing-screen.component';
import { TodoListComponent } from './todo-list/todo-list.component';
import { NavbarMenuComponent } from './navbar-menu/navbar-menu.component';
import { FormsModule } from '@angular/forms';
import { PopUpLogoutComponent } from './pop-up-logout/pop-up-logout.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginScreenComponent,
    HomeScreenComponent,
    CustomersScreenComponent,
    ProductsScreenComponent,
    BillingScreenComponent,
    TodoListComponent,
    NavbarMenuComponent,
    PopUpLogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
