import java.util.*;
public class ProyectoMini {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
       int num1=0;
        int num2=0;
        int num3=0;
        int suma=0;
        int promedio=0;
        int contador = 0;
        int[] numeros = new int[3];
        System.out.println("ingrese el primer numero");
        num1=in.nextInt();
        System.out.println("ingrese el segundo numero");
        num2=in.nextInt();
        System.out.println("ingrese el tercer numero");
        num3=in.nextInt();    
        int[] numero={num1,num2,num3};
        for (int i = 0; i < numero.length; i++) {
            Object elem = numero[i];
            System.out.println("el numero es "+elem+" ");
            suma += numero[i];
            System.out.println("la suma hasta ahora es "+suma);
            contador=contador+1;
        }
        promedio=suma/contador;
        System.out.println("EL RPOMEDIO DE LOS NUMEROS QUE INGRESO ES "+promedio);
        }
}
