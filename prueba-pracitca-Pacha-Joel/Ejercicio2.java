import java.util.Scanner;

public class EvaluacionProyecto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double notaAnalisis, notaDiseno, notaCodificacion;
        double avance;
        int errores;
        char documentacion, exposicion;

        // Lectura y validación de notas (entre 0 y 10)
        do {
            System.out.print("Ingrese nota de Análisis (0 - 10): ");
            notaAnalisis = scanner.nextDouble();

            System.out.print("Ingrese nota de Diseño (0 - 10): ");
            notaDiseno = scanner.nextDouble();

            System.out.print("Ingrese nota de Codificación (0 - 10): ");
            notaCodificacion = scanner.nextDouble();

            if (notaAnalisis < 0 || notaAnalisis > 10 || 
                notaDiseno < 0 || notaDiseno > 10 || 
                notaCodificacion < 0 || notaCodificacion > 10) {
                System.out.println("Error: Todas las notas deben estar entre 0 y 10. Intente de nuevo.\n");
            }
        } while (notaAnalisis < 0 || notaAnalisis > 10 || 
                 notaDiseno < 0 || notaDiseno > 10 || 
                 notaCodificacion < 0 || notaCodificacion > 10);

        // Lectura y validación de avance (entre 0 y 100) y errores (>= 0)
        do {
            System.out.print("Ingrese el porcentaje de avance (0 - 100): ");
            avance = scanner.nextDouble();

            System.out.print("Ingrese la cantidad de errores encontrados: ");
            errores = scanner.nextInt();

            if (avance < 0 || avance > 100 || errores < 0) {
                System.out.println("Error: El avance debe ser entre 0 y 100, y los errores no pueden ser negativos.\n");
            }
        } while (avance < 0 || avance > 100 || errores < 0);

        // Lectura y validación de documentación ('S' o 'N')
        do {
            System.out.print("¿Presentó documentación completa? (S/N): ");
            documentacion = scanner.next().charAt(0);

            if (documentacion >= 'a' && documentacion <= 'z') {
                documentacion = (char) (documentacion - 32);
            }

            if (documentacion != 'S' && documentacion != 'N') {
                System.out.println("Error: Ingrese únicamente 'S' o 'N'.");
            }
        } while (documentacion != 'S' && documentacion != 'N');

        // Lectura y validación de exposición ('S' o 'N')
        do {
            System.out.print("¿Realizó la exposición? (S/N): ");
            exposicion = scanner.next().charAt(0);

            if (exposicion >= 'a' && exposicion <= 'z') {
                exposicion = (char) (exposicion - 32);
            }

            if (exposicion != 'S' && exposicion != 'N') {
                System.out.println("Error: Ingrese únicamente 'S' o 'N'.");
            }
        } while (exposicion != 'S' && exposicion != 'N');

        // Cálculos principales
        double promedio = (notaAnalisis + notaDiseno + notaCodificacion) / 3;
        double ajusteErrores = -0.5 * errores;
        double ajusteDocumentacion = 0;
        double ajusteExposicion = 0;

        if (documentacion == 'S') {
            ajusteDocumentacion = 0.5;
        }

        if (exposicion == 'S') {
            ajusteExposicion = 0.5;
        }

        // Suma de todos los ajustes para la salida requerida
        double ajustesTotales = ajusteErrores + ajusteDocumentacion + ajusteExposicion;

        double notaFinal = promedio + ajustesTotales;

        if (notaFinal > 10) {
            notaFinal = 10;
        }

        if (notaFinal < 0) {
            notaFinal = 0;
        }

        // Determinación del estado
        String estado;
        if (notaFinal >= 9) {
            estado = "Excelente";
        } else if (notaFinal >= 7) {
            estado = "Aprobado";
        } else if (notaFinal >= 5) {
            estado = "Recuperación";
        } else {
            estado = "Reprobado";
        }

        // Restricción por avance incompleto
        if (avance < 60 && estado.equals("Excelente")) {
            estado = "Aprobado";
        }

        // Determinar observación
        String observacion = "Sin observaciones";
        if (notaFinal >= 7 && documentacion == 'N') {
            observacion = "Buen producto, pero mala formalidad";
        }

        // Mostrar resultados
        System.out.println("--- EVALUACIÓN DEL PROYECTO ---");
        System.out.println("Promedio de Notas: " + promedio);
        System.out.println("Ajustes Totales:   " + ajustesTotales);
        System.out.println("Nota Final:        " + notaFinal);
        System.out.println("Estado:            " + estado);
        System.out.println("Observación:       " + observacion);

        scanner.close();
    }
}
