import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MenuGeneralComponent } from './components/menu-general/menu-general.component';
import { ClientesComponent } from './components/clientes/clientes.component';
import { ProductosComponent } from './components/productos/productos.component';
import { FacturacionComponent } from './components/facturacion/facturacion.component';
import { CerrarSesionComponent } from './components/cerrar-sesion/cerrar-sesion.component';
import { FooterComponent } from './components/footer/footer.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  standalone: true,
  imports: [
    RouterOutlet,
    MenuGeneralComponent,
    ClientesComponent,
    ProductosComponent,
    FacturacionComponent,
    CerrarSesionComponent,
    FooterComponent,
  ],
})
export class AppComponent {
  title = 'MIRANZO DESIGNS';
}
