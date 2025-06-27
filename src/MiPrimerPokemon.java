public class MiPrimerPokemon {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", 40, 100);
        Pokemon charmander = new Pokemon("Charmander", 35, 100);

        pikachu.atacar(charmander);
        charmander.atacar(pikachu);
    }
}
class Pokemon{
    String nombre;
    int poder;
    int vida;
    public Pokemon(String nombre, int poder , int vida){
        this.nombre = nombre;
        this.poder = poder;
        this.vida = vida;
    }
    public void atacar(Pokemon enemigo){
        enemigo.vida -= this.poder;
        System.out.println(this.nombre + " atacó a " + enemigo.nombre + "y le quito "+ this.poder+ "de vida");
        System.out.println("La vida de " + enemigo.nombre+" ahors es "+ enemigo.vida);
    }
}