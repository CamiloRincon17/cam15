
import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numero=0;
        System.out.println("Ingrese un numero");
        numero = in.nextInt();
        int contador=0;
        for (int i = 1; i < 10; i++) {
            int divicion = numero/i;
            if (i<numero) {
               numero= numero/10;
                contador = contador+1;
               System.out.println(""+numero);
            }
            else if(contador==4){
            
            }   
               
        
        
        
        }


    
    }
}
