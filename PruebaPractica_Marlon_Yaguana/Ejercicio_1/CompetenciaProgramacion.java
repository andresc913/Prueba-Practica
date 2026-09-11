import java.util.Scanner;

public class CompetenciaProgramacion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int reto1;
        do {
            System.out.print("Puntaje reto 1: ");
            reto1 = sc.nextInt();
            if (reto1 < 0) {
                System.out.println("El valor no puede ser negativo.");
            }
        } while (reto1 < 0);

        int reto2;
        do {
            System.out.print("Puntaje reto 2: ");
            reto2 = sc.nextInt();
            if (reto2 < 0) {
                System.out.println("El valor no puede ser negativo.");
            }
        } while (reto2 < 0);

        int reto3;
        do {
            System.out.print("Puntaje reto 3: ");
            reto3 = sc.nextInt();
            if (reto3 < 0) {
                System.out.println("El valor no puede ser negativo.");
            }
        } while (reto3 < 0);

        int errores;
        do {
            System.out.print("Número de errores: ");
            errores = sc.nextInt();
            if (errores < 0) {
                System.out.println("El valor no puede ser negativo.");
            }
        } while (errores < 0);

        int tiempo;
        do {
            System.out.print("Tiempo total en minutos: ");
            tiempo = sc.nextInt();
            if (tiempo < 0) {
                System.out.println("El valor no puede ser negativo.");
            }
        } while (tiempo < 0);

        String extra;
        do {
            System.out.print("¿Resolvió el desafío extra? (S/N): ");
            extra = sc.next();
        } while (!extra.equalsIgnoreCase("S") && !extra.equalsIgnoreCase("N"));

        String copia;
        do {
            System.out.print("¿Fue descalificado por copia? (S/N): ");
            copia = sc.next();
        } while (!copia.equalsIgnoreCase("S") && !copia.equalsIgnoreCase("N"));

        int puntajeBase = reto1 + reto2 + reto3;

        int penalizacion = errores * 4;

        int bonifExtra = 0;
        if (extra.equalsIgnoreCase("S")) {
            bonifExtra = 15;
        }

        int bonifTiempo = 0;
        if (tiempo < 30) {
            bonifTiempo = 10;
        }

        int bonificacion = bonifExtra + bonifTiempo;

        int puntajeFinal = puntajeBase - penalizacion + bonificacion;
        if (puntajeFinal < 0) {
            puntajeFinal = 0;
        }

        String nivel = "";
        if (copia.equalsIgnoreCase("S")) {
            nivel = "Descalificado";
        } else if (puntajeFinal < 30) {
            nivel = "Principiante";
        } else if (puntajeFinal < 50) {
            nivel = "Básico";
        } else if (puntajeFinal < 70) {
            nivel = "Intermedio";
        } else if (puntajeFinal < 90) {
            nivel = "Avanzado";
        } else {
            nivel = "Experto";
        }

        String observacion = "";
        if (puntajeFinal >= 70 && errores >= 5) {
            observacion = "Resultado inconsistente: revisar calidad de resolución";
        } else {
            observacion = "Sin observaciones";
        }

        System.out.println("\nPuntaje base: " + puntajeBase);
        System.out.println("Penalización: " + penalizacion);
        System.out.println("Bonificación: " + bonificacion);
        System.out.println("Puntaje final: " + puntajeFinal);
        System.out.println("Nivel: " + nivel);
        System.out.println("Observación: " + observacion);

    }
}