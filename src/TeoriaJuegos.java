import java.util.Scanner;

public class TeoriaJuegos {

    static class Jugador {
        String nombre;
        int puntuacion;
        String ultimaDecision;

        public Jugador(String nombre) {
            this.nombre = nombre;
            this.puntuacion = 0;
            this.ultimaDecision = "";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("JUEGO DEL DILEMA DEL PRISIONERO");
        System.out.println("Reglas:");
        System.out.println("- Dos jugadores eligen cooperar (C) o traicionar (T)");
        System.out.println("- Si ambos cooperan: +3 puntos cada uno");
        System.out.println("- Si uno traiciona y otro coopera: Traidor +5, Cooperador 0");
        System.out.println("- Si ambos traicionan: +1 punto cada uno");
        System.out.println("--------------------------------------");

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        System.out.print("Número de rondas: ");
        int rondas = scanner.nextInt();

        for (int i = 1; i <= rondas; i++) {
            System.out.println("\nRonda " + i);
            
            String decision1 = obtenerDecision(jugador1, scanner);
            String decision2 = obtenerDecision(jugador2, scanner);

            calcularPuntos(jugador1, jugador2, decision1, decision2);
            
            System.out.println("\nResultados:");
            System.out.println(jugador1.nombre + ": " + decision1 + 
                             " | Puntos: " + jugador1.puntuacion);
            System.out.println(jugador2.nombre + ": " + decision2 + 
                             " | Puntos: " + jugador2.puntuacion);
        }

        mostrarResultadoFinal(jugador1, jugador2);
    }

    private static String obtenerDecision(Jugador jugador, Scanner scanner) {
        System.out.print(jugador.nombre + ", elige (C/T): ");
        String decision = scanner.next().toUpperCase();
        while (!decision.equals("C") && !decision.equals("T")) {
            System.out.println("Entrada inválida. Usa C o T");
            decision = scanner.next().toUpperCase();
        }
        jugador.ultimaDecision = decision;
        return decision;
    }

    private static void calcularPuntos(Jugador j1, Jugador j2, 
                                      String d1, String d2) {
        if (d1.equals("C") && d2.equals("C")) {
            j1.puntuacion += 3;
            j2.puntuacion += 3;
        } else if (d1.equals("T") && d2.equals("C")) {
            j1.puntuacion += 5;
            j2.puntuacion += 0;
        } else if (d1.equals("C") && d2.equals("T")) {
            j1.puntuacion += 0;
            j2.puntuacion += 5;
        } else {
            j1.puntuacion += 1;
            j2.puntuacion += 1;
        }
    }

    private static void mostrarResultadoFinal(Jugador j1, Jugador j2) {
        System.out.println("\n=== RESULTADO FINAL ===");
        System.out.println(j1.nombre + ": " + j1.puntuacion + " puntos");
        System.out.println(j2.nombre + ": " + j2.puntuacion + " puntos");

        if (j1.puntuacion > j2.puntuacion) {
            System.out.println(j1.nombre + " gana!");
        } else if (j2.puntuacion > j1.puntuacion) {
            System.out.println(j2.nombre + " gana!");
        } else {
            System.out.println("Empate!");
        }
    }
}