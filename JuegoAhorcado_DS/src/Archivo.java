import java.io.File;
import java.io.IOException;

public class Archivo {
    // Validar si existe el archivo Palabras.txt
    public void validarArchivo(){
        // Objeto para crear archivo
        File archivo = new File("Archivos/Palabras.txt");

        try{
            // Comprobar si existe el archivo
            System.out.println("Buscando Archivo...");

            if (archivo.exists()){
                System.out.println("El archivo ya existe");
            } else{
                System.out.println("El archivo no fue encontrado...");
                System.out.println("Creando nuevo archivo...");
                archivo.createNewFile();
                System.out.println("Archivo creado correctamente");
            }
        } catch (IOException e){
            System.out.println("Hubo un error al validar el archivo");
        }
    }
}
