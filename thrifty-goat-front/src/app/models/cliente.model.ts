import { Direccion } from "./direccion.model";

export interface Cliente extends Direccion {
    id: number;
    nombre: String;
    apellidos: String;
    dni: String;
    email: String;
    telefono: String;
}