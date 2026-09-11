import java.util.Scanner;

public class EvaluacionProyecto {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        double notaAnalisis = -1;
        double notaDiseno = -1;
        double notaCodificacion = -1;
        double avance = -1;

        int errores = -1;

        double promedioTecnico;
        double ajusteErrores;
        double ajusteDocumentacion = 0;
        double ajusteExposicion = 0;
        double notaFinal;

        String respuestaDocumentacion = "";
        String respuestaExposicion = "";
        String estado = "";
        String observacion = "Sin observaciones";

        boolean documentacion = false;
        boolean exposicion = false;

        // Lectura y validación de la nota de análisis
        while (notaAnalisis < 0 || notaAnalisis > 10) {
            System.out.print("Ingrese la nota de análisis (0 a 10): ");
            notaAnalisis = teclado.nextDouble();

            if (notaAnalisis < 0 || notaAnalisis > 10) {
                System.out.println("La nota debe estar entre 0 y 10.");
            }
        }

        // Lectura y validación de la nota de diseño
        while (notaDiseno < 0 || notaDiseno > 10) {
            System.out.print("Ingrese la nota de diseño (0 a 10): ");
            notaDiseno = teclado.nextDouble();

            if (notaDiseno < 0 || notaDiseno > 10) {
                System.out.println("La nota debe estar entre 0 y 10.");
            }
        }

        // Lectura y validación de la nota de codificación
        while (notaCodificacion < 0 || notaCodificacion > 10) {
            System.out.print("Ingrese la nota de codificación (0 a 10): ");
            notaCodificacion = teclado.nextDouble();

            if (notaCodificacion < 0 || notaCodificacion > 10) {
                System.out.println("La nota debe estar entre 0 y 10.");
            }
        }

        // Lectura y validación del porcentaje de avance
        while (avance < 0 || avance > 100) {
            System.out.print("Ingrese el porcentaje de avance real: ");
            avance = teclado.nextDouble();

            if (avance < 0 || avance > 100) {
                System.out.println("El avance debe estar entre 0 y 100.");
            }
        }

        // Lectura y validación del número de errores
        while (errores < 0) {
            System.out.print("Ingrese el número de errores detectados: ");
            errores = teclado.nextInt();

            if (errores < 0) {
                System.out.println("El número de errores no puede ser negativo.");
            }
        }

        // Validación de la documentación
        while (!respuestaDocumentacion.equals("S")
                && !respuestaDocumentacion.equals("N")) {

            System.out.print("¿Presentó documentación completa? (S/N): ");
            respuestaDocumentacion = teclado.next().toUpperCase();

            switch (respuestaDocumentacion) {
                case "S":
                    documentacion = true;
                    break;

                case "N":
                    documentacion = false;
                    break;

                default:
                    System.out.println("Respuesta incorrecta. Escriba S o N.");
            }
        }

        // Validación de la exposición
        while (!respuestaExposicion.equals("S")
                && !respuestaExposicion.equals("N")) {

            System.out.print("¿Realizó la exposición final? (S/N): ");
            respuestaExposicion = teclado.next().toUpperCase();

            switch (respuestaExposicion) {
                case "S":
                    exposicion = true;
                    break;

                case "N":
                    exposicion = false;
                    break;

                default:
                    System.out.println("Respuesta incorrecta. Escriba S o N.");
            }
        }

        // Cálculo del promedio técnico
        promedioTecnico =
            (notaAnalisis + notaDiseno + notaCodificacion) / 3;

        // Cálculo de la penalización por errores
        ajusteErrores = errores * 0.5;

        // Bonificación por documentación
        if (documentacion) {
            ajusteDocumentacion = 0.5;
        }

        // Bonificación por exposición
        if (exposicion) {
            ajusteExposicion = 0.5;
        }

        // Cálculo de la nota final
        notaFinal = promedioTecnico
                  - ajusteErrores
                  + ajusteDocumentacion
                  + ajusteExposicion;

        // La nota final debe estar entre 0 y 10
        if (notaFinal > 10) {
            notaFinal = 10;
        }

        if (notaFinal < 0) {
            notaFinal = 0;
        }

        // Asignación del estado
        if (notaFinal >= 9) {
            estado = "Excelente";
        } else if (notaFinal >= 7) {
            estado = "Aprobado";
        } else if (notaFinal >= 5) {
            estado = "Recuperación";
        } else {
            estado = "Reprobado";
        }

        // Si el avance es menor al 60 %, no puede ser Excelente
        if (avance < 60 && estado.equals("Excelente")) {
            estado = "Aprobado";
        }

        // Se considera buena nota desde 7
        if (notaFinal >= 7 && !documentacion) {
            observacion = "Buen producto, pero mala formalidad";
        }

        // Presentación de resultados
        System.out.println("\n----- RESULTADOS -----");
        System.out.printf("Promedio técnico: %.2f%n", promedioTecnico);
        System.out.printf("Ajuste por errores: -%.2f%n", ajusteErrores);
        System.out.printf(
            "Ajuste por documentación: +%.2f%n",
            ajusteDocumentacion
        );
        System.out.printf(
            "Ajuste por exposición: +%.2f%n",
            ajusteExposicion
        );
        System.out.printf("Nota final: %.2f%n", notaFinal);
        System.out.println("Estado: " + estado);
        System.out.println("Observación: " + observacion);

        teclado.close();
    }
}
