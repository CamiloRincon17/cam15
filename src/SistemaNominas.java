import java.util.ArrayList;
import java.util.Scanner;

// Clase base Empleado
class Empleado {
    private String nombre;
    private double salarioBase;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public double calcularSalario() {
        return salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarDetalles() {
        System.out.printf("👨‍💼 %s | Salario: $%.2f\n", nombre, calcularSalario());
    }
}

// Clase derivada Gerente
class Gerente extends Empleado {
    private double bono;

    public Gerente(String nombre, double salarioBase, double bono) {
        super(nombre, salarioBase);
        this.bono = bono;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bono;
    }

    @Override
    public void mostrarDetalles() {
        System.out.printf("👔 %s | Salario: $%.2f (Incluye bono: $%.2f)\n", 
                         getNombre(), calcularSalario(), bono);
    }
}

public class SistemaNominas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>();
        
        // Datos iniciales
        empleados.add(new Empleado("Carlos Pérez", 1500));
        empleados.add(new Gerente("Ana Gómez", 2000, 500));

        while (true) {
            System.out.println("\n=== SISTEMA DE NÓMINAS ===");
            System.out.println("1. Mostrar empleados");
            System.out.println("2. Agregar empleado");
            System.out.println("3. Agregar gerente");
            System.out.println("4. Calcular nómina total");
            System.out.println("5. Salir");
            System.out.print("Seleccione opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\n--- EMPLEADOS REGISTRADOS ---");
                    for (Empleado emp : empleados) {
                        emp.mostrarDetalles();
                    }
                    break;
                    
                case 2:
                    System.out.print("Nombre del empleado: ");
                    String nombreEmp = sc.nextLine();
                    System.out.print("Salario base: ");
                    double salario = sc.nextDouble();
                    empleados.add(new Empleado(nombreEmp, salario));
                    System.out.println("✅ Empleado agregado!");
                    break;
                    
                case 3:
                    System.out.print("Nombre del gerente: ");
                    String nombreGer = sc.nextLine();
                    System.out.print("Salario base: ");
                    double salarioGer = sc.nextDouble();
                    System.out.print("Bono anual: ");
                    double bono = sc.nextDouble();
                    empleados.add(new Gerente(nombreGer, salarioGer, bono));
                    System.out.println("✅ Gerente agregado!");
                    break;
                    
                case 4:
                    double total = 0;
                    for (Empleado emp : empleados) {
                        total += emp.calcularSalario();
                    }
                    System.out.printf("\n💵 Nómina total: $%.2f\n", total);
                    break;
                    
                case 5:
                    System.out.println("Saliendo del sistema...");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}