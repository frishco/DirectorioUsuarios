package pe.edu.pucp.telecom.entity;

import pe.edu.pucp.telecom.entity.base.Docente;

public class Instructor extends Docente {
    private short cicloActual;

    public Instructor(String codigoPUCP, String nombre, String apellido, String telefono, String anexo, String departamento, int añoIngreso, int cantidadCursos, short cicloActual) {
        super(codigoPUCP, nombre, apellido, telefono, anexo, departamento, añoIngreso, cantidadCursos);
        this.cicloActual = cicloActual;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + cicloActual;
    }
}
