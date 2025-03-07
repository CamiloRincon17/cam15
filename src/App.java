import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Pedir la cantidad de números a multiplicar
        System.out.println("Ingrese la cantidad de números a multiplicar:");
        int CantidadNumeros = in.nextInt();

        // Crear un array para almacenar los números
        double[] array = new double[CantidadNumeros];

        // Pedir al usuario que ingrese los números
        for (int i = 0; i < CantidadNumeros; i++) {
            System.out.println("Ingrese el número " + (i + 1) + ":");
            array[i] = in.nextDouble();
        }

        // Calcular la multiplicación de los números
        double resultado = 1; // Inicializar con 1 porque es el elemento neutro de la multiplicación
        for (int i = 0; i < CantidadNumeros; i++) {
            resultado *= array[i]; // Multiplicar cada número
        }

        // Mostrar el resultado
        System.out.println("El resultado de la multiplicación es: " + resultado);
    }
}