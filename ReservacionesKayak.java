import java.util.ArrayList;

public class ReservacionesKayak implements IReserva {
    private Usuario usuario;
    private Reserva reserva;
    private Archivo archivoUsuarios;
    private Archivo archivoReservas;

    public ReservacionesKayak() {
        usuario = new Usuario();
        reserva = new Reserva();
        archivoUsuarios = new Archivo("Usuarios.csv");
        archivoReservas = new Archivo("Reservas.csv");
    }

    public void login(String username, String password) {
        ArrayList<Usuario> usuariosTemp = archivoUsuarios.leerUserCSV();
        if (usuariosTemp != null) {
            for (int x = 0; x < usuariosTemp.size(); x++) {
                if ((username.equals(usuariosTemp.get(x).getUsername()))
                        && (password.equals(usuariosTemp.get(x).getPassword()))) {
                    usuario = new Usuario(usuariosTemp.get(x).getUsername(), usuariosTemp.get(x).getPassword(), usuariosTemp.get(x).getTipoPlan()); 
                    System.out.println("Sesion iniciada correctamente!");
                }else{
                    System.out.println("Credenciales incorrectas!");
                }
            }
        }else{
            System.out.println("Debe registrarse para iniciar sesión!");
        }

    }

    public void setTipoPlan(String tipo) {
        if(tipo.equals("VIP")){
            this.tipoPlan = true;
        }else if(tipo.equals("Gratuito")){
            this.tipoPlan = false;
        }
    }

    public void registroUsuario(String username, String password, String tipo) {



        Usuario userTemp = new Usuario(username, password, setTipoPlan(tipo));
    }

    public boolean validarUsername(String username) {
        boolean flag = false;
        return flag;
    }

    public void cambiarPassword(String nuevaPassword) {

    }

    public void cambiarTipoUsuario() {

    }

    public void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea,
            String username) {

    }

    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento,
            int cantidadMaletas) {

    }

    public String itinerario() {
        return reserva.toStringItinerario();
    }

    public String imprimirReserva() {
        return reserva.toStringReserva();
    }

    public void guardarReservacion() {

    }

    public void leerReservacion() {

    }

    public void guardarUsuario() {

    }

    public void leerUsuario() {

    }

}
