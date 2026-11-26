import java.util.Scanner;

public class PruebaAhorcado {
    public static void main(String[] args){
        // Declaracion de variables
        Scanner sc = new Scanner(System.in);
        int opc;

        do{
            System.out.println("========== JUEGO AHORCADO ==========");
            System.out.println();
            System.out.println("---------- OPCIONES ----------");
            System.out.println("""
            1. Verificar archivo
            2. Llenar Archivo con Palabras
            3. Borrar Archivo
            4. Jugar
            5. Salir
            """);
            System.out.print("Ingresa una opción: ");
            opc = sc.nextInt(); sc.nextLine();

            switch (opc) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;

                case 5:
                    break;
                default:
                    System.out.println("Opción invalida. Intente de nuevo.");
                    break;
            }
        } while (opc != 5); sc.close();
    }
}