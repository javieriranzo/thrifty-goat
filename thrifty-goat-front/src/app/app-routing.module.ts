import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomersScreenComponent } from './customers-screen/customers-screen.component';
import { ProductsScreenComponent } from './products-screen/products-screen.component';
import { BillingScreenComponent } from './billing-screen/billing-screen.component';
import { TodoListComponent } from './todo-list/todo-list.component';

const routes: Routes = [
  { path: 'clientes', component: CustomersScreenComponent },
  { path: 'productos', component: ProductsScreenComponent },
  { path: 'facturacion', component: BillingScreenComponent },
  { path: 'tareas', component: TodoListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
