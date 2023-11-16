/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @description interfaz que determina los métodos que debe implementar la clase controladora 
 * Reservaciones kayak
 * @date creación 11/11/2023 última modificación 15/11/23
 */

 import java.io.FileNotFoundException;
import java.io.IOException;

public interface IReserva {

    //funcion para iniciar sesion
    Usuario login(String username, String password);

    //registrar usuarios
    void registroUsuario(String username, String password, String tipo);

    //actualizar contraseña del usuario que inició sesion
    void cambiarPassword(String nuevaPassword);

    //mejorar plan del cliente
    void cambiarTipoUsuario();

    //crear reserva
    void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String username);

    //confirmar reserva
    void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento, int cantidadMaletas);

    //imprimir itinerario de la reserva (info de pago)
    String itinerario();

    //guardar información de las reservas en un CSV
    void guardarReserva() throws Exception;

    //leer informacion del CSV Reserva
    void leerReserva() throws FileNotFoundException, IOException;

     //guardar información de los usuarios en un CSV
    void guardarUsuario() throws Exception;

     //leer informacion del CSV Usuario
    void leerUsuario()  throws FileNotFoundException, IOException;

}
