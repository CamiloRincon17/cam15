import java.util.*;

public class InverseNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalHabitaciones = 5;
        String[] usuarios = new String[totalHabitaciones];
        boolean[] habitacionesOcupadas = new boolean[totalHabitaciones]; // true = ocupada
        int[] noches = new int[totalHabitaciones];
        double precioPorNoche = 50;
        int opcion = 0;

        System.out.println("Bienvenido al sistema de reservas del hotel");

        do {
            System.out.println("\n1: Hacer reserva");
            System.out.println("2: Disponibilidad");
            System.out.println("3: Cancelar reserva");
            System.out.println("4: Mostrar reservas");
            System.out.println("5: Salir del menú");
            System.out.print("Seleccione una opción: ");
            opcion = in.nextInt();

            switch (opcion) {
                case 1: // Hacer reserva
                    // Mostrar habitaciones disponibles
                    System.out.println("\nHabitaciones disponibles:");
                    for (int i = 0; i < totalHabitaciones; i++) {
                        System.out.println("Habitación " + (i+1) + ": " + 
                                        (habitacionesOcupadas[i] ? "Ocupada" : "Libre"));
                    }

                    // Seleccionar habitación
                    System.out.print("\n¿Qué habitación desea reservar? (1-" + totalHabitaciones + "): ");
                    int habitacionElegida = in.nextInt() - 1; // Convertir a índice del array

                    // Validar selección
                    if (habitacionElegida < 0 || habitacionElegida >= totalHabitaciones) {
                        System.out.println("Número de habitación inválido");
                        break;
                    }

                    if (habitacionesOcupadas[habitacionElegida]) {
                        System.out.println("Esta habitación ya está ocupada");
                        break;
                    }

                    // Tomar datos del cliente
                    System.out.print("Ingrese su nombre: ");
                    in.nextLine(); // Limpiar buffer
                    usuarios[habitacionElegida] = in.nextLine();

                    System.out.print("¿Cuántas noches se hospedará?: ");
                    noches[habitacionElegida] = in.nextInt();

                    // Confirmar reserva
                    System.out.println("\nResumen de reserva:");
                    System.out.println("Nombre: " + usuarios[habitacionElegida]);
                    System.out.println("Habitación: " + (habitacionElegida + 1));
                    System.out.println("Noches: " + noches[habitacionElegida]);
                    System.out.println("Total a pagar: $" + (noches[habitacionElegida] * precioPorNoche));

                    System.out.print("¿Confirmar reserva? (si/no): ");
                    String confirmacion = in.next();

                    if (confirmacion.equalsIgnoreCase("si")) {
                        habitacionesOcupadas[habitacionElegida] = true;
                        System.out.println("Reserva confirmada!");
                    } else {
                        // Limpiar datos si no se confirma
                        usuarios[habitacionElegida] = null;
                        noches[habitacionElegida] = 0;
                        System.out.println("Reserva cancelada");
                    }
                    break;

                case 2: // Disponibilidad
                    System.out.println("\nEstado de las habitaciones:");
                    for (int i = 0; i < totalHabitaciones; i++) {
                        System.out.println("Habitación " + (i+1) + ": " + 
                                        (habitacionesOcupadas[i] ? "Ocupada" : "Libre"));
                    }
                    break;

                case 3: // Cancelar reserva
                    System.out.println("\nReservas actuales:");
                    boolean hayReservas = false;
                    for (int i = 0; i < totalHabitaciones; i++) {
                        if (habitacionesOcupadas[i]) {
                            System.out.println("Habitación " + (i+1) + ": " + usuarios[i] + 
                                            " - " + noches[i] + " noches");
                            hayReservas = true;
                        }
                    }

                    if (!hayReservas) {
                        System.out.println("No hay reservas para cancelar");
                        break;
                    }

                    System.out.print("\n¿Qué habitación desea cancelar? (1-" + totalHabitaciones + "): ");
                    int habitacionACancelar = in.nextInt() - 1;

                    if (habitacionACancelar < 0 || habitacionACancelar >= totalHabitaciones) {
                        System.out.println("Número de habitación inválido");
                        break;
                    }

                    if (!habitacionesOcupadas[habitacionACancelar]) {
                        System.out.println("Esta habitación no está reservada");
                        break;
                    }

                    System.out.print("¿Está seguro que desea cancelar la reserva de la habitación " + 
                                  (habitacionACancelar + 1) + "? (si/no): ");
                    String confirmarCancelacion = in.next();

                    if (confirmarCancelacion.equalsIgnoreCase("si")) {
                        habitacionesOcupadas[habitacionACancelar] = false;
                        usuarios[habitacionACancelar] = null;
                        noches[habitacionACancelar] = 0;
                        System.out.println("Reserva cancelada con éxito");
                    } else {
                        System.out.println("Cancelación abortada");
                    }
                    break;

                case 4: // Mostrar reservas
                    System.out.println("\nReservas actuales:");
                    boolean hayReservasMostrar = false;
                    for (int i = 0; i < totalHabitaciones; i++) {
                        if (habitacionesOcupadas[i]) {
                            System.out.println("Habitación " + (i+1) + ": " + usuarios[i] + 
                                            " - " + noches[i] + " noches - Total: $" + 
                                            (noches[i] * precioPorNoche));
                            hayReservasMostrar = true;
                        }
                    }

                    if (!hayReservasMostrar) {
                        System.out.println("No hay reservas activas");
                    }
                    break;

                case 5: // Salir
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 5);

        in.close();
    }
}