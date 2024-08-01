import { Direccion } from './direccion.model';

export interface Cliente {
    id: number;
    nombre: string;
    apellidos: string;
    dni: string;
    email: string;
    prefijo_pais?: string;
    telefono: string;
    direccion: Direccion;
}
