
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
        int N=0;
        System.out.println("Ingrese la cantidad de numeros");
        N=in.nextInt();
        int N1=0;
        int N2 = 1;
        int Condicional=0;

        for (int i = 0; i < N; i++) {
            if (i<=0){
                System.out.println("0");
            }
            else if (i<=1){
                System.out.println("1");
        

 
           }
           else{
           Condicional=N1+N2;
           N1=N2;
           N2=Condicional;
           System.out.println(" "+Condicional);

}    

        }

    }
}
