import { Component } from '@angular/core';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent {

  nuevaTarea = {
    nombre: '',
    descripcion: '',
    prioridad: ''
  };

  tareas = [];

  agregarTarea() {
    this.nuevaTarea = {
      nombre: '',
      descripcion: '',
      prioridad: ''
    };
  }

}

