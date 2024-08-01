import { Cliente } from './cliente.model';
import { Producto } from './producto.model';
import { Direccion } from './direccion.model';
import { EstadoPedido } from './estadoPedido.model';

export interface Pedido {
    id: number;
    cliente: Cliente;
    producto: Producto;
    direccion: Direccion;
    estado: EstadoPedido;
    fecha_inicio: Date;
    fecha_finalizacion: Date;
}
