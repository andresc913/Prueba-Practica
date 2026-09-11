import java.util.Scanner;

public class EvaluacionProyecto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double analisis;
        do {
            System.out.print("Nota de análisis: ");
            analisis = sc.nextDouble();
            if (analisis < 0 || analisis > 10) {
                System.out.println("El valor debe estar entre 0 y 10.");
            }
        } while (analisis < 0 || analisis > 10);

        double diseno;
        do {
            System.out.print("Nota de diseño: ");
            diseno = sc.nextDouble();
            if (diseno < 0 || diseno > 10) {
                System.out.println("El valor debe estar entre 0 y 10.");
            }
        } while (diseno < 0 || diseno > 10);

        double codificacion;
        do {
            System.out.print("Nota de codificación: ");
            codificacion = sc.nextDouble();
            if (codificacion < 0 || codificacion > 10) {
                System.out.println("El valor debe estar entre 0 y 10.");
            }
        } while (codificacion < 0 || codificacion > 10);

        double avance;
        do {
            System.out.print("Porcentaje de avance real: ");
            avance = sc.nextDouble();
            if (avance < 0 || avance > 100) {
                System.out.println("El valor debe estar entre 0 y 100.");
            }
        } while (avance < 0 || avance > 100);

        int errores;
        do {
            System.out.print("Número de errores: ");
            errores = sc.nextInt();
            if (errores < 0) {
                System.out.println("El valor no puede ser negativo.");
            }
        } while (errores < 0);

        String respDoc;
        do {
            System.out.print("¿Documentación completa? (S/N): ");
            respDoc = sc.next();
        } while (!respDoc.equalsIgnoreCase("S") && !respDoc.equalsIgnoreCase("N"));

        String respExp;
        do {
            System.out.print("¿Realizó exposición final? (S/N): ");
            respExp = sc.next();
        } while (!respExp.equalsIgnoreCase("S") && !respExp.equalsIgnoreCase("N"));

        double promedio = (analisis + diseno + codificacion) / 3.0;
        double ajusteErrores = -0.5 * errores;

        double ajusteDocumentacion = 0.0;
        if (respDoc.equalsIgnoreCase("S")) {
            ajusteDocumentacion = 0.5;
        }

        double ajusteExposicion = 0.0;
        if (respExp.equalsIgnoreCase("S")) {
            ajusteExposicion = 0.5;
        }

        double notaFinal = promedio + ajusteErrores + ajusteDocumentacion + ajusteExposicion;

        if (notaFinal > 10.0) {
            notaFinal = 10.0;
        }
        if (notaFinal < 0.0) {
            notaFinal = 0.0;
        }

        String estado = "";
        if (notaFinal >= 9.0) {
            estado = "Excelente";
        } else if (notaFinal >= 7.0) {
            estado = "Aprobado";
        } else if (notaFinal >= 5.0) {
            estado = "Recuperación";
        } else {
            estado = "Reprobado";
        }

        if (avance < 60.0 && estado.equals("Excelente")) {
            estado = "Aprobado";
        }

        String observacion = "";
        if (notaFinal >= 7.0 && respDoc.equalsIgnoreCase("N")) {
            observacion = "Buen producto, pero mala formalidad";
        } else {
            observacion = "Sin observaciones";
        }

        System.out.printf("%nPromedio técnico: %.2f%n", promedio);
        System.out.printf("Ajuste por errores: %.2f%n", ajusteErrores);
        System.out.printf("Ajuste por documentación: +%.2f%n", ajusteDocumentacion);
        System.out.printf("Ajuste por exposición: +%.2f%n", ajusteExposicion);
        System.out.printf("Nota final: %.2f%n", notaFinal);
        System.out.println("Estado: " + estado);
        System.out.println("Observación: " + observacion);

    }
}
