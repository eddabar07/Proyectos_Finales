public class Pila {
    // Declaracion de variables
    private static char[] letras;
    private static int cima;

    // Crear Pila
    public Pila(){
        letras = new char[27];
        cima = -1;
    }

    // Insertar (PUSH)
    public static void insertar(char letra){
        // Insertar letra si la pila no esta llena
        if (!estaLlena()){
            cima++;
            letras[cima] = letra;
        } else{
            System.out.println("La pila se encuentra llena");
        }
    }

    // Eliminar (POP)
    public static void eliminar(char letra){
        if (!estaVacia()){
            letra = letras[cima];
            cima--;
        } else{
            System.out.println("La pila se encuentra vacia");
        }
    }

    // Mostrar ultima letra ingresada (PEEK)
    public static void mostrarCima(){
        if (!estaVacia()){
            System.out.println("Ultima letra ingresada: " + letras[cima]);
        } else{
            System.out.println("La pila se encuentra vacia");
        }
    }

    // Mostrar cantidad de elementos existentes
    public static void mostrarCantidadElementos(){
        if (!estaVacia()){
            System.out.println("Elementos Existentes: " + (cima + 1));
        }
        else{
            System.out.println("La pila se encuentra vacia.");
        }
    }

    // Vaciar pila
    public static void vaciarPila(){
        if (!estaVacia()){
            cima = -1;
            System.out.println("Pila vaciada correctamente");
        } else{
            System.out.println("La pila se encuentra vacia");
        }
    }

    // Metodos auxiliares
    private static boolean estaLlena() {
        return cima == letras.length - 1;
    }

    private static boolean estaVacia(){
        return cima == -1;
    }
}
