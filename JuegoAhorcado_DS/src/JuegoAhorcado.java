import java.util.Random;

public class JuegoAhorcado {
    // Abcedario
    char[] abecedario = {
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

    // Verificar si se ha adivinado la palabra
    public static boolean seAdivinoLaPalabra(String palabraSecreta, String[] letrasIngresadas){
        // Recorrer la palabra secreta
        for (int i = 0; i < palabraSecreta.length(); i++){
            // Variable para saber si se encontro la letra
            boolean encontrada = false;

            // Recorrer letras ingresadas
            for (int j = 0; j < letrasIngresadas.length; j++){
                // Comparamos las letras del arreglo con la palabra secreta
                if (String.valueOf(palabraSecreta.charAt(i)).equalsIgnoreCase(letrasIngresadas[j])){
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
    public static String obtenerPalabraAdivinada(String palabraSecreta, String[] letrasIngresadas){
        // Variable para guardar la palabra adivinada
        String palabraAdivinada = "";

        // Recorremos la palabra secreta
        for (int i = 0; i < palabraSecreta.length(); i++){
            // Variable para saber si la letra ingresada se encuentra en la palabra
            boolean encontrada = false;

            // Recorremos las palabras ingresadas
            for (int j = 0; j < letrasIngresadas.length; j++){
                // Comparar la letra ingresada con cada una de las letras de la palabra
                if (String.valueOf(palabraSecreta.charAt(i)).equalsIgnoreCase(letrasIngresadas[j])){
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

}
