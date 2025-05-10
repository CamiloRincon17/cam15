import java.util.*;
public class metodo {
  
    public static int encontrarMaximo(int a, int b, int c) {
        int maximo = a;
        if (b > maximo) {
            maximo = b;
        }
        if (c > maximo) {
            maximo = c;
        }
        return maximo;
    }
    public static void main(String[] args) {
        int a,b,c=0;
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el primer numero");
        a=in.nextInt();
        System.out.println("Ingrese el segundo numero ");
        b=in.nextInt();
        System.out.println("Ingrese el tercer numero");
        c=in.nextInt();
        System.out.println("el numero mayor es "+ encontrarMaximo(a, b, c));
    }
  
}
