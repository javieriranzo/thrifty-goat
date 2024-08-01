import { Cliente } from './cliente.model';
import { Producto } from './producto.model';

export interface ClienteProducto {
    cliente: Cliente;
    producto: Producto;
}
