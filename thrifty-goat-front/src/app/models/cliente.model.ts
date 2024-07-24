import { Direccion } from "./direccion.model";

export interface Cliente extends Direccion {
    nombre: String;
    apellidos: String;
    dni: String;
    email: String;
    telefono: String;
}