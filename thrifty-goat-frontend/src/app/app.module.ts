import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ThriftyGoatSidenavComponent } from './thrifty-goat-sidenav/thrifty-goat-sidenav.component';
import { ThriftyGoatLoginComponent } from './thrifty-goat-login/thrifty-goat-login.component';

@NgModule({
  declarations: [
    AppComponent,
    ThriftyGoatSidenavComponent,
    ThriftyGoatLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
