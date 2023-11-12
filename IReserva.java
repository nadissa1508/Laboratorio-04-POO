public interface IReserva {

    void login(String username, String password);

    void registroUsuario(String username, String password, String tipo);

    void cambiarPassword(String nuevaPassword);

    void cambiarTipoUsuario();

    void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String username);

    void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento, int cantidadMaletas);

    String itinerario();

    void guardarReservacion();

    void leerReservacion();

    void guardarUsuario();

    void leerUsuario();

}
