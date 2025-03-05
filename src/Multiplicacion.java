import java.util.Scanner;
public class Multiplicacion{
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int num1=0;
        int num2=0;
        System.err.println("Ingresa el primer numero");
        num1=in.nextInt();
        System.err.println("Ingresa el segundo numero");
        num2=in.nextInt();
        int Multipicacion=num1*num2;
        System.err.println("La multipicacion de sus dos numeros es "+ Multipicacion);

    }
}