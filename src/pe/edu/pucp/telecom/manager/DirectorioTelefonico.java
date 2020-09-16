package pe.edu.pucp.telecom.manager;

import pe.edu.pucp.telecom.entity.Instructor;
import pe.edu.pucp.telecom.entity.JefePractica;
import pe.edu.pucp.telecom.entity.PersonalAdministrativo;
import pe.edu.pucp.telecom.entity.Profesor;
import pe.edu.pucp.telecom.entity.base.Usuario;
import pe.edu.pucp.telecom.util.Utils;

import java.io.*;
import java.util.ArrayList;


public class DirectorioTelefonico {
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private final Utils utils = new Utils();

    public void agregar(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void leerData(String filename) {
        BufferedReader reader;
        try {

            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);

                String[] mapUsuario = line.split(",");
                switch (mapUsuario[0]){
                    case "PA":
                        agregar(new PersonalAdministrativo(mapUsuario[1], mapUsuario[2], mapUsuario[3],
                                mapUsuario[4], mapUsuario[5], mapUsuario[6], mapUsuario[7])
                        );
                        break;
                    case "Profesor":
                        agregar(new Profesor(mapUsuario[1], mapUsuario[2], mapUsuario[3],
                                mapUsuario[4], mapUsuario[5], mapUsuario[6], Integer.parseInt(mapUsuario[7]),
                                Short.parseShort(mapUsuario[8]), mapUsuario[9]));
                        break;
                    case "JP":
                        agregar(new JefePractica(mapUsuario[1], mapUsuario[2], mapUsuario[3],
                                mapUsuario[4], mapUsuario[5], mapUsuario[6], Integer.parseInt(mapUsuario[7]),
                                Short.parseShort(mapUsuario[8]), Integer.parseInt(mapUsuario[9])));
                        break;
                    case "Instructor":
                        agregar(new Instructor(mapUsuario[1], mapUsuario[2], mapUsuario[3],
                                mapUsuario[4], mapUsuario[5], mapUsuario[6], Integer.parseInt(mapUsuario[7]),
                                Short.parseShort(mapUsuario[8]), Short.parseShort(mapUsuario[9])));
                        break;
                    default:
                        break;
                }
                line = reader.readLine();
            }
            reader.close();
            System.out.println("Importación satisfactoria.");

        } catch (FileNotFoundException ex){
            System.out.println("Archivo no encontrado");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exportarDirectorio(String path) {
        try{
            utils.exportarDirectorio(usuarios, path + "Directorio.csv");
        } catch (Exception ex) {
            System.out.println("Error al exportar");
        }
    }

    public void exportarListaUsuarios(ArrayList<Usuario> usuariosExport,String path) {
        try{
            utils.exportarDirectorio(usuariosExport, path + "Busqueda.csv");
        } catch (Exception ex) {
            System.out.println("Error al exportar.");
        }
    }

    public ArrayList<Usuario> buscarUsuario(String word) {
        ArrayList<Usuario> busquedaUsuarios = new ArrayList<Usuario>();
        for (Usuario usuario: usuarios){
            if (usuario.getNombre().equalsIgnoreCase(word) || usuario.getApellido().equalsIgnoreCase(word) ) {
                System.out.println(usuario.toCSV());
                busquedaUsuarios.add(usuario);
            }
        }
        return busquedaUsuarios;
    }

}
