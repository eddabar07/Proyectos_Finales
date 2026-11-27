import java.util.Scanner;

public class PruebaAhorcado {
    public static void main(String[] args){
        // Declaracion de variables
        Scanner sc = new Scanner(System.in);
        String opc;

        do{
            System.out.println();
            System.out.println("========== JUEGO AHORCADO ==========");
            System.out.println();
            System.out.println("---------- OPCIONES ----------");
            System.out.println("""
            1. Verificar archivo
            2. Llenar Archivo con Palabras
            3. Reiniciar Archivo
            4. Jugar
            5. Salir
            """);
            System.out.print("Ingresa una opción: ");
            opc = sc.nextLine();

            switch (opc) {
                case "1":
                    Archivo.validarArchivo();
                    break;

                case "2":
                    Archivo.llenarArchivo();
                    break;

                case "3":
                    Archivo.reiniciarArchivo();
                    break;

                case "4":
                    // Cargar palabras del archivo
                    String[] palabras = JuegoAhorcado.cargarPalabras();

                    // Verificar que existan palabras
                    if (palabras.length > 0){
                        // Elegir palabra secreta
                        String palabra = JuegoAhorcado.palabraSecreta(palabras);

                        // Iniciar juego
                        JuegoAhorcado.inicioAhorcado(palabra);
                    } else{
                        System.out.println("No existen palabras para jugar.");
                        System.out.println("Primero debes llenar el archivo.");
                    }
                    break;

                case "5":
                    System.out.println("Gracias por jugar. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción invalida. Intente de nuevo.");
                    break;
            }
        } while (!(opc.equals("5"))); sc.close();
    }
}