import java.util.Random;

public class JuegoAhorcado {
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
}
