import { Categoria } from './categoria.model';

export interface Producto {
    id: number;
    categoria: Categoria;
    nombre_producto: string;
    descripcion_producto: string;
    precio: number;
}
