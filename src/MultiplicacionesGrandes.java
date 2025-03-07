import java.util.Scanner;
public class MultiplicacionesGrandes {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int CantidadNumeros=0;
    System.out.println("ingrese la cantidad de numeros a miltiplicar");
    CantidadNumeros=in.nextInt();
    int[] array={CantidadNumeros};
    
    double resultado=1;
    for (int i = 0; i < CantidadNumeros; i++) {
        System.out.println("Ingrese el numero "+(i+1)+" ");
        array[i]=in.nextInt();
    }
    for (int i = 0; i < CantidadNumeros; i++) {
        resultado*=array[i];
        
    }
System.out.println(resultado);
    }
}
