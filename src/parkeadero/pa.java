package parkeadero;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

// Enum para tipos de vehículo
enum TipoVehiculo {
    CARRO("Carro"),
    MOTO("Moto"),
    BICICLETA("Bicicleta");

    private final String nombre;

    TipoVehiculo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

// Clase base abstracta para todos los vehículos
abstract class Vehiculo {
    protected TipoVehiculo tipoVehiculo;

    public Vehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    // Método abstracto para obtener un identificador único para cada vehículo
    public abstract String getIdentificador();

    @Override
    public String toString() {
        return tipoVehiculo.getNombre();
    }
}

// Clase para vehículos que usan placa y llave (Carro y Moto)
abstract class VehiculoMotorizado extends Vehiculo {
    protected String placa;
    protected String llave;

    public VehiculoMotorizado(TipoVehiculo tipoVehiculo, String placa, String llave) {
        super(tipoVehiculo);
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("La placa no puede estar vacía para vehículos motorizados.");
        }
        this.placa = placa.trim().toUpperCase();
        this.llave = (llave == null || llave.trim().isEmpty()) ? null : llave.trim();
    }

    public String getPlaca() {
        return placa;
    }

    public String getLlave() {
        return llave;
    }

    public void setPlaca(String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("La placa no puede estar vacía.");
        }
        this.placa = placa.trim().toUpperCase();
    }

    public void setLlave(String llave) {
        this.llave = (llave == null || llave.trim().isEmpty()) ? null : llave.trim();
    }

    @Override
    public String getIdentificador() {
        return this.placa;
    }

    @Override
    public String toString() {
        String infoLlave = (llave != null) ? " - Llave: " + llave : "";
        return super.toString() + " - Placa: " + placa + infoLlave;
    }
}

// Subclase Carro
class Carro extends VehiculoMotorizado {
    public Carro(String placa, String llave) {
        super(TipoVehiculo.CARRO, placa, llave);
    }
}

// Subclase Moto
class Moto extends VehiculoMotorizado {
    public Moto(String placa, String llave) {
        super(TipoVehiculo.MOTO, placa, llave);
    }
}

// Clase para bicicletas (no tienen placa ni llave)
class VehiculoSinPlaca extends Vehiculo {
    private static int contadorBicicletas = 0; // Para dar un ID único a cada bicicleta
    private String idBicicleta;

    public VehiculoSinPlaca() {
        super(TipoVehiculo.BICICLETA);
        contadorBicicletas++;
        this.idBicicleta = "BICI-" + contadorBicicletas; // Generar un ID simple
    }

    @Override
    public String getIdentificador() {
        return this.idBicicleta;
    }

    @Override
    public String toString() {
        return super.toString() + " - ID: " + idBicicleta;
    }
}

// Clase Tarifas
class Tarifas {
    // Definición de constantes para tarifas
    public static final double PRECIO_CARRO_MINUTO = 100;
    public static final double PRECIO_MOTO_MINUTO = 50;
    public static final double PRECIO_BICI_MINUTO = 10;

    // Máximos diarios para tarifas por minuto (base para mensualidad)
    public static final double MAXIMO_DIARIO_CARRO = 10000;
    public static final double MAXIMO_DIARIO_MOTO = 5000;
    public static final double MAXIMO_DIARIO_BICI = 1000;

    public static final double RECARGO_NOCTURNO = 2000;
    public static final double DESCUENTO_MENSUALIDAD = 0.25;
    public static final int HORA_INICIO_NOCTURNO = 20; // 8 PM
    public static final int HORA_FIN_NOCTURNO = 6;     // 6 AM
    public static final int DIAS_MES = 30;

    private double precioCarroMinuto;
    private double precioMotoMinuto;
    private double precioBiciMinuto;
    private double maximoDiarioCarro;
    private double maximoDiarioMoto;
    private double maximoDiarioBici;

    private double recargoNocturno;
    private double descuentoMensualidad;

    public Tarifas() {
        this.precioCarroMinuto = PRECIO_CARRO_MINUTO;
        this.precioMotoMinuto = PRECIO_MOTO_MINUTO;
        this.precioBiciMinuto = PRECIO_BICI_MINUTO;
        this.maximoDiarioCarro = MAXIMO_DIARIO_CARRO;
        this.maximoDiarioMoto = MAXIMO_DIARIO_MOTO;
        this.maximoDiarioBici = MAXIMO_DIARIO_BICI;

        this.recargoNocturno = RECARGO_NOCTURNO;
        this.descuentoMensualidad = DESCUENTO_MENSUALIDAD;
    }

    /**
     * Calcula el costo de estacionamiento basado en minutos, con un tope diario y recargo nocturno.
     * @param tipoVehiculo El tipo de vehículo.
     * @param minutos El tiempo total en minutos que el vehículo estuvo estacionado.
     * @param esNocturno Indica si aplica recargo nocturno.
     * @return El costo total calculado.
     */
    public double calcularCostoPorMinutosYDiario(TipoVehiculo tipoVehiculo, long minutos, boolean esNocturno) {
        double costoBasePorMinutos = 0;
        double maximoDiario = 0;

        switch (tipoVehiculo) {
            case CARRO:
                costoBasePorMinutos = precioCarroMinuto * minutos;
                maximoDiario = maximoDiarioCarro;
                break;
            case MOTO:
                costoBasePorMinutos = precioMotoMinuto * minutos;
                maximoDiario = maximoDiarioMoto;
                break;
            case BICICLETA:
                costoBasePorMinutos = precioBiciMinuto * minutos;
                maximoDiario = maximoDiarioBici;
                break;
        }

        double costoFinal = Math.min(costoBasePorMinutos, maximoDiario);

        if (esNocturno) {
            costoFinal += recargoNocturno;
        }

        return costoFinal;
    }

    /**
     * Calcula la tarifa mensual con el descuento aplicado.
     * @param tipoVehiculo El tipo de vehículo.
     * @return El costo total mensual.
     */
    public double calcularTarifaMensual(TipoVehiculo tipoVehiculo) {
        double tarifaDiariaBaseMensual = 0;
        switch (tipoVehiculo) {
            case CARRO:
                tarifaDiariaBaseMensual = Tarifas.MAXIMO_DIARIO_CARRO;
                break;
            case MOTO:
                tarifaDiariaBaseMensual = Tarifas.MAXIMO_DIARIO_MOTO;
                break;
            case BICICLETA:
                tarifaDiariaBaseMensual = Tarifas.MAXIMO_DIARIO_BICI;
                break;
        }
        return tarifaDiariaBaseMensual * DIAS_MES * (1 - descuentoMensualidad);
    }

    public boolean esHorarioNocturno(LocalDateTime hora) {
        int horaDelDia = hora.getHour();
        return horaDelDia >= HORA_INICIO_NOCTURNO || horaDelDia < HORA_FIN_NOCTURNO;
    }

    public double getPrecioCarroMinuto() { return precioCarroMinuto; }
    public double getPrecioMotoMinuto() { return precioMotoMinuto; }
    public double getPrecioBiciMinuto() { return precioBiciMinuto; }
    public double getMaximoDiarioCarro() { return maximoDiarioCarro; }
    public double getMaximoDiarioMoto() { return maximoDiarioMoto; }
    public double getMaximoDiarioBici() { return maximoDiarioBici; }
    public double getRecargoNocturno() { return recargoNocturno; }
}

// Clase Ticket
class Ticket {
    private Vehiculo vehiculo;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private long tiempoTotal; // En minutos
    private boolean esMensualidad;
    private double costoTotal;

    public Ticket(Vehiculo vehiculo, boolean esMensualidad) {
        this.vehiculo = vehiculo;
        this.horaEntrada = LocalDateTime.now();
        this.esMensualidad = esMensualidad;
        this.costoTotal = 0;
    }

    private void calcularTiempo() {
        if (horaSalida != null) {
            this.tiempoTotal = ChronoUnit.MINUTES.between(horaEntrada, horaSalida);
        }
    }

    public void finalizarTicket(Tarifas tarifas) {
        this.horaSalida = LocalDateTime.now();
        calcularTiempo();

        if (esMensualidad) {
            this.costoTotal = tarifas.calcularTarifaMensual(vehiculo.getTipoVehiculo());
        } else {
            boolean aplicaRecargoNocturno = tarifas.esHorarioNocturno(horaEntrada) ||
                                            (horaSalida != null && tarifas.esHorarioNocturno(horaSalida));
            this.costoTotal = tarifas.calcularCostoPorMinutosYDiario(
                                    vehiculo.getTipoVehiculo(), tiempoTotal, aplicaRecargoNocturno);
        }
    }

    public Vehiculo getVehiculo() { return vehiculo; }
    public LocalDateTime getHoraEntrada() { return horaEntrada; }
    public LocalDateTime getHoraSalida() { return horaSalida; }
    public long getTiempoTotal() { return tiempoTotal; }
    public boolean isEsMensualidad() { return esMensualidad; }
    public double getCostoTotal() { return costoTotal; }

    @Override
    public String toString() {
        return "Ticket - " + vehiculo.toString() +
               "\nIdentificador: " + vehiculo.getIdentificador() +
               "\nEntrada: " + horaEntrada +
               "\nSalida: " + (horaSalida != null ? horaSalida : "Aún en el parqueadero") +
               "\nTipo: " + (esMensualidad ? "Mensualidad" : "Diario/Minuto") +
               (horaSalida != null ? "\nTiempo Estacionado: " + tiempoTotal + " minutos" : "") +
               "\nCosto: $" + String.format("%.2f", costoTotal);
    }
}

// Clase DineroRecaudado
class DineroRecaudado {
    private double dineroCarros;
    private double dineroMotos;
    private double dineroBicis;
    private double totalRecaudado;

    public DineroRecaudado() {
        this.dineroCarros = 0;
        this.dineroMotos = 0;
        this.dineroBicis = 0;
        this.totalRecaudado = 0;
    }

    public void agregarRecaudo(TipoVehiculo tipoVehiculo, double monto) {
        switch (tipoVehiculo) {
            case CARRO:
                dineroCarros += monto;
                break;
            case MOTO:
                dineroMotos += monto;
                break;
            case BICICLETA:
                dineroBicis += monto;
                break;
        }
        calcularTotal();
    }

    public void calcularTotal() {
        this.totalRecaudado = dineroCarros + dineroMotos + dineroBicis;
    }

    public double getDineroCarros() { return dineroCarros; }
    public double getDineroMotos() { return dineroMotos; }
    public double getDineroBicis() { return dineroBicis; }
    public double getTotalRecaudado() { return totalRecaudado; }

    public String mostrarReporte() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== REPORTE FINANCIERO ===");
        sb.append("\nDinero de Carros: $" + String.format("%.2f", dineroCarros));
        sb.append("\nDinero de Motos: $" + String.format("%.2f", dineroMotos));
        sb.append("\nDinero de Bicicletas: $" + String.format("%.2f", dineroBicis));
        sb.append("\nTOTAL RECAUDADO: $" + String.format("%.2f", totalRecaudado));
        return sb.toString();
    }
}

// Clase principal Parqueadero
class Parqueadero {
    private int cuposTotales;
    private int cuposOcupados;
    private int cuposDiscapacitados; // Solo informativo para este ejemplo
    private HashMap<String, Ticket> vehiculosActivos; // Key: identificador único (placa o ID de bicicleta)
    private Tarifas tarifas;
    private DineroRecaudado dinero;

    public Parqueadero() {
        this.cuposTotales = 200;
        this.cuposOcupados = 0;
        this.cuposDiscapacitados = 20;
        this.vehiculosActivos = new HashMap<>();
        this.tarifas = new Tarifas();
        this.dinero = new DineroRecaudado();
    }

    public boolean ingresarVehiculo(Vehiculo vehiculo, boolean esMensualidad) {
        if (cuposDisponibles() <= 0) {
            System.out.println("Error: No hay cupos disponibles en el parqueadero.");
            return false;
        }

        String identificador = vehiculo.getIdentificador().toLowerCase();
        if (vehiculosActivos.containsKey(identificador)) {
            System.out.println("Error: El vehículo con identificador " + identificador + " ya está registrado.");
            return false;
        }

        Ticket nuevoTicket = new Ticket(vehiculo, esMensualidad);
        vehiculosActivos.put(identificador, nuevoTicket);
        cuposOcupados++;
        System.out.println("Vehículo ingresado exitosamente: " + vehiculo.toString() + " - Identificador: " + vehiculo.getIdentificador() + " - Tipo de tarifa: " + (esMensualidad ? "Mensualidad" : "Diaria/Minuto"));
        return true;
    }

    public Ticket sacarVehiculo(String identificador) {
        Ticket ticketEncontrado = vehiculosActivos.get(identificador.toLowerCase());

        if (ticketEncontrado != null) {
            ticketEncontrado.finalizarTicket(tarifas);
            dinero.agregarRecaudo(ticketEncontrado.getVehiculo().getTipoVehiculo(),
                                  ticketEncontrado.getCostoTotal());
            cuposOcupados--;
            vehiculosActivos.remove(identificador.toLowerCase());
            System.out.println("Vehículo retirado exitosamente:\n" + ticketEncontrado.toString());
            return ticketEncontrado;
        } else {
            System.out.println("Error: Vehículo con identificador " + identificador + " no encontrado.");
            return null;
        }
    }

    public int cuposDisponibles() {
        return cuposTotales - cuposOcupados;
    }

    public Ticket buscarVehiculo(String identificador) {
        Ticket foundTicket = vehiculosActivos.get(identificador.toLowerCase());
        if (foundTicket != null) {
            System.out.println("Vehículo encontrado:\n" + foundTicket.toString());
        } else {
            System.out.println("Vehículo con identificador " + identificador + " no encontrado.");
        }
        return foundTicket;
    }

    public String getEstadoParqueadero() {
        return "\n=== ESTADO DEL PARQUEADERO ===" +
               "\nCupos totales: " + cuposTotales +
               "\nCupos ocupados: " + cuposOcupados +
               "\nCupos disponibles: " + cuposDisponibles() +
               "\nCupos discapacitados: " + cuposDiscapacitados +
               "\nVehículos activos: " + vehiculosActivos.size();
    }

    public String getVehiculosActivos() {
        if (vehiculosActivos.isEmpty()) {
            return "\nNo hay vehículos en el parqueadero.";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("\n=== VEHÍCULOS ACTUALMENTE EN EL PARQUEADERO ===");
            for (Ticket ticket : vehiculosActivos.values()) {
                sb.append("\n").append(ticket.getVehiculo().toString());
                sb.append(" - Identificador: ").append(ticket.getVehiculo().getIdentificador());
                sb.append(" - Entrada: ").append(ticket.getHoraEntrada());
                sb.append(" - Tipo de Tarifa: ").append(ticket.isEsMensualidad() ? "Mensualidad" : "Diario/Minuto");
                sb.append("\n--------------------");
            }
            return sb.toString();
        }
    }

    public String getTarifasInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== TARIFAS ===");
        sb.append("\nTARIFAS DIARIAS (por minuto con tope diario):");
        sb.append("\nCarro: $" + String.format("%.2f", tarifas.getPrecioCarroMinuto()) + " /min (Máx: $" + String.format("%.2f", tarifas.getMaximoDiarioCarro()) + " /día)");
        sb.append("\nMoto: $" + String.format("%.2f", tarifas.getPrecioMotoMinuto()) + " /min (Máx: $" + String.format("%.2f", tarifas.getMaximoDiarioMoto()) + " /día)");
        sb.append("\nBicicleta: $" + String.format("%.2f", tarifas.getPrecioBiciMinuto()) + " /min (Máx: $" + String.format("%.2f", tarifas.getMaximoDiarioBici()) + " /día)");
        sb.append("\n\nTARIFAS MENSUALES (25% descuento):");
        sb.append("\nCarro: $" + String.format("%.2f", tarifas.calcularTarifaMensual(TipoVehiculo.CARRO)));
        sb.append("\nMoto: $" + String.format("%.2f", tarifas.calcularTarifaMensual(TipoVehiculo.MOTO)));
        sb.append("\nBicicleta: $" + String.format("%.2f", tarifas.calcularTarifaMensual(TipoVehiculo.BICICLETA)));
        sb.append("\n\nRecargo nocturno (" + Tarifas.HORA_INICIO_NOCTURNO + ":00-" + Tarifas.HORA_FIN_NOCTURNO + ":00): +$" + String.format("%.2f", tarifas.getRecargoNocturno()));
        return sb.toString();
    }

    public String getReporteFinanciero() {
        return dinero.mostrarReporte();
    }
}