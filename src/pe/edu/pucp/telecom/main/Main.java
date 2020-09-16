package pe.edu.pucp.telecom.main;

import pe.edu.pucp.telecom.entity.base.Usuario;
import pe.edu.pucp.telecom.manager.DirectorioTelefonico;
import pe.edu.pucp.telecom.util.Utils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Utils utils = new Utils();

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        DirectorioTelefonico directorioTelefonico = new DirectorioTelefonico();
        console:
        while (true) {
            try{
                System.out.println("1. Leer Datos.\n" +
                        "2. Agregar Usuario.\n" +
                        "3. Buscar Usuario.\n" +
                        "4. Escribir Directorio.\n"+
                        "5. Cerrar consola.\n");
                System.out.print("Seleccione la opción correspondiente: ");
                int option = Integer.parseInt(sc.nextLine());
                switch(option){
                    case 1:
                        System.out.println("Escriba el path del archivo a leer: ");
                        String filename = sc.nextLine();
                        directorioTelefonico.leerData(filename);
                        break;
                    case 2:
                        Usuario nuevoUsuario = utils.datosUsuario(sc);
                        if (nuevoUsuario != null) {
                            System.out.println("Nuevo usuario creado satisfactoriamente\n\n");
                            directorioTelefonico.agregar(nuevoUsuario);
                        }
                        break;
                    case 3:
                        System.out.println("Escriba el nombre o apellido: ");
                        String word = sc.nextLine();
                        ArrayList<Usuario> usuariosBusqueda = directorioTelefonico.buscarUsuario(word);
                        if (!usuariosBusqueda.isEmpty() ) {
                            System.out.println("1. Exportar el resultado.\n" +
                                    "2. Regresar al menu.\n");
                            int optionExportar = Integer.parseInt(sc.nextLine());
                            switch (optionExportar) {
                                case 1:
                                    System.out.println("Escriba el path para exportar");
                                    String pathExport = sc.nextLine();
                                    directorioTelefonico.exportarListaUsuarios(usuariosBusqueda, pathExport);
                                    break;
                                case 2:
                                    break;
                                default:
                                    break;
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Escriba el path para exportar");
                        String pathExport = sc.nextLine();
                        directorioTelefonico.exportarDirectorio(pathExport);
                        break;

                    case 5:
                        sc.close();
                        break console;

                    default:
                        System.out.println("Opción errónea.\n");
                        break;
                }

            } catch (NumberFormatException ex){
                System.out.println("Por favor ingrese un número.\n");
            }
        }

    }


}
