import { Direccion } from "./direccion.model";

export interface Cliente extends Direccion{
    id: number;
    nombre: String;
    apellidos: String;
    dni: String;
    email: String;
    prefijo_pais: String;
    telefono: String;
}