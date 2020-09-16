package pe.edu.pucp.telecom.util;

import pe.edu.pucp.telecom.entity.Instructor;
import pe.edu.pucp.telecom.entity.JefePractica;
import pe.edu.pucp.telecom.entity.PersonalAdministrativo;
import pe.edu.pucp.telecom.entity.Profesor;
import pe.edu.pucp.telecom.entity.base.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public Usuario datosUsuario(Scanner sc) {
        System.out.println("Ingrese los datos del usuario:");

        System.out.println("Código PUCP:");
        String codigoPUCP = sc.nextLine();
        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Apellido:");
        String apellido = sc.nextLine();
        System.out.println("Teléfono:");
        String telefono = sc.nextLine();
        System.out.println("Anexo:");
        String anexo = sc.nextLine();
        System.out.println("Departamento:");
        String departamento = sc.nextLine();

        System.out.println("Seleccione el tipo de usuario a agregar");
        System.out.println("1. Docente\n" +
                "2. Personal Administrativo\n"+
                "3. Cancelar\n");
        System.out.print("Seleccione la opción correspondiente: ");
        int option = Integer.parseInt(sc.nextLine());
        init:
        switch(option) {
            case 1:
                System.out.println("Año de ingreso:");
                int ingreso = Integer.parseInt(sc.nextLine());
                System.out.println("Cantidad de cursos:");
                short cursos = Short.parseShort(sc.nextLine());

                System.out.println("Seleccione el tipo de usuario a agregar");
                System.out.println("1. Profesor\n" +
                        "2. JP\n"+
                        "3. Instructor\n");
                int optionDocente = Integer.parseInt(sc.nextLine());
                switch(optionDocente) {
                    case 1:
                        System.out.println("Facultad:");
                        String facultad = sc.nextLine();
                        return new Profesor(codigoPUCP, nombre, apellido, telefono, anexo, departamento, ingreso, cursos, facultad);
                    case 2:
                        System.out.println("Año de egreso:");
                        int egreso = Integer.parseInt(sc.nextLine());
                        return new JefePractica(codigoPUCP, nombre, apellido, telefono, anexo, departamento, ingreso, cursos, egreso);
                    case 3:
                        System.out.println("Ciclo Actual:");
                        short ciclo = Short.parseShort(sc.nextLine());
                        return new Instructor(codigoPUCP, nombre, apellido, telefono, anexo, departamento, ingreso, cursos, ciclo);
                    default:
                        break init;
                }
            case 2:
                System.out.println("Cargo:");
                String cargo = sc.nextLine();
                return new PersonalAdministrativo(codigoPUCP, nombre, apellido, telefono, anexo, departamento, cargo);
            default:
                break;
        }
        return null;
    }


    public static void exportarDirectorio(ArrayList<Usuario> usuarios, String path) throws IOException {
        File fout = new File(path);
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (Usuario usuario: usuarios){
            bw.write(usuario.toCSV());
            bw.newLine();
        }

        bw.close();
        System.out.println("Exportación satisfactoria.");
    }

}
