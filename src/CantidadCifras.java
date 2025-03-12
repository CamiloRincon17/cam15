
import java.util.Scanner;

public class CantidadCifras {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int NumeroN=0;
        int contador = 0;
        System.out.println("ingresa un numero");
        NumeroN=in.nextInt();
        while (NumeroN !=0){
            NumeroN = NumeroN/10;
            contador++;
       
        }
   System.out.println("Su numero tiene "+contador+" cifras");
    }
}
