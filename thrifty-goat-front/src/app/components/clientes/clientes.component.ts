import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Cliente } from '../../models/cliente.model';
import { ModalEliminarComponent } from '../modal-eliminar/modal-eliminar.component';
import { ModalEditarClienteComponent } from '../modal-editar-cliente/modal-editar-cliente.component';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule, ModalEliminarComponent, ModalEditarClienteComponent],
})

export class ClientesComponent {

  showModal = false;
  showModalEditar = false;
  selectedFilterCategory = 'personales';

  filter = {
    nombre: '',
    apellido: '',
    dni: '',
    email: '',
    telefono: '',
    pais: '',
    provincia: '',
    ciudad: '',
    codigoPostal: ''
  };

  clientes: Cliente[] = [
    {
      id: 1,
      nombre: 'Juan',
      apellidos: 'Perez',
      dni: '44852146Z',
      email: 'juan.perez@example.com',
      telefono: '123456789',
      pais: 'España',
      provincia: 'Valencia',
      ciudad: 'Valencia',
      codigoPostal: '46135'
    },
    {
      id: 2,
      nombre: 'Javier',
      apellidos: 'Iranzo',
      dni: '45910615Q',
      email: 'javier.iranzo@example.com',
      telefono: '666305652',
      pais: 'España',
      provincia: 'Valencia',
      ciudad: 'Albalat dels Sorells',
      codigoPostal: '46135'
    },
  ];

  clienteSeleccionado: Cliente | null = null;

  ngOnInit() {
    console.log('Component initialized');
    console.log('Clientes:', this.clientes);
  }

  abrirModalEliminar(cliente: Cliente) {
    this.clienteSeleccionado = cliente;
    this.showModal = true;
  }

  eliminarCliente() {
    this.clientes = this.clientes.filter(c => c !== this.clienteSeleccionado);
    this.clienteSeleccionado = {} as Cliente; // Resetear cliente seleccionado
    this.cerrarModal();
  }

  cerrarModal() {
    this.showModal = false;
  }

  filteredClientes: Cliente[] = [];

  constructor() {
    this.filteredClientes = this.clientes;
  }

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
      codigoPostal: ''
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
      const codigoPostalMatch = cliente.codigoPostal.includes(this.filter.codigoPostal);

      return nombreMatch && apellidoMatch && dniMatch && emailMatch && telefonoMatch &&
             paisMatch && provinciaMatch && ciudadMatch && codigoPostalMatch;
    });
  }

  abrirModalEditar(cliente: Cliente) {
    console.log('Opening edit modal');
    console.log('Cliente a editar:', cliente);
    this.clienteSeleccionado = cliente;
    this.showModalEditar = true;
  }

  actualizarCliente(clienteActualizado: Cliente) {
    console.log('Updating client');
    console.log('Cliente actualizado:', clienteActualizado);
    const index = this.clientes.findIndex(c => c.id === clienteActualizado.id);
    if (index !== -1) {
      this.clientes[index] = clienteActualizado;
      this.filterClientes();
    }
    this.cerrarModalEditar();
  }

  cerrarModalEditar() {
    console.log('Closing edit modal');
    this.showModalEditar = false;
  }

}
