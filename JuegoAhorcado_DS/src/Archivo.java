import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Archivo {
    // Objeto Scanner
    static Scanner capturar = new Scanner(System.in);

    // Validar si existe el archivo Palabras.txt
    public static void validarArchivo(){
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
            System.out.println("Ocurrio un error al validar el archivo");
        }
    }

    // Llenar el archivo Palabras.txt
    public static void llenarArchivo(){
        // Solicitar la cantidad de palabras que se guardaran
        System.out.print("¿Cuántas palabras vas a ingresar?: ");
        int cantidad = capturar.nextInt(); capturar.nextLine();

        // Crear el vector para almacenar las palabras
        String[] palabras = new String[cantidad];

        // Llenar el vector con palabras
        for (int i = 0; i < palabras.length; i++){
            System.out.print("Ingresa la palabra " + (i + 1) + ": ");
            String palabra = capturar.nextLine().toUpperCase().trim();
            palabras[i] = palabra;
        }

        // Ordenar alfabeticamente las palabras
        int salto = palabras.length / 2;

        while(salto > 0){
            for(int i = salto; i < palabras.length; i++){
                String aux = palabras[i];
                int j = i;

                while (j >= salto && palabras[j - salto].compareToIgnoreCase(aux) > 0) {
                    palabras[j] = palabras[j - salto];
                    j = j - salto;
                }

                palabras[j] = aux;
            }

            salto = salto / 2;
        }
        
        // Guardar el vector de palabras en el archivo Palabras.txt
        try{
            // Objeto para escribir sobre el archivo
            PrintWriter escribir = new PrintWriter(new FileWriter("Archivos/Palabras.txt"));

            // Meter las palabras del vector en el archivo
            for (int i = 0; i < palabras.length; i++){
                escribir.println(palabras[i]);
            }

            // Cerrar el archivo
            escribir.close();

            System.out.println("Palabras guardadas correctamente");

        } catch (IOException e){
            System.out.println("Ocurrio un error al guardar las palabras en el archivo Palabras.txt");
        }
    }

    // Cargar palabras del archivo para usarlas en el juego
    public static String[] leerPalabras(){
        // Objeto File
        File archivo = new File("Archivos/Palabras.txt");

        // Determinar tamanio del arreglo
        try (Scanner leerCantidad = new Scanner(archivo)) {
            int cantidad = 0;
            while (leerCantidad.hasNextLine()) {
                leerCantidad.nextLine();
                cantidad++;
            }

            // Guardar palabras en el vector
            String[] palabras = new String[cantidad];

            try (Scanner lector = new Scanner(archivo)) {
                for (int i = 0; i < palabras.length; i++) {
                    palabras[i] = lector.nextLine().toUpperCase().trim();
                }
            }

            // Devolver el vector con las palabras dentro
            return palabras;

        } catch (IOException e) {
            System.out.println("Ocurrio un error al leer el archivo");
        }
        return new String[0];
    }

    // Reiniciar el archivo
    public static void reiniciarArchivo(){
        // Objeto File
        File archivoNuevo = new File("Palabras.txt");

        try{
            // Comprobar si existe el archivo
            System.out.println("Buscando Archivo...");

            if (archivoNuevo.exists()){
                System.out.println("Archivo Encontrado...");
                System.out.println("Eliminando Archivo...");
                archivoNuevo.delete();
                System.out.println("Archivo antiguo eliminado correctamente");

                System.out.println("Creando nuevo archivo...");
                archivoNuevo.createNewFile();
                System.out.println("Archivo creado correctamente.");
            } else{
                System.out.println("El archivo no existe");
            }
        } catch (IOException e){
            System.out.println("Ocurrio un error al reiniciar el archivo");
        }
    }
}
