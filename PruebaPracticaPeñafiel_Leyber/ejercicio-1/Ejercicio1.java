import java.util.Scanner;

public class CompetenciaProgramacion {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int reto1 = -1;
        int reto2 = -1;
        int reto3 = -1;
        int errores = -1;
        int tiempo = -1;

        int puntajeBase;
        int penalizacion;
        int bonificacion = 0;
        int puntajeFinal;

        String respuestaExtra = "";
        String respuestaCopia = "";
        String nivel = "";
        String observacion = "Sin observaciones";

        boolean extra = false;
        boolean copia = false;

        // Lectura y validación del reto 1
        while (reto1 < 0) {
            System.out.print("Ingrese el puntaje del reto 1: ");
            reto1 = teclado.nextInt();

            if (reto1 < 0) {
                System.out.println("El puntaje no puede ser negativo.");
            }
        }

        // Lectura y validación del reto 2
        while (reto2 < 0) {
            System.out.print("Ingrese el puntaje del reto 2: ");
            reto2 = teclado.nextInt();

            if (reto2 < 0) {
                System.out.println("El puntaje no puede ser negativo.");
            }
        }

        // Lectura y validación del reto 3
        while (reto3 < 0) {
            System.out.print("Ingrese el puntaje del reto 3: ");
            reto3 = teclado.nextInt();

            if (reto3 < 0) {
                System.out.println("El puntaje no puede ser negativo.");
            }
        }

        // Lectura y validación de errores
        while (errores < 0) {
            System.out.print("Ingrese el número de errores: ");
            errores = teclado.nextInt();

            if (errores < 0) {
                System.out.println("El número de errores no puede ser negativo.");
            }
        }

        // Lectura y validación del tiempo
        while (tiempo < 0) {
            System.out.print("Ingrese el tiempo total en minutos: ");
            tiempo = teclado.nextInt();

            if (tiempo < 0) {
                System.out.println("El tiempo no puede ser negativo.");
            }
        }

        // Validación de la respuesta del desafío extra
        while (!respuestaExtra.equals("S") && !respuestaExtra.equals("N")) {
            System.out.print("¿Resolvió el desafío extra? (S/N): ");
            respuestaExtra = teclado.next().toUpperCase();

            switch (respuestaExtra) {
                case "S":
                    extra = true;
                    break;

                case "N":
                    extra = false;
                    break;

                default:
                    System.out.println("Respuesta incorrecta. Escriba S o N.");
            }
        }

        // Validación de la respuesta de copia
        while (!respuestaCopia.equals("S") && !respuestaCopia.equals("N")) {
            System.out.print("¿Fue descalificado por copia? (S/N): ");
            respuestaCopia = teclado.next().toUpperCase();

            switch (respuestaCopia) {
                case "S":
                    copia = true;
                    break;

                case "N":
                    copia = false;
                    break;

                default:
                    System.out.println("Respuesta incorrecta. Escriba S o N.");
            }
        }

        // Cálculo del puntaje base
        puntajeBase = reto1 + reto2 + reto3;

        // Cálculo de la penalización
        penalizacion = errores * 4;

        // Bonificación por desafío extra
        if (extra) {
            bonificacion = bonificacion + 15;
        }

        // Bonificación por tiempo
        if (tiempo < 30) {
            bonificacion = bonificacion + 10;
        }

        // Cálculo del puntaje final
        puntajeFinal = puntajeBase - penalizacion + bonificacion;

        // El puntaje final no puede ser negativo
        if (puntajeFinal < 0) {
            puntajeFinal = 0;
        }

        // Asignación del nivel
        if (puntajeFinal <= 29) {
            nivel = "Principiante";
        } else if (puntajeFinal <= 49) {
            nivel = "Básico";
        } else if (puntajeFinal <= 69) {
            nivel = "Intermedio";
        } else if (puntajeFinal <= 89) {
            nivel = "Avanzado";
        } else {
            nivel = "Experto";
        }

        // La descalificación tiene prioridad
        if (copia) {
            nivel = "Descalificado";
        }

        // Se considera puntaje alto desde 70 y demasiados errores desde 5
        if (puntajeFinal >= 70 && errores >= 5) {
            observacion =
                "Resultado inconsistente: revisar calidad de resolución";
        }

        // Presentación de resultados
        System.out.println("\n----- RESULTADOS -----");
        System.out.println("Puntaje base: " + puntajeBase);
        System.out.println("Penalización: " + penalizacion);
        System.out.println("Bonificación: " + bonificacion);
        System.out.println("Puntaje final: " + puntajeFinal);
        System.out.println("Nivel: " + nivel);
        System.out.println("Observación: " + observacion);

        teclado.close();
    }
}
