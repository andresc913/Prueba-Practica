import java.util.Scanner;

public class CompetenciaProgramacion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Puntaje reto 1: ");
        int reto1 = sc.nextInt(); 

        System.out.print("Puntaje reto 2: ");
        int reto2 = sc.nextInt(); 

        System.out.print("Puntaje reto 3: ");
        int reto3 = sc.nextInt(); 

        System.out.print("Número de errores: ");
        int errores = sc.nextInt();

        System.out.print("Tiempo total en minutos: ");
        int tiempo = sc.nextInt();

        System.out.print("¿Resolvió el desafío extra? (S/N): ");
        String extra = sc.next(); 

        System.out.print("¿Fue descalificado por copia? (S/N): ");
        String copia = sc.next(); 

        int puntajeBase = reto1 + reto2 + reto3;
        int penalizacion = errores * 4;
        
        int bonifExtra = 15;
        int bonifTiempo = 10;
        int bonificacion = bonifExtra + bonifTiempo;

        int puntajeFinal = puntajeBase - penalizacion + bonificacion;

        String nivel = "Avanzado";
        String observacion = "Resultado inconsistente: revisar calidad de resolución";

        System.out.println("\nPuntaje base: " + puntajeBase);
        System.out.println("Penalización: " + penalizacion);
        System.out.println("Bonificación: " + bonificacion);
        System.out.println("Puntaje final: " + puntajeFinal);
        System.out.println("Nivel: " + nivel);
        System.out.println("Observación: " + observacion);

    }
}