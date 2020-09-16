package pe.edu.pucp.telecom.entity;

import pe.edu.pucp.telecom.entity.base.Usuario;

public class PersonalAdministrativo extends Usuario {
    private String cargo;

    public PersonalAdministrativo(String codigoPUCP, String nombre, String apellido, String telefono, String anexo, String departamento, String cargo) {
        super(codigoPUCP, nombre, apellido, telefono, anexo, departamento);
        this.cargo = cargo;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + cargo;
    }
}
