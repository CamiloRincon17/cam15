public class Nominas {
    
}
class empleados{
    private String nombre;
    private double salarioBase;
    public empleados(String nombre,double salarioBase){
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }
    public double  getsalario(){
        return salarioBase;
    }
    public String getname(){
        return nombre;
    }
    public void getAll{
        System.out.printf("👨‍💼 %s | Salario: $%.2f\n", nombre, calcularSalario());
    }
    
}