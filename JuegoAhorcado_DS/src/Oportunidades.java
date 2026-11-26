public class Oportunidades {
    // Declaracion de variables
    private static int oportunidades;

    // Determinar las oportunidades
    public Oportunidades(){
        oportunidades = 10;
    }

    // Consultar oportunidades restantes
    public static int getOportunidades(){
        return oportunidades;
    }

    // Restar oportunidades
    public static void restarOportunidad(){
        if (oportunidades > 0){
            oportunidades--;
        }
    }

    // Verificar si quedan oportunidades
    public static boolean hayOportunidades(){
        return oportunidades > 0;
    }

    // Reiniciar las oportunidades
    public static void reiniciar(){
        oportunidades = 10;
    }
}
