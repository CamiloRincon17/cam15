import java.util.HashMap;
import java.util.Scanner;

class Pokemones {
    String nombre;
    int ataque;
    int defensa;
    int hp;
    int maxHp;

    public Pokemones(String nombre, int ataque, int defensa, int hp, int maxHp) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.hp = hp;
        this.maxHp = maxHp;
    }

    public int ataqueNormal(Pokemones oponente) {
        int danio = Math.max(ataque - oponente.defensa / 2, 5);
        oponente.hp -= danio;
        if (oponente.hp < 0) oponente.hp = 0;
        return danio;
    }

    public int ataqueEspecial(Pokemones oponente) {
        int danio = Math.max((ataque * 2) - oponente.defensa, 10);
        oponente.hp -= danio;
        if (oponente.hp < 0) oponente.hp = 0;
        return danio;
    }

    public int ataqueRapido(Pokemones oponente) {
        int danio = (int)(ataque * 0.7);
        oponente.hp -= danio;
        if (oponente.hp < 0) oponente.hp = 0;
        return danio;
    }

    public void curar() {
        hp += 20;
        if (hp > maxHp) hp = maxHp;
    }

    public boolean estaDerrotado() {
        return hp <= 0;
    }
}

public class PokemonConsola {
    static HashMap<String, Pokemones> pokemones = new HashMap<>();
    static Pokemones jugador1Pokemon, jugador2Pokemon;
    static boolean turnoJugador1 = true;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializar Pokémon disponibles
        pokemones.put("Pikachu", new Pokemones("Pikachu", 40, 25, 150, 150));
        pokemones.put("Charmander", new Pokemones("Charmander", 35, 25, 145, 145));
        pokemones.put("Bulbasaur", new Pokemones("Bulbasaur", 30, 30, 160, 160));
        pokemones.put("Squirtle", new Pokemones("Squirtle", 30, 35, 148, 148));

        System.out.println("¡Bienvenido a la Batalla Pokémon!\n");

        // Selección de Pokémon
        System.out.println("Pokémon disponibles:");
        pokemones.keySet().forEach(System.out::println);

        System.out.print("\nJugador 1, elige tu Pokémon: ");
        String pokemonJugador1 = scanner.nextLine();
        System.out.print("Jugador 2, elige tu Pokémon: ");
        String pokemonJugador2 = scanner.nextLine();

        // Validación
        if (pokemonJugador1.equals(pokemonJugador2)) {
            System.out.println("❌ Los jugadores no pueden elegir el mismo Pokémon.");
            return;
        }

        jugador1Pokemon = new Pokemones(
            pokemones.get(pokemonJugador1).nombre,
            pokemones.get(pokemonJugador1).ataque,
            pokemones.get(pokemonJugador1).defensa,
            pokemones.get(pokemonJugador1).hp,
            pokemones.get(pokemonJugador1).maxHp
        );

        jugador2Pokemon = new Pokemones(
            pokemones.get(pokemonJugador2).nombre,
            pokemones.get(pokemonJugador2).ataque,
            pokemones.get(pokemonJugador2).defensa,
            pokemones.get(pokemonJugador2).hp,
            pokemones.get(pokemonJugador2).maxHp
        );

        System.out.println("\n🎮 ¡Que comience la batalla!");
        System.out.println("🔵 Jugador 1: " + jugador1Pokemon.nombre);
        System.out.println("🔴 Jugador 2: " + jugador2Pokemon.nombre);

        // Bucle principal del juego
        while (true) {
            Pokemones atacante = turnoJugador1 ? jugador1Pokemon : jugador2Pokemon;
            Pokemones defensor = turnoJugador1 ? jugador2Pokemon : jugador1Pokemon;
            String jugadorActual = turnoJugador1 ? "Jugador 1" : "Jugador 2";

            System.out.println("\n--- Turno de " + jugadorActual + " (" + atacante.nombre + ") ---");
            System.out.println("1. Ataque Normal");
            System.out.println("2. Ataque Especial");
            System.out.println("3. Ataque Rápido");
            System.out.println("4. Curar (+20 HP)");
            System.out.print("Elige tu acción: ");

            int accion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (accion) {
                case 1:
                    int danioNormal = atacante.ataqueNormal(defensor);
                    System.out.println(atacante.nombre + " usó Ataque Normal y causó " + danioNormal + " de daño!");
                    break;
                case 2:
                    int danioEspecial = atacante.ataqueEspecial(defensor);
                    System.out.println(atacante.nombre + " usó Ataque Especial y causó " + danioEspecial + " de daño!");
                    break;
                case 3:
                    int danioRapido = atacante.ataqueRapido(defensor);
                    System.out.println(atacante.nombre + " usó Ataque Rápido y causó " + danioRapido + " de daño!");
                    break;
                case 4:
                    int hpAntes = atacante.hp;
                    atacante.curar();
                    System.out.println(atacante.nombre + " se curó y recuperó " + (atacante.hp - hpAntes) + " HP!");
                    break;
                default:
                    System.out.println("Acción no válida. Pierdes tu turno!");
            }

            // Mostrar estado actual
            System.out.println("\n📊 Estado actual:");
            System.out.println(jugador1Pokemon.nombre + ": " + jugador1Pokemon.hp + "/" + jugador1Pokemon.maxHp + " HP");
            System.out.println(jugador2Pokemon.nombre + ": " + jugador2Pokemon.hp + "/" + jugador2Pokemon.maxHp + " HP");

            // Verificar si hay un ganador
            if (defensor.estaDerrotado()) {
                System.out.println("\n💥 " + defensor.nombre + " ha sido derrotado!");
                System.out.println("🏆 ¡" + atacante.nombre + " es el ganador!");
                break;
            }

            // Cambiar turno
            turnoJugador1 = !turnoJugador1;
        }
    }
}