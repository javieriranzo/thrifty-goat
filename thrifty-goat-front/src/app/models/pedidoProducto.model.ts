import { Producto } from './producto.model';

export interface PedidoProducto {
    id: number;
    producto: Producto;
    cantidad: number;
}
