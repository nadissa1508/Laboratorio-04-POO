import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ReservacionesKayak implements IReserva {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Reserva> reservas;
    private Archivo archivoUsuarios;
    private Archivo archivoReservas;
    private int indexUser = 0;

    public ReservacionesKayak() {
        File file1 = new File("Usuarios.csv");
        File file2 = new File("Reservas.csv");

        archivoUsuarios = new Archivo("Usuarios.csv");
        archivoReservas = new Archivo("Reservas.csv");

        if (file1.exists()) {

            try {
                leerUsuario();
            } catch (FileNotFoundException e) {
                System.out.println("\n\nError al cargar información de usuarios!");
            } catch (IOException ioe) {
                System.out.println("\n\nError al cargar información de usuarios!");
            }

        } else {
            usuarios = new ArrayList<>();
        }

        if (file2.exists()) {
            try {
                leerReservacion();
            } catch (FileNotFoundException e) {
                System.out.println("\n\nError al cargar información de usuarios!");
            } catch (IOException ioe) {
                System.out.println("\n\nError al cargar información de usuarios!");
            }
        } else {
            reservas = new ArrayList<>();
        }

    }

    public Usuario login(String username, String password) {
        Usuario newUser = null;
        if (usuarios.size() > 0) {
            for (int x = 0; x < usuarios.size(); x++) {
                if ((username.equals(usuarios.get(x).getUsername()))
                        && (password.equals(usuarios.get(x).getPassword()))) {
                    indexUser = x;
                    System.out.println("\n\nSesion iniciada correctamente!");
                    newUser = new Usuario(username, password, usuarios.get(x).getTipoPlan());
                } else {
                    System.out.println("\n\nCredenciales incorrectas!");

                }
            }
        } else {
            System.out.println("\n\nDebe registrarse para iniciar sesión!");

        }

        return newUser;

    }

    public boolean setTipoPlan(String tipo) {
        boolean tipoPlan = false;
        if (tipo.equals("premium")) {
            tipoPlan = true;
        } else if (tipo.equals("gratuito")) {
            tipoPlan = false;
        }
        return tipoPlan;
    }

    // en este metodo si encuentra el username en el array devuelve true, de lo
    // contrario devuelve false
    public boolean validarUsername(String username) {
        boolean flag = false;
        for (int x = 0; x < usuarios.size(); x++) {
            if (username.equals(usuarios.get(x).getUsername())) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }

    public void registroUsuario(String username, String password, String tipo) {
        boolean flag = false;
        if (!tipo.equalsIgnoreCase("premium") && !tipo.equalsIgnoreCase("gratuito")) {
            System.out.println("\nError, se ingreso un plan invalido!");
            flag = false;
            return;
        } else {
            flag = true;
        }

        if ((username.equals("")) || (password.equals("")) || (tipo.equals(""))) {
            System.out.println("\nCampo vacío!");
            flag = false;
            return;
        } else {
            flag = true;
        }

        if (validarUsername(username)) {
            System.out.println("\nEse nombre de usuario ya se esta utilizando, ingrese uno diferente.");
            flag = false;
            return;
        } else {
            flag = true;
        }
        if (flag) {
            usuarios.add(new Usuario(username, password, setTipoPlan(tipo)));
            System.out.println("\nCuenta creada con éxito!");
        }

    }

    public void cambiarPassword(String nuevaPassword) {
        if (!nuevaPassword.equals("")) {
            usuarios.get(indexUser).setPassword(nuevaPassword);
            System.out.println("\n\nContraseña actualizada correctamente!");
        } else {
            System.out.println("\nError, campo vacío!");
            return;
        }

    }

    public void cambiarTipoUsuario() {
        if (usuarios.get(indexUser).getTipoPlan()) {
            System.out.println("\nNo es posible cambiar su plan porque usted es un cliente premium!");
        } else {
            usuarios.get(indexUser).setTipoPlan(true);
            System.out.println("\nSe ha mejorado su plan exitosamente!");
        }
    }

    public void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea,
            String username) {
        if ((fechaVuelo.equals("")) || (aerolinea.equals(""))) {
            System.out.println("\nCampo vacío!");
            return;
        }
        reservas.add(new Reserva(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea, username, 0, 0, false, "", 0));
        System.out.println("\n\nReserva creada con éxito!");
        System.out.println(imprimirReserva());
    }

    public int encontrarReserva(String username) {
        int index = 0;
        for (int x = 0; x < reservas.size(); x++) {
            if (username.equals(reservas.get(x).getUsername())) {
                index = x;
            }
        }
        return index;
    }

    public boolean verClaseVuelo(String claseVuelo) {
        boolean c = false;
        if (claseVuelo.equals("primera clase")) {
            c = true; // true -> primera clase
        } else {
            c = false; // false -> coach
        }
        return c;
    }

    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento,
            int cantidadMaletas) {
        if ((numeroTarjeta.equals("")) || (numeroAsiento.equals(""))) {
            System.out.println("\nCampo vacío!");
            return;
        }
        reservas.get(encontrarReserva(usuarios.get(indexUser).getUsername())).setNumeroTarjeta(Long.parseLong(numeroTarjeta));
        reservas.get(encontrarReserva(usuarios.get(indexUser).getUsername())).setCuotas(cuotas);
        reservas.get(encontrarReserva(usuarios.get(indexUser).getUsername())).setClaseVuelo(verClaseVuelo(claseVuelo));
        reservas.get(encontrarReserva(usuarios.get(indexUser).getUsername())).setNumeroAsiento(numeroAsiento);
        reservas.get(encontrarReserva(usuarios.get(indexUser).getUsername())).setCantidadMaletas(cantidadMaletas);
        System.out.println("\n\nReserva confirmada exitosamente!");
        System.out.println(itinerario());
    }

    public String itinerario() {
        return reservas.get(indexUser).toStringItinerario();
    }

    public String imprimirReserva() {
        return reservas.get(indexUser).toStringReserva();
    }

    public void guardarReservacion() throws Exception {
        if (reservas.size() > 0)
            archivoReservas.crearReservaCSV(reservas);

    }

    public void leerReservacion() throws FileNotFoundException, IOException {
        reservas = archivoReservas.leerReservaCSV();
    }

    public void guardarUsuario() throws Exception {
        if (usuarios.size() > 0)
            archivoUsuarios.crearUserCSV(usuarios);
    }

    public void leerUsuario() throws FileNotFoundException, IOException {
        usuarios = archivoUsuarios.leerUserCSV();

    }

}
