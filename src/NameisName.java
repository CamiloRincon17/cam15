
import java.util.Scanner;

public class NameisName {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String Name = "";
        System.out.println("Ingresa el primer nombre");
        Name =in.nextLine();
        String Nameis = "";
        System.out.println("Ingrese el segundo nombre");
        Nameis = in.nextLine();
        if(Name.equals(Nameis)){
            System.out.println("Los nombres son iguales");
        
        }
        else{
            System.out.println("Los nombres son diferentes");
        }

    }
}
