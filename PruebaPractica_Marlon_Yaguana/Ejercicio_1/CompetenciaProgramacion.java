import java.util.Scanner;

public class CompetenciaProgramacion {
    static int leerNoNegativo(Scanner sc, String mensaje) {
        int valor;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextInt()) {
                System.out.print("Ingrese un número entero válido: ");
                sc.next();
            }
            valor = sc.nextInt();
            if (valor < 0) System.out.println("El valor no puede ser negativo.");
        } while (valor < 0);
        return valor;
    }

    static boolean leerSiNo(Scanner sc, String mensaje) {
        String respuesta;
        do {
            System.out.print(mensaje + " (S/N): ");
            respuesta = sc.next().trim().toUpperCase();
        } while (!respuesta.equals("S") && !respuesta.equals("N"));
        return respuesta.equals("S");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int reto1 = leerNoNegativo(sc, "Puntaje reto 1: ");
        int reto2 = leerNoNegativo(sc, "Puntaje reto 2: ");
        int reto3 = leerNoNegativo(sc, "Puntaje reto 3: ");
        int errores = leerNoNegativo(sc, "Número de errores: ");
        int tiempo = leerNoNegativo(sc, "Tiempo total en minutos: ");
        boolean extra = leerSiNo(sc, "¿Resolvió el desafío extra?");
        boolean copia = leerSiNo(sc, "¿Fue descalificado por copia?");

        int puntajeBase = reto1 + reto2 + reto3;
        int penalizacion = errores * 4;
        int bonificacion = (extra ? 15 : 0) + (tiempo < 30 ? 10 : 0);
        int puntajeFinal = Math.max(0, puntajeBase - penalizacion + bonificacion);

        String nivel;
        if (puntajeFinal < 30) nivel = "Principiante";
        else if (puntajeFinal < 50) nivel = "Básico";
        else if (puntajeFinal < 70) nivel = "Intermedio";
        else if (puntajeFinal < 90) nivel = "Avanzado";
        else nivel = "Experto";
        if (copia) nivel = "Descalificado";

        String observacion = (puntajeFinal >= 70 && errores >= 5)
            ? "Resultado inconsistente: revisar calidad de resolución"
            : "Sin observaciones";

        System.out.println("\nPuntaje base: " + puntajeBase);
        System.out.println("Penalización: " + penalizacion);
        System.out.println("Bonificación: " + bonificacion);
        System.out.println("Puntaje final: " + puntajeFinal);
        System.out.println("Nivel: " + nivel);
        System.out.println("Observación: " + observacion);
        sc.close();
    }
}

