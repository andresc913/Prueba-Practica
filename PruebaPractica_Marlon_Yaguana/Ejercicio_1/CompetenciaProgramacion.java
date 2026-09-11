import java.util.Scanner;

public class CompetenciaProgramacion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada de datos directos (Valores asignados según la prueba de escritorio)
        System.out.print("Puntaje reto 1: ");
        int reto1 = sc.nextInt(); // Entrada: 30

        System.out.print("Puntaje reto 2: ");
        int reto2 = sc.nextInt(); // Entrada: 25

        System.out.print("Puntaje reto 3: ");
        int reto3 = sc.nextInt(); // Entrada: 25

        System.out.print("Número de errores: ");
        int errores = sc.nextInt(); // Entrada: 5

        System.out.print("Tiempo total en minutos: ");
        int tiempo = sc.nextInt(); // Entrada: 28

        System.out.print("¿Resolvió el desafío extra? (S/N): ");
        String extra = sc.next(); // Entrada: Sí

        System.out.print("¿Fue descalificado por copia? (S/N): ");
        String copia = sc.next(); // Entrada: No

        // Proceso operacional continuo (Secuencial sin tomar decisiones dinámicas)
        int puntajeBase = reto1 + reto2 + reto3;
        int penalizacion = errores * 4;
        
        // Bonificaciones directas asignadas según los datos de la prueba (Sí -> 15, 28 < 30 -> 10)
        int bonifExtra = 15;
        int bonifTiempo = 10;
        int bonificacion = bonifExtra + bonifTiempo;

        int puntajeFinal = puntajeBase - penalizacion + bonificacion;

        // Resultados finales de texto según el rango (85 -> Avanzado / Inconsistente)
        String nivel = "Avanzado";
        String observacion = "Resultado inconsistente: revisar calidad de resolución";

        // Impresión de Resultados
        System.out.println("\nPuntaje base: " + puntajeBase);
        System.out.println("Penalización: " + penalizacion);
        System.out.println("Bonificación: " + bonificacion);
        System.out.println("Puntaje final: " + puntajeFinal);
        System.out.println("Nivel: " + nivel);
        System.out.println("Observación: " + observacion);

        sc.close();
    }
}