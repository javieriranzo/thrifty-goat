import { Routes } from '@angular/router';
import { ClientesComponent } from './components/clientes/clientes.component';
import { ProductosComponent } from './components/productos/productos.component';
import { FacturacionComponent } from './components/facturacion/facturacion.component';
import { CerrarSesionComponent } from './components/cerrar-sesion/cerrar-sesion.component';

export const routes: Routes = [
  { path: 'clientes', component: ClientesComponent },
  { path: 'productos', component: ProductosComponent },
  { path: 'facturacion', component: FacturacionComponent },
  { path: 'cerrar-sesion', component: CerrarSesionComponent },
  { path: '', redirectTo: '/clientes', pathMatch: 'full' },
];
