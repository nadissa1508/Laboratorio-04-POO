import java.io.FileNotFoundException;
import java.io.IOException;

public interface IReserva {

    Usuario login(String username, String password);

    void registroUsuario(String username, String password, String tipo);

    void cambiarPassword(String nuevaPassword);

    void cambiarTipoUsuario();

    void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String username);

    void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento, int cantidadMaletas);

    String itinerario();

    void guardarReserva() throws Exception;

    void leerReserva() throws FileNotFoundException, IOException;

    void guardarUsuario() throws Exception;

    void leerUsuario()  throws FileNotFoundException, IOException;

}
