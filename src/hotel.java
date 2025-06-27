import java.util.*;
public class hotel{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int habitacion = 5;
        String[] Usuario = new String[habitacion];
        int[] Habitaciones =new int[habitacion];
        int[] numerodenoches =new int[habitacion];
        boolean[] habitacionOcupadas = new boolean[habitacion];
        int[] valorapagar = new int[habitacion];
        double Precionoche = 50;
        int opcion=0;
        System.out.println("¡Hola!, ¡Bienvenidos a mi hotel!");
        System.out.println("¿Que quieres hacer?");
        do {

            System.out.println("1: Hacer reserva");
            System.out.println("2: Habitaciones diponibles");
            System.out.println("3: Cancelar reserva");
            System.out.println("4: Mostrar reservas");
            System.out.println("5: Salir del menú");
            opcion=in.nextInt();
            switch (opcion) {
                case 1:
                for (int i = 0; i < habitacion; i++) {

                    if(Habitaciones[i] == 0){
                        System.out.println("La habitacion "+(i+1)+(habitacionOcupadas[i] ? " Ocupada" : " Libre"));
                       
                  
                    }
                }

                System.out.println("Que habitacion quieres para la reserva del (1- 5):");
                    int numHabitacion=in.nextInt() -1 ;
                if(numHabitacion>=5 || numHabitacion<0 ){
                        System.out.println("Habitacion invalida");
                        break;     
                }
                if(Habitaciones[numHabitacion]!=0){
                    System.out.println("Habitacion ya ocupada");
                    break;
                }
           
                    if(Habitaciones[numHabitacion]>0 || Habitaciones[numHabitacion]<=habitacion){

                    System.out.println("Ingrese su nombre");
                    in.nextLine();
                    String NombrePersona=in.nextLine();
                    System.out.println("Cuantas noches se quedara en el Hotel");
                   int Nochesocupadas = in.nextInt();
               
                    System.out.println("\nResumen de reserva:");
                    System.out.println("Habitación: " + (numHabitacion+1));
                    System.out.println("Cliente: " + NombrePersona);
                    System.out.println("Noches: " + Nochesocupadas);
                    System.out.println("Confirme si esta todo bien");
                    System.out.println("ingrese si o no");
                    in.nextLine();
                    String confirmar = in.nextLine().toLowerCase();

                if(confirmar.equals("si")){
                    System.out.println("---------------------------------");
                    System.out.println("Gracias por su reserva señor "+NombrePersona);
                    System.out.println("---------------------------------");
                    Usuario[numHabitacion]=NombrePersona;
                    Habitaciones[numHabitacion]= numHabitacion;
                    numerodenoches[numHabitacion]= Nochesocupadas;
                    habitacionOcupadas[numHabitacion]=true;


                }else{
                    System.out.println("Cancelacion de reserva");
                    break;
                }
            
                 }
                


                break;
                case 2:
                System.out.println("Habitaciones disponibles: ");
                for (int i = 0; i < habitacion; i++) {
                    System.out.println("---------------------");
                
                if(Habitaciones[i] == 0){
                    System.out.println("La habitacion "+(i+1)+(habitacionOcupadas[i] ? " Ocupada" : " Libre"));
              
                }
               
                }
                System.out.println("---------------------");
                break;
                case 3:
                boolean HayReserva = false;
                for(int i=0; i<habitacion;  i++){
                    if(habitacionOcupadas[i]){
                        System.out.println("Las habitaciones Ocupadas son : ");
                        System.out.println(" La habitacion "+(i+1)+" del señor "+Usuario[i]);
                        HayReserva= true;
                       
                    }
                    
                    }
                if(!HayReserva){
                        System.out.println(" No Hay Reservas para cancelar");
                        break;
                }
                System.out.println("Que habitacion deseas cancelar");
                int habitacionCancelar =in.nextInt() -1;
               
                    if (habitacionCancelar<0 || habitacionCancelar>=habitacion) {
                        System.out.println("Numero invalido");
                        break;
                    }
                    if(!habitacionOcupadas[habitacionCancelar]){
                        System.out.println("la habitacion que acaba de ingresar no esta ocupada");
                        break;
                    }
                    if (habitacionOcupadas[habitacionCancelar]){
                        numerodenoches[habitacionCancelar] = 0;
                        Usuario[habitacionCancelar] = null;
                        habitacionOcupadas[habitacionCancelar]=false;
                        Habitaciones[habitacionCancelar]=0;
                        System.out.println("Cancelacion correcta");
                    }
                    
                   
                
                    
                    break;
                case 4:
                boolean hayReservas = false;
                for(int i=0; i<habitacion; i++) {
                  if(habitacionOcupadas[i]) {
                    System.out.println("Habitación "+(i+1)+": "+Usuario[i]+", "+numerodenoches[i]+" noches");
                     hayReservas = true;
                  }
                  }
                  if(!hayReservas) {
                 System.out.println("No se han hecho reservas");
                  }
                    break;
                case 5:
                System.out.println("REPORTE FINAL DEL HOTEL ");
                System.out.println("---------------------------------");
                
                int ocupadas = 0;
                double ingresosTotales = 0.0;
                for (int i = 0; i < habitacion; i++) {
                    System.out.print("Habitación " + (i+1) + ": ");
                    if (habitacionOcupadas[i]) {
                        ocupadas++;
                        double total = numerodenoches[i] * Precionoche;
                        ingresosTotales += total;
                        System.out.println("OCUPADA por " + Usuario[i] + 
                                         " - " + numerodenoches[i] + " noches" +
                                         " - Total: " + total);
                    } else {
                        System.out.println("DISPONIBLE");
                    }
                }
                
                System.out.println("\nRESUMEN FINAL:");
                System.out.println("Habitaciones ocupadas: " + ocupadas);
                System.out.println("Habitaciones disponibles: " + (habitacion - ocupadas));
                System.out.println("Ingresos totales proyectados: " + ingresosTotales);
                System.out.println("---------------------------------");
                System.out.println("Saliendo del sistema...");
                break;
            

                default:
                System.out.println("Opción inválida");
            }
            
        }while (opcion!=6);

    }
}
