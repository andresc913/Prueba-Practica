package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== EVALUACIÓN DE CALIDAD DE PROYECTO DE SOFTWARE ===");

            double notaAnalisis = solicitarNota(sc, "Ingrese nota de Análisis (0-10): ");
            double notaDiseno = solicitarNota(sc, "Ingrese nota de Diseño (0-10): ");
            double notaCodificacion = solicitarNota(sc, "Ingrese nota de Codificación (0-10): ");

            System.out.print("Ingrese Porcentaje de Avance Real (0-100): ");
            double avanceReal = 0;
            while (!sc.hasNextDouble() || (avanceReal = sc.nextDouble()) < 0 || avanceReal > 100) {
                System.out.print("Error: Ingrese un porcentaje válido entre 0 y 100: ");
                sc.nextLine();
            }

            System.out.print("Ingrese número de errores detectados: ");
            int errores = 0;
            while (!sc.hasNextInt() || (errores = sc.nextInt()) < 0) {
                System.out.print("Error: Ingrese un entero válido >= 0: ");
                sc.nextLine();
            }

            System.out.print("¿Presentó documentación completa? (S/N): ");
            String docInput = sc.next().trim().toUpperCase();
            while (!docInput.equals("S") && !docInput.equals("N")) {
                System.out.print("Ingrese 'S' o 'N': ");
                docInput = sc.next().trim().toUpperCase();
            }

            System.out.print("¿Realizó exposición final? (S/N): ");
            String expInput = sc.next().trim().toUpperCase();
            while (!expInput.equals("S") && !expInput.equals("N")) {
                System.out.print("Ingrese 'S' o 'N': ");
                expInput = sc.next().trim().toUpperCase();
            }

            // Proceso
            double promedioTecnico = (notaAnalisis + notaDiseno + notaCodificacion) / 3.0;

            double ajustes = 0.0;
            ajustes -= (errores * 0.5);

            if (docInput.equals("S")) {
                ajustes += 0.5;
            }
            if (expInput.equals("S")) {
                ajustes += 0.5;
            }

            double notaFinal = promedioTecnico + ajustes;
            if (notaFinal > 10.0) {
                notaFinal = 10.0;
            }
            if (notaFinal < 0.0) {
                notaFinal = 0.0;
            }

            // Asignación de Estado
            String estado;
            if (notaFinal >= 9.0) {
                estado = "Excelente";
            } else if (notaFinal >= 7.0) {
                estado = "Aprobado";
            } else if (notaFinal >= 5.0) {
                estado = "Recuperación";
            } else {
                estado = "Reprobado";
            }

            // Restricción por avance
            if (avanceReal < 60.0 && estado.equals("Excelente")) {
                estado = "Aprobado";
            }

            // Observación
            String observacion = "Sin observaciones";
            if (notaFinal >= 7.0 && docInput.equals("N")) {
                observacion = "Buen producto, pero mala formalidad";
            }

            // Salida
            System.out.println("\n----------------- SALIDA ESPERADA -----------------");
            System.out.printf("Promedio técnico: %.2f\n", promedioTecnico);
            System.out.printf("Ajustes aplicados: %.2f\n", ajustes);
            System.out.printf("Nota final      : %.2f\n", notaFinal);
            System.out.println("Estado          : " + estado);
            System.out.println("Observación     : " + observacion);
            System.out.println("---------------------------------------------------");
        }
    }

    private static double solicitarNota(Scanner sc, String msj) {
        double nota = -1;
        System.out.print(msj);
        while (true) {
            if (sc.hasNextDouble()) {
                nota = sc.nextDouble();
                if (nota >= 0.0 && nota <= 10.0) break;
            } else {
                sc.next();
            }
            System.out.print("Error: Ingrese una nota válida entre 0 y 10: ");
        }
        return nota;
    }
}