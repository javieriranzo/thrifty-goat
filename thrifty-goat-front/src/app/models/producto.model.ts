import { CategoriaProducto } from "./categoria-producto.model";

export interface Producto extends CategoriaProducto {
    id: number;
    nombre_producto: String;
    descripcion_producto: String;
    precio: number; 
}