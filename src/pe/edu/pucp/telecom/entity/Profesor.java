package pe.edu.pucp.telecom.entity;

import pe.edu.pucp.telecom.entity.base.Docente;

public class Profesor extends Docente {
    private String facultad;

    public Profesor(String codigoPUCP, String nombre, String apellido, String telefono, String anexo, String departamento, int añoIngreso, int cantidadCursos, String facultad) {
        super(codigoPUCP, nombre, apellido, telefono, anexo, departamento, añoIngreso, cantidadCursos);
        this.facultad = facultad;
    }
    @Override
    public String toCSV() {
        return super.toCSV() + "," + facultad;
    }
}
