import java.util.Scanner;
public class NumberCousin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int FirstNumber=0;
        System.out.println("Ingrese el primer numero");
        FirstNumber = in.nextInt();
        int SecondNumber=0;
        System.out.println("Ingresa el segundo numero");
        SecondNumber = in.nextInt();
        int Divisor=0;
       while(FirstNumber<=SecondNumber){
       Divisor=Divisor+1;
       FirstNumber++;
       int resultado=FirstNumber/Divisor;
          System.out.println("FirstNumber/Divisor"+resultado);
          
       }


    
}
         
      }    

    

    
