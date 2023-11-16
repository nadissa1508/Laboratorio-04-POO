/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @description Clase que modela y guarda la información de una reservacion de vuelos
 * @date creación 11/11/2023 última modificación 15/11/23
 */

 public class Reserva {

    private String fechaVuelo;
    private boolean tipoVuelo;
    private int cantidadBoletos;
    private String aerolinea;
    private String username;
    private long numeroTarjeta;
    private int cuotas;
    private boolean claseVuelo;
    private String numeroAsiento;
    private int cantidadMaletas;
 
    //constructores

    public Reserva(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String username,
            long numeroTarjeta, int cuotas, boolean claseVuelo, String numeroAsiento, int cantidadMaletas) {
        this.fechaVuelo = fechaVuelo;
        this.tipoVuelo = tipoVuelo;
        this.cantidadBoletos = cantidadBoletos;
        this.aerolinea = aerolinea;
        this.username = username;
        this.numeroTarjeta = numeroTarjeta;
        this.cuotas = cuotas;
        this.claseVuelo = claseVuelo;
        this.numeroAsiento = numeroAsiento;
        this.cantidadMaletas = cantidadMaletas;
    }

    public Reserva() {
        this.fechaVuelo = "";
        this.tipoVuelo = false;
        this.cantidadBoletos = 0;
        this.aerolinea = "";
        this.username = "";
        this.numeroTarjeta = 0L;
        this.cuotas = 0;
        this.claseVuelo = false;
        this.numeroAsiento = "";
        this.cantidadMaletas = 0;
    }

    //getters y setters
    
    /** 
     * @return String
     */
    public String getFechaVuelo() {
        return fechaVuelo;
    }

    
    /** 
     * @param fechaVuelo
     */
    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    
    /** 
     * @return boolean
     */
    public boolean isTipoVuelo() {
        return tipoVuelo;
    }

    
    /** 
     * @param tipoVuelo
     */
    public void setTipoVuelo(boolean tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    
    /** 
     * @return int
     */
    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    
    /** 
     * @param cantidadBoletos
     */
    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    
    /** 
     * @return String
     */
    public String getAerolinea() {
        return aerolinea;
    }

    
    /** 
     * @param aerolinea
     */
    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    
    /** 
     * @return String
     */
    public String getUsername() {
        return username;
    }

    
    /** 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    
    /** 
     * @return long
     */
    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    
    /** 
     * @param numeroTarjeta
     */
    public void setNumeroTarjeta(long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    
    /** 
     * @return int
     */
    public int getCuotas() {
        return cuotas;
    }

    
    /** 
     * @param cuotas
     */
    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    
    /** 
     * @return boolean
     */
    public boolean isClaseVuelo() {
        return claseVuelo;
    }

    
    /** 
     * @param claseVuelo
     */
    public void setClaseVuelo(boolean claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    
    /** 
     * @return String
     */
    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    
    /** 
     * @param numeroAsiento
     */
    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    
    /** 
     * @return int
     */
    public int getCantidadMaletas() {
        return cantidadMaletas;
    }

    
    /** 
     * @param cantidadMaletas
     */
    public void setCantidadMaletas(int cantidadMaletas) {
        this.cantidadMaletas = cantidadMaletas;
    }

    
    /*
     * Los métodos verTipoVuelo y verClaseVuelo devuelven valores String según lo que se guarde
     * en cada variable, para cumplir con los requisitos requeridos por la interfaz
     */

    /** 
     * @return String
     */
    public String verTipoVuelo() {
        String c = "";
        if (tipoVuelo) { // directo (solo ida)
            c = "directo";
        } else {// ida y vuelta
            c = "ida y vuelta";
        }
        return c;
    }

    
    /** 
     * @return String
     */
    public String verClaseVuelo() {
        String c = "";
        if (claseVuelo) { // primera clase
            c = "Primera clase";
        } else { // coach
            c = "Coach";
        }
        return c;
    }

    
    /** 
     * @return String
     * Funcion para imprimir informacion basica de la reservacion
     */
    public String toStringReserva() {
        String cadena = "";
        cadena = "\nFecha de vuelo: " + fechaVuelo
                + "\nTipo de vuelo: " + verTipoVuelo()
                + "\nCantidad de boletos: " + cantidadBoletos
                + "\nAerolinea: " + aerolinea
                + "\nNombre del cliente: " + username;
        return cadena;
    }

    
    /** 
     * @return String
     * Funcion para imprimir informacion de pago (confirmacion) de la reservacion
     */
    public String toStringItinerario() {
        String cadena = "";
        cadena = "\nNumero de Tarjeta: " + numeroTarjeta
                + "\nCantidad de cuotas: " + cuotas
                + "\nClase del vuelo: " + verClaseVuelo()
                + "\nNumero de asiento: " + numeroAsiento
                + "\nCantidad de maletas: " + cantidadMaletas;
        return cadena;
    }

}
