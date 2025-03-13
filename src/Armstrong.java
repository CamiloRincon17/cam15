
import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numero=0;
        int numero2=0;
        int contador=0;
        System.out.println("Ingrese un numero");
        numero = in.nextInt();
        
   
        }
        while (numero != 0) { 
            numero = numero/10;
            contador++;
        }
        
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

        String cadenaNumero = Integer.toString(numero);
        for (int i = 0; i < cadenaNumero.length; i++) {
            char digitoChar = cadenaNumero.charAt(i);
            int digito = Character.getNumericValue(digitoChar);
            System.out.println("Dígito " + (i +1) + ": " + digito);

    
    }
}
