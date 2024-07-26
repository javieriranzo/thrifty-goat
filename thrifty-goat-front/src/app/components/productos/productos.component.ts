import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Producto } from '../../models/producto.model';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule],
})
export class ProductosComponent {

  /* Filtrado de productos */

  productos: Producto[] = [
    {
      id: 1, 
      nombre_producto: 'Producto Prueba 1',
      descripcion_producto: 'Descripcion Producto Prueba 1',
      precio: 10,
      nombre_categoria: 'Categoría A',
      descripcion_categoria: 'Descripcion Categoria Prueba 1'
    }, 
    {
      id: 2, 
      nombre_producto: 'Producto Prueba 2',
      descripcion_producto: 'Descripcion Producto Prueba 2',
      precio: 20,
      nombre_categoria: 'Categoría B',
      descripcion_categoria: 'Descripcion Categoria Prueba 2'
    }
  ]

  filter = {
    nombre_producto: '',
    descripcion_producto: '',
    precio:'',
    nombre_categoria: ''
  };

  filteredProductos: Producto[] = [];

  constructor() {
    this.filteredProductos = this.productos;
  }

  selectedFilterCategory = 'personales';

  limpiarFiltros() {
    this.filter = {
      nombre_producto: '',
      descripcion_producto: '',
      precio:'',
      nombre_categoria: ''
    };
    this.filterProductos(); // Actualizar la lista de productos filtrados después de limpiar los filtros
  }

  filterProductos() {
    this.filteredProductos = this.productos.filter(producto => {
      const nombreCategoriaProductoMatch = producto.nombre_categoria.toLowerCase().includes(this.filter.nombre_categoria.toLowerCase());
      const nombreProductoMatch = producto.nombre_producto.toLowerCase().includes(this.filter.nombre_producto.toLowerCase());
      const descripcionProductoMatch = producto.descripcion_producto.toLowerCase().includes(this.filter.descripcion_producto.toLowerCase());
      const precioProductoMatch = producto.precio.toString().includes(this.filter.precio.toString());

      return nombreCategoriaProductoMatch && nombreProductoMatch && descripcionProductoMatch && precioProductoMatch 
    });
  }

}
