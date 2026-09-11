import java.util.Scanner;

public class EvaluacionProyecto {
    static double leerEnRango(Scanner sc, String mensaje, double min, double max) {
        double valor;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextDouble()) {
                System.out.print("Ingrese un número válido: ");
                sc.next();
            }
            valor = sc.nextDouble();
            if (valor < min || valor > max)
                System.out.printf("El valor debe estar entre %.0f y %.0f.%n", min, max);
        } while (valor < min || valor > max);
        return valor;
    }

    static int leerNoNegativo(Scanner sc, String mensaje) {
        int valor;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextInt()) {
                System.out.print("Ingrese un entero válido: ");
                sc.next();
            }
            valor = sc.nextInt();
        } while (valor < 0);
        return valor;
    }

    static boolean leerSiNo(Scanner sc, String mensaje) {
        String r;
        do {
            System.out.print(mensaje + " (S/N): ");
            r = sc.next().trim().toUpperCase();
        } while (!r.equals("S") && !r.equals("N"));
        return r.equals("S");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double analisis = leerEnRango(sc, "Nota de análisis: ", 0, 10);
        double diseno = leerEnRango(sc, "Nota de diseño: ", 0, 10);
        double codificacion = leerEnRango(sc, "Nota de codificación: ", 0, 10);
        double avance = leerEnRango(sc, "Porcentaje de avance real: ", 0, 100);
        int errores = leerNoNegativo(sc, "Número de errores: ");
        boolean documentacion = leerSiNo(sc, "¿Documentación completa?");
        boolean exposicion = leerSiNo(sc, "¿Realizó exposición final?");

        double promedio = (analisis + diseno + codificacion) / 3.0;
        double ajusteErrores = -0.5 * errores;
        double ajusteDocumentacion = documentacion ? 0.5 : 0.0;
        double ajusteExposicion = exposicion ? 0.5 : 0.0;
        double notaFinal = promedio + ajusteErrores
                         + ajusteDocumentacion + ajusteExposicion;
        notaFinal = Math.max(0, Math.min(10, notaFinal));

        String estado;
        if (notaFinal >= 9) estado = "Excelente";
        else if (notaFinal >= 7) estado = "Aprobado";
        else if (notaFinal >= 5) estado = "Recuperación";
        else estado = "Reprobado";
        if (avance < 60 && estado.equals("Excelente")) estado = "Aprobado";

        String observacion = (notaFinal >= 7 && !documentacion)
            ? "Buen producto, pero mala formalidad"
            : "Sin observaciones";

        System.out.printf("%nPromedio técnico: %.2f%n", promedio);
        System.out.printf("Ajuste por errores: %.2f%n", ajusteErrores);
        System.out.printf("Ajuste por documentación: +%.2f%n", ajusteDocumentacion);
        System.out.printf("Ajuste por exposición: +%.2f%n", ajusteExposicion);
        System.out.printf("Nota final: %.2f%n", notaFinal);
        System.out.println("Estado: " + estado);
        System.out.println("Observación: " + observacion);
        sc.close();
    }
}

