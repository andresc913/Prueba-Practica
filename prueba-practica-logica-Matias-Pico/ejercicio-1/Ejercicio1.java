import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== COMPETENCIA DE PROGRAMACIÓN POR NIVELES ===");

        // 1. Lectura y validación de Entradas
        System.out.print("Ingrese Puntaje Reto 1: ");
        double reto1 = solicitarNumeroValido(sc);

        System.out.print("Ingrese Puntaje Reto 2: ");
        double reto2 = solicitarNumeroValido(sc);

        System.out.print("Ingrese Puntaje Reto 3: ");
        double reto3 = solicitarNumeroValido(sc);

        System.out.print("Ingrese Número de errores: ");
        int errores = (int) solicitarNumeroValido(sc);

        System.out.print("Ingrese Tiempo total en minutos: ");
        int tiempo = (int) solicitarNumeroValido(sc);

        System.out.print("¿Resolvió desafío extra? (Sí/No): ");
        String extra = solicitarSiNo(sc);

        System.out.print("¿Fue descalificado por copia? (Sí/No): ");
        String copia = solicitarSiNo(sc);

        // 2. Procesos
        double puntajeBase = reto1 + reto2 + reto3;
        double penalizacion = errores * 4.0;
        double bonificacion = 0.0;

        if (extra.equalsIgnoreCase("Sí") || extra.equalsIgnoreCase("Si") || extra.equalsIgnoreCase("S")) {
            bonificacion += 15.0;
        }

        if (tiempo < 30) {
            bonificacion += 10.0;
        }

        double puntajeFinal = puntajeBase - penalizacion + bonificacion;

        // Corrección de límite mínimo
        if (puntajeFinal < 0) {
            puntajeFinal = 0;
        }

        // Asignación de Nivel
        String nivel = "";
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

        // Regla especial de copia
        if (copia.equalsIgnoreCase("Sí") || copia.equalsIgnoreCase("Si") || copia.equalsIgnoreCase("S")) {
            nivel = "Descalificado";
        }

        // Observación por inconsistencia
        String observacion = "Ninguna";
        if (puntajeFinal >= 70 && errores >= 5) {
            observacion = "Resultado inconsistente: revisar calidad de resolución";
        }

        // 3. Salida esperada
        System.out.println("\n================ SALIDA ESPERADA ================");
        System.out.printf("Puntaje base  : %.2f\n", puntajeBase);
        System.out.printf("Penalización  : %.2f\n", penalizacion);
        System.out.printf("Bonificación  : %.2f\n", bonificacion);
        System.out.printf("Puntaje final : %.2f\n", puntajeFinal);
        System.out.println("Nivel         : " + nivel);
        System.out.println("Observación   : " + observacion);
        System.out.println("=================================================");

        sc.close();
    }

    private static double solicitarNumeroValido(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Entrada inválida. Ingrese un valor numérico: ");
            sc.next();
        }
        return sc.nextDouble();
    }

    private static String solicitarSiNo(Scanner sc) {
        String resp = sc.next().trim();
        while (!resp.equalsIgnoreCase("Sí") && !resp.equalsIgnoreCase("Si") && 
               !resp.equalsIgnoreCase("No") && !resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N")) {
            System.out.print("Respuesta no válida. Ingrese Sí/No (o S/N): ");
            resp = sc.next().trim();
        }
        return resp;
    }
}