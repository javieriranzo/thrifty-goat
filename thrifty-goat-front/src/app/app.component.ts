import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MenuGeneralComponent } from './components/menu-general/menu-general.component';
import { ClientesComponent } from './components/clientes/clientes.component';
import { ProductosComponent } from './components/productos/productos.component';
import { FacturacionComponent } from './components/facturacion/facturacion.component';
import { CerrarSesionComponent } from './components/cerrar-sesion/cerrar-sesion.component';
import { FooterComponent } from './components/footer/footer.component';
import { ModalEditarClienteComponent } from './components/modal-editar-cliente/modal-editar-cliente.component';
import { ModalEliminarComponent } from './components/modal-eliminar/modal-eliminar.component';

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
    ModalEditarClienteComponent,
    ModalEliminarComponent
  ],
})
export class AppComponent {
  title = 'MIRANZO DESIGNS';
}
