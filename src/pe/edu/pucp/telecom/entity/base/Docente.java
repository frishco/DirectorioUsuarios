package pe.edu.pucp.telecom.entity.base;

public class Docente extends Usuario {
    private int añoIngreso;
    private int cantidadCursos;

    public Docente(String codigoPUCP, String nombre, String apellido, String telefono, String anexo, String departamento, int añoIngreso, int cantidadCursos) {
        super(codigoPUCP, nombre, apellido, telefono, anexo, departamento);
        this.añoIngreso = añoIngreso;
        this.cantidadCursos = cantidadCursos;
    }

    public int getAñoIngreso() {
        return añoIngreso;
    }

    public void setAñoIngreso(int añoIngreso) {
        this.añoIngreso = añoIngreso;
    }

    public int getCantidadCursos() {
        return cantidadCursos;
    }

    public void setCantidadCursos(int cantidadCursos) {
        this.cantidadCursos = cantidadCursos;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + añoIngreso + "," + cantidadCursos;
    }
}
