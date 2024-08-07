import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Cliente } from '../../models/cliente.model';

@Component({
  selector: 'app-modal-editar-cliente',
  templateUrl: './modal-editar-cliente.component.html',
  styleUrls: ['./modal-editar-cliente.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule],
})
export class ModalEditarClienteComponent {
  @Input() cliente: Cliente | null = null;
  @Output() clienteActualizado = new EventEmitter<Cliente>();
  @Output() modalCerrar = new EventEmitter<void>();

  guardarCambios() {
    if (this.cliente) {
      this.clienteActualizado.emit(this.cliente);
      this.modalCerrar.emit();
    }
  }

  cerrarModal() {
    this.modalCerrar.emit();
  }
}
