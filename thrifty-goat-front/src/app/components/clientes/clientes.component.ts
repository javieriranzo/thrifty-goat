import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Cliente } from '../../models/cliente.model';
import { ModalEliminarComponent } from '../modal-eliminar/modal-eliminar.component';
import { ModalEditarClienteComponent } from '../modal-editar-cliente/modal-editar-cliente.component';
import { Direccion } from '../../models/direccion.model';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule, ModalEliminarComponent, ModalEditarClienteComponent]
})

export class ClientesComponent {
  
  clientes: Cliente[] = [
    {
      id: 1,
      nombre: 'Juan',
      apellidos: 'Perez',
      dni: '44852146Z',
      email: 'juan.perez@example.com',
      prefijo_pais: '+34',
      telefono: '123456789',
      direccion: 'Calle Conde Altea, 16',
      ciudad: 'Valencia',
      provincia: 'Valencia',
      codigo_postal: '46135',
      pais: 'España'
    },
    {
      id: 2,
      nombre: 'Javier',
      apellidos: 'Iranzo',
      dni: '45910615Q',
      email: 'javier.iranzo@example.com',
      prefijo_pais: '+34',
      telefono: '666305652',
      direccion: 'Calle Gran Vía, 18',
      ciudad: 'Valencia',
      provincia: 'Valencia',
      codigo_postal: '46135',
      pais: 'España'
    },
  ];


  /* Eliminado de cliente */

  clienteSeleccionado: Cliente | null = null;
  showModalEliminar = false;

  eliminarCliente() {
    this.clientes = this.clientes.filter(c => c !== this.clienteSeleccionado);
    this.clienteSeleccionado = {} as Cliente; // Resetear cliente seleccionado
    this.cerrarModalEliminar();
  }

  /* Modal eliminado de cliente */

  abrirModalEliminar(cliente: Cliente) {
    this.clienteSeleccionado = cliente;
    this.showModalEliminar = true;
  }

  cerrarModalEliminar() {
    this.showModalEliminar = false;
  }

  /* Editado de cliente */ 

  clienteActualizado: Cliente | null = null;
  showModalEditar = false;

  actualizarCliente(clienteActualizado: Cliente) {
    const index = this.clientes.findIndex(c => c.id === clienteActualizado.id);
    if (index !== -1) {
      this.clientes[index] = clienteActualizado;
      this.filterClientes();
    }
    this.cerrarModalEditar();
  }

  /* Modal editado de cliente */

  abrirModalEditar(cliente: Cliente) {
    this.clienteSeleccionado = cliente;
    this.showModalEditar = true;
  }

  cerrarModalEditar() {
    this.showModalEditar = false;
  }

  /* Filtrado de clientes */

  filter = {
    nombre: '',
    apellido: '',
    dni: '',
    email: '',
    telefono: '',
    pais: '',
    provincia: '',
    ciudad: '',
    codigo_postal: ''
  };

  filteredClientes: Cliente[] = [];

  constructor() {
    this.filteredClientes = this.clientes;
  }

  selectedFilterCategory = 'personales';

  limpiarFiltros() {
    this.filter = {
      nombre: '',
      apellido: '',
      dni: '',
      email: '',
      telefono: '',
      pais: '',
      provincia: '',
      ciudad: '',
      codigo_postal: ''
    };
    this.filterClientes(); // Actualizar la lista de clientes filtrados después de limpiar los filtros
  }

  filterClientes() {
    this.filteredClientes = this.clientes.filter(cliente => {
      const nombreMatch = cliente.nombre.toLowerCase().includes(this.filter.nombre.toLowerCase());
      const apellidoMatch = cliente.apellidos.toLowerCase().includes(this.filter.apellido.toLowerCase());
      const dniMatch = cliente.dni.toLowerCase().includes(this.filter.dni.toLowerCase());
      const emailMatch = cliente.email.toLowerCase().includes(this.filter.email.toLowerCase());
      const telefonoMatch = cliente.telefono.includes(this.filter.telefono);
      const paisMatch = cliente.pais.toLowerCase().includes(this.filter.pais.toLowerCase());
      const provinciaMatch = cliente.provincia.toLowerCase().includes(this.filter.provincia.toLowerCase());
      const ciudadMatch = cliente.ciudad.toLowerCase().includes(this.filter.ciudad.toLowerCase());
      const codigoPostalMatch = cliente.codigo_postal.includes(this.filter.codigo_postal);

      return nombreMatch && apellidoMatch && dniMatch && emailMatch && telefonoMatch &&
             paisMatch && provinciaMatch && ciudadMatch && codigoPostalMatch;
    });
  }

}
