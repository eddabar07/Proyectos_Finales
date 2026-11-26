import java.util.Random;
import java.util.Scanner;

public class JuegoAhorcado {
    // Objeto Scanner
    private static Scanner sc = new Scanner(System.in);

    // Abcedario
    private static char[] abecedario = {
    'A', 'B', 'C', 'D', 'E', 'F', 'G',
    'H', 'I', 'J', 'K', 'L', 'M', 'N',
    'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T',
    'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    // Cargar palabras para el juego
    public static String[] cargarPalabras(){
        // Vector para guardar las palabras
        String[] palabras = Archivo.leerPalabras();

        // Devolver palabras
        return palabras;
    }

    // Eligir palabra a adivinar
    public static String palabraSecreta(String[] palabras){
        // Objeto Random
        Random random = new Random();

        // Determinar la posicion de la palabra que se escogera
        int posicion = random.nextInt(palabras.length);

        // Devolver la palabra secreta
        return palabras[posicion];
    }

    // Inicar ahorcado
    public static void inicioAhorcado(String palabraSecreta){
        // Reiniciar estructuras
        new Pila();
        new Oportunidades();

        // Mensaje de bienvenida
        System.out.println("========== BIENVENIDO AL JUEGO DEL AHORCADO ==========");

        // Reglas del juego
        System.out.println("---------- REGLAS ----------");
        System.out.println("""
        El objetivo es adivinar la palabra secreta elegida aleatoriamente por la computadora,
        descubriendo sus letras antes de quedarse sin oportunidades.

        1. La computadora seleccionará una palabra al azar de la lista guardada en el archivo Palabras.txt.
        2. Al comenzar, se mostrará la cantidad de letras que tiene la palabra secreta.
        3. El jugador deberá ingresar una sola letra a la vez.
        4. Después de cada intento, se indicará si la letra ingresada se encuentra o no en la palabra.
        5. Si la letra es correcta, se mostrarán todas las posiciones donde aparece.
        6. Si la letra no se encuentra en la palabra, el jugador perderá una oportunidad.
        7. Si el jugador ingresa una letra que ya había utilizado, se le avisará que está repetida y no perderá ninguna oportunidad.
        8. Se mostrarán las letras que todavía están disponibles para intentar adivinar.
        9. El jugador ganará cuando descubra todas las letras de la palabra.
        10. Si se terminan las oportunidades antes de descubrir la palabra, el jugador perderá y se revelará la respuesta.

        ¡Demuestra tu habilidad y descubre la palabra antes de quedarte sin oportunidades!
        """);

        // Mostrar longitud de la palabra
        System.out.println("\nLa palabra tiene " + palabraSecreta.length() + " letras.");

        // Iniciar el juego
        while (Oportunidades.hayOportunidades() && !seAdivinoLaPalabra(palabraSecreta, Pila.obtenerLetras())){

            // Mostrar palabra adivinada
            System.out.println("\nPalabra: " + obtenerPalabraAdivinada(palabraSecreta, Pila.obtenerLetras()));

            // Mostrar oportunidades restantes
            System.out.println("Oportunidades restantes: " + Oportunidades.getOportunidades());

            // Mostrar letras disponibles
            System.out.println("Letras disponibles: " + obtenerLetrasDisponibles(Pila.obtenerLetras()));

            // Solicitar letra
            System.out.print("Ingresa una letra: ");
            String entrada = sc.nextLine().toUpperCase().trim();

            // Validar entrada
            if (entrada.length() != 1){
                System.out.println("Debes ingresar solamente una letra.");
                continue;
            }

            // Obtener letra
            char letra = entrada.charAt(0);

            // Validar que sea una letra del abecedario
            if (obtenerLetrasDisponibles(Pila.obtenerLetras()).indexOf(letra) == -1){
                System.out.println("La letra no es válida o ya fue ingresada.");
                continue;
            }

            // Insertar letra en la pila
            Pila.insertar(letra);

            // Verificar si la letra se encuentra en la palabra
            if (palabraSecreta.indexOf(letra) != -1){
                System.out.println("¡Correcto! La letra " + letra + " se encuentra en la palabra.");
            } else{
                System.out.println("Incorrecto. La letra " + letra + " no se encuentra en la palabra.");
                Oportunidades.restarOportunidad();
            }
        }

        // Mostrar resultado
        if (seAdivinoLaPalabra(palabraSecreta, Pila.obtenerLetras())){
            System.out.println("\n¡FELICIDADES, GANASTE!");
            System.out.println("La palabra era: " + palabraSecreta);
        } else{
            System.out.println("\n¡PERDISTE!");
            System.out.println("La palabra secreta era: " + palabraSecreta);
        }
    }

    // Verificar si se ha adivinado la palabra
    public static boolean seAdivinoLaPalabra(String palabraSecreta, char[] letrasIngresadas){
        // Recorrer la palabra secreta
        for (int i = 0; i < palabraSecreta.length(); i++){
            // Variable para saber si se encontro la letra
            boolean encontrada = false;

            // Recorrer letras ingresadas
            for (int j = 0; j < letrasIngresadas.length; j++){
                // Comparamos las letras del arreglo con la palabra secreta
                if (palabraSecreta.charAt(i) == letrasIngresadas[j]){
                    encontrada = true;
                    break;
                }
            }
            // En caso de no encontrar la letra
            if (!encontrada){
                return false;
            }
        }
        // En caso de haber sido adivinada
        return true;
    }

    // Obtener la palabra adivinada
    public static String obtenerPalabraAdivinada(String palabraSecreta, char[] letrasIngresadas){
        // Variable para guardar la palabra adivinada
        String palabraAdivinada = "";

        // Recorremos la palabra secreta
        for (int i = 0; i < palabraSecreta.length(); i++){
            // Variable para saber si la letra ingresada se encuentra en la palabra
            boolean encontrada = false;

            // Recorremos las palabras ingresadas
            for (int j = 0; j < letrasIngresadas.length; j++){
                // Comparar la letra ingresada con cada una de las letras de la palabra
                if (palabraSecreta.charAt(i) == letrasIngresadas[j]){
                    encontrada = true;
                    break;
                }
            }

            // Si se encontro la palabra, la agregamos a la palabra adivinda
            if (encontrada){
                palabraAdivinada += palabraSecreta.charAt(i) + " ";
            } else{
                palabraAdivinada += "_ ";
            }
        }

        // Devolvemos la palabra adivinada
        return palabraAdivinada.toUpperCase().trim();
    }

    // Obtener letras disponibles
    public static String obtenerLetrasDisponibles(char[] letrasIngresadas) {
        String letrasDisponibles = "";

        // Recorrer el abecedario
        for (int i = 0; i < abecedario.length; i++) {
            char letra = abecedario[i];
            boolean encontrada = false;

            // Comprobar si la letra ya fue ingresada
            for (int j = 0; j < letrasIngresadas.length; j++) {
                if (letra == letrasIngresadas[j]) {
                    encontrada = true;
                    break;
                }
            }

            // Agregar solamente las letras que no se han ingresado
            if (!encontrada) {
                letrasDisponibles += letra;
            }
        }
        return letrasDisponibles;
    }   
}
