public class Pila {
    // Declaracion de variables
    private String[] letras;
    private int cima;

    // Crear Pila
    public Pila(){
        letras = new String[27];
        cima = -1;
    }

    // Insertar (PUSH)
    public void insertar(String letra){
        // Insertar letra si la pila no esta llena
        if (!estaLlena()){
            cima++;
            letras[cima] = letra;
        } else{
            System.out.println("La pila se encuentra llena");
        }
    }

    // Eliminar (POP)
    public void eliminar(String letra){
        if (!estaVacia()){
            letra = letras[cima];
            cima--;
        } else{
            System.out.println("La pila se encuentra vacia");
        }
    }

    // Mostrar ultima letra ingresada (PEEK)
    public void mostrarCima(){
        if (!estaVacia()){
            System.out.println("Ultima letra ingresada: " + letras[cima]);
        } else{
            System.out.println("La pila se encuentra vacia");
        }
    }

    // Mostrar cantidad de elementos existentes
    public void mostrarCantidadElementos(){
        if (!estaVacia()){
            System.out.println("Elementos Existentes: " + (cima + 1));
        }
        else{
            System.out.println("La pila se encuentra vacia.");
        }
    }

    // Vaciar pila
    public void vaciarPila(){
        if (!estaVacia()){
            cima = -1;
            System.out.println("Pila vaciada correctamente");
        } else{
            System.out.println("La pila se encuentra vacia");
        }
    }

    // Metodos auxiliares
    private boolean estaLlena() {
        return cima == letras.length - 1;
    }

    private boolean estaVacia(){
        return cima == -1;
    }
}
