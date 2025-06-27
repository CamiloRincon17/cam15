
import java.util.Scanner;

class calcular{
public void sumar(double number1, double number2){
    System.out.println("La suma de estos numeros ingresados es "+number1+ " + "+number2+" = "+(number1+number2));
}
public void multiplicar(double number1, double number2){
    System.out.println("La multiplicacion de estos numeros ingresados es "+number1+ " * "+number2+" = "+(number1*number2));

}
public void restar(double number1, double number2){
    System.out.println("La restar de estos numeros ingresados es "+number1+ " - "+number2+" = "+(number1-number2));

}
public void dividir(double number1, double number2){
    System.out.println("La divicion de estos numeros ingresados es "+number1+ " / "+number2+" = "+(number1/number2));

}
}
public class calculadora{
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    calcular miCalculadora = new calcular();

    System.out.println("Ingrese el primer numero");
    double number1=0;
    double number2=0;
    int opcion=0;
    number1=in.nextDouble();
    System.out.println("ingrese el segundo numero");
    number2=in.nextDouble();
System.out.println("Calculadora Básica");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.print("Seleccione una opción (1-4): ");
        opcion = in.nextInt();
    switch (opcion) {
       case 1:
                miCalculadora.sumar(number1, number2);
                break;
            case 2:
                miCalculadora.restar(number1, number2);
                break;
            case 3:
                miCalculadora.multiplicar(number1, number2);
                break;
            case 4:
                miCalculadora.dividir(number1, number2);
                break;
            default:
                System.out.println("Opción no válida");
    }
}
}