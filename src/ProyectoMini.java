import java.util.*;
public class ProyectoMini {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
       int num1=0;
        int num2=0;
        int num3=0;
        int[] numeros = new int[3];
         num1=in.nextInt();
         num2=in.nextInt();
         num3=in.nextInt();    
        int[] numero={num1,num2,num3};
        for (int i = 0; i < numero.length; i++) {
            Object elem = numero[i];
            System.out.println(elem+" ");
        }
        }
}
