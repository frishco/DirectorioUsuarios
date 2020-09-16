package pe.edu.pucp.telecom.entity.base;

public class Usuario {
    private String codigoPUCP;
    private String nombre;
    private String apellido;
    private String telefono;
    private String anexo;
    private String departamento;

    public Usuario(String codigoPUCP, String nombre, String apellido, String telefono, String anexo, String departamento) {
        this.codigoPUCP = codigoPUCP;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.anexo = anexo;
        this.departamento = departamento;
    }

    public String getCodigoPUCP() {
        return codigoPUCP;
    }

    public void setCodigoPUCP(String codigoPUCP) {
        this.codigoPUCP = codigoPUCP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }


    public String toCSV() {
        return codigoPUCP + "," + nombre + "," + apellido + "," + telefono +
                "," + anexo + "," + departamento;
    }
}
