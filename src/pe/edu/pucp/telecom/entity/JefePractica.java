package pe.edu.pucp.telecom.entity;

import pe.edu.pucp.telecom.entity.base.Docente;

public class JefePractica extends Docente {
    private int añoEgreso;

    public JefePractica(String codigoPUCP, String nombre, String apellido, String telefono, String anexo, String departamento, int añoIngreso, int cantidadCursos, int añoEgreso) {
        super(codigoPUCP, nombre, apellido, telefono, anexo, departamento, añoIngreso, cantidadCursos);
        this.añoEgreso = añoEgreso;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + añoEgreso;
    }

}
