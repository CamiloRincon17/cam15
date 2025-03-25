
import java.util.Scanner;

public class Poligono {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrse la opcion que necesite");
        System.out.println("1: rectangulo");
        System.out.println("2: cuadrado");
        System.out.println("3: paralelogramo");
        System.out.println("4: Triangulo");
        System.out.println("5: Trapecio");
        System.out.println("6: Poligono Rectangular");
        int Are =in.nextInt();
        switch (Are) {
            case 1:
                System.out.println("Ingrese los sigientes valores:");
                System.out.println("Ingrese la altura");
                int altura=in.nextInt();
                System.out.println("Ingrese lo largo");
                int largo = in.nextInt();

                System.out.println("La area del rectatangulo es :"+(largo*altura));
                break;
            case 2:
                System.out.println("Ingrese el sigiente valor:");
                System.out.println("Ingrese lo largo o alto");
                largo = in.nextInt();
                int area = largo*largo;
                System.out.println("La area  es :"+area);
                break;
            case 3:
                System.out.println("Ingrese los sigientes valores:");
                System.out.println("Ingrese la altura");
                altura=in.nextInt();
                System.out.println("Ingrese lo largo");
                largo = in.nextInt();
                System.out.println("La area es :"+(largo*altura));
                break;
            case 4:
                System.out.println("Ingrese los sigientes valores:");
                System.out.println("Ingrese la altura");
                altura=in.nextInt();
                System.out.println("Ingrese lo largo");
                largo = in.nextInt();
                area=((largo*altura)/2);
                System.out.println("La area es :"+(area));
                break;
            case 5:
                System.out.println("Ingrese los sigientes valores:");
                System.out.println("Ingrese la altura");
                altura=in.nextInt();
                System.out.println("Ingrese lo largo de arriba");
                largo = in.nextInt();
                System.out.println("Ingrese el largo de abajo");
                int LargoDown =in.nextInt();
                area=(((largo+LargoDown)/2)*altura);
                System.out.println("La area es :"+(area));
                break;
            case 6:
                System.err.println("Ingrese los siguientes valores");
                System.out.println("Ingrese el perimetro");
                int perimetro =in.nextInt();
                System.out.println("Ingrese el Apotema(el apotema es lo que mide de un lado hasta el centro)");
                int Ap = in.nextInt();
                area=((perimetro*Ap)/2);
                System.out.println("la area es "+area);
                break;
            default:
        }
        }
    }
