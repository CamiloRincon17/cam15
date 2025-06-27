import java.util.Scanner;

public class EstudiantesApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Ingrese el nombre:");
            String name = in.nextLine();

            System.out.println("Ingrese la edad:");
            int age = in.nextInt();

            System.out.println("Ingrese la nota media:");
            double notaMedia = in.nextDouble();

            Estudiantes estudiante = new Estudiantes(name, age, notaMedia);

            System.out.println("\nLos datos del estudiante son:");
            estudiante.mostrarDetalles();

            if (estudiante.aprueba()) {
                System.out.println("✅ ¡Has pasado la materia!");
            } else {
                System.out.println("❌ Usted ha perdido la materia.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Error en la entrada de datos.");
        } finally {
            in.close();
        }
    }
}

class Estudiante {
    private String name;
    private int age;
    private double notaMedia;

    public Estudiante(String name, int age, double notaMedia) {
        this.name = name;
        this.age = age;
        this.notaMedia = notaMedia;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getNotaMedia() { return notaMedia; }

    public void setNombre(String name) { this.name = name; }
    public void setEdad(int age) { this.age = age; }
    public void setNotaMedia(double notaMedia) { this.notaMedia = notaMedia; }

    public void mostrarDetalles() {
        System.out.println("Nombre: " + name);
        System.out.println("Edad: " + age);
        System.out.println("Nota media: " + notaMedia);
    }

    public boolean aprueba() {
        return notaMedia >= 30;
    }
}
