import java.util.Scanner;

public class CompetenciaProgramacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double reto1, reto2, reto3, tiempo;
        int errores;
        char extra, copia;

        // Lectura y validación de valores numéricos no negativos
        do {
            System.out.print("Ingrese el puntaje del Reto 1: ");
            reto1 = scanner.nextDouble();

            System.out.print("Ingrese el puntaje del Reto 2: ");
            reto2 = scanner.nextDouble();

            System.out.print("Ingrese el puntaje del Reto 3: ");
            reto3 = scanner.nextDouble();

            System.out.print("Ingrese el número de errores: ");
            errores = scanner.nextInt();

            System.out.print("Ingrese el tiempo empleado (minutos): ");
            tiempo = scanner.nextDouble();

            if (reto1 < 0 || reto2 < 0 || reto3 < 0 || errores < 0 || tiempo < 0) {
                System.out.println("Datos inválidos. No se permiten valores negativos. Intente de nuevo.\n");
            }
        } while (reto1 < 0 || reto2 < 0 || reto3 < 0 || errores < 0 || tiempo < 0);

        // Lectura y validación de extra ('S' o 'N')
        do {
            System.out.print("¿Completó el reto extra? (S/N): ");
            extra = scanner.next().charAt(0);
            
            // Si entra minúscula la convertimos a mayúscula manualmente usando tabla ASCII
            if (extra >= 'a' && extra <= 'z') {
                extra = (char) (extra - 32);
            }

            if (extra != 'S' && extra != 'N') {
                System.out.println("Error: Ingrese únicamente 'S' o 'N'.");
            }
        } while (extra != 'S' && extra != 'N');

        // Lectura y validación de copia ('S' o 'N')
        do {
            System.out.print("¿Hubo intento de copia? (S/N): ");
            copia = scanner.next().charAt(0);

            if (copia >= 'a' && copia <= 'z') {
                copia = (char) (copia - 32);
            }

            if (copia != 'S' && copia != 'N') {
                System.out.println("Error: Ingrese únicamente 'S' o 'N'.");
            }
        } while (copia != 'S' && copia != 'N');

        // Cálculos de puntaje
        double puntajeBase = reto1 + reto2 + reto3;
        double penalizacion = errores * 4;
        double bonificacion = 0;

        if (extra == 'S') {
            bonificacion = bonificacion + 15;
        }

        if (tiempo < 30) {
            bonificacion = bonificacion + 10;
        }

        double puntajeFinal = puntajeBase - penalizacion + bonificacion;
        if (puntajeFinal < 0) {
            puntajeFinal = 0;
        }

        // Determinar nivel
        String nivel;
        if (puntajeFinal < 30) {
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

        if (copia == 'S') {
            nivel = "Descalificado";
        }

        // Observación
        String observacion = "Sin observaciones";
        if (puntajeFinal >= 70 && errores >= 5) {
            observacion = "Resultado inconsistente: revisar calidad de resolución";
        }

        // Mostrar resultados
        System.out.println("--- RESULTADOS ---");
        System.out.println("Puntaje Base: " + puntajeBase);
        System.out.println("Penalización: " + penalizacion);
        System.out.println("Bonificación: " + bonificacion);
        System.out.println("Puntaje Final: " + puntajeFinal);
        System.out.println("Nivel: " + nivel);
        System.out.println("Observación: " + observacion);

        scanner.close();
    }
}
