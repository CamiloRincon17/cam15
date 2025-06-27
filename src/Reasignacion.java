class Persona {
    String nombre;
}

public class Reasignacion {
    public static void main(String[] args) {
        Persona person = new Persona();
        person.nombre = "cami";
        reasignarPersona(person);
        System.out.println("name after change" + person.nombre);  
    }

    public static void reasignarPersona(Persona person) {
        person = new Persona();  
        person.nombre = "abel";
    }
}