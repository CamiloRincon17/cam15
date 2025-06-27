class Persona {
    String name;
}

public class stepforreference {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.name = "Camilo";
        cambiarNombre(persona);
        System.out.println("Nombre después de ser cambiado " + persona.name);  // Debería imprimir María
    }

    public static void cambiarNombre(Persona persona) {
        persona.name = "idk";
    }
}
