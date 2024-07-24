import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Cliente } from '../../models/cliente.model';
import { ModalEliminarComponent } from '../modal-eliminar/modal-eliminar.component';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule, ModalEliminarComponent],
})

export class ClientesComponent {

  showModal = false;
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

  clienteSeleccionado!: Cliente;

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

}
