
import java.util.Scanner;

public class Estudiantes {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("ingrese el nombre");
        String name=in.nextLine();
        System.out.println("Ingrese la edad");
        int age= in.nextInt();
        System.out.println("ingresa la nota media");
        double notaMedia = in.nextDouble();
        EstudiantesApp estudiante = new EstudiantesApp(name, age, notaMedia);

        System.out.println("Los datos del estudiante son: ");
        estudiante.mostrarDetalles();
        if (estudiante.aprueba()){
            System.out.println("haz pasado la materia");
        }else{System.out.println("usted ha perdido la materia");}


    }
}
class EstudiantesApp{
    private String name;
    private int age;
    private double notaMedia;
    public EstudiantesApp(String name, int age, double notaMedia){
        this.name = name;
        this.age = age;
        this.notaMedia = notaMedia;

    }

    public String getname(){return name;}
    public int getage(){return age;}
    public double getnotaMedia(){return notaMedia;}

        public void setNombre(String name) { this.name = name; }
        public void setEdad(int age) { this.age = age; }
        public void setNotaMedia(double notaMedia) { this.notaMedia = notaMedia; }
    public void mostrarDetalles(){
        System.out.println("Nombre"+name);
        System.out.println("Edad "+ age);
        System.out.println("Nota media"+ notaMedia);
    }
    public boolean aprueba(){
        return notaMedia>=30;
    }
}
