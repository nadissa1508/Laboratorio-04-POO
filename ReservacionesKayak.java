/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @description clase controladora donde se maneja la logica principal del sistema
 * @date creación 11/11/2023 última modificación 15/11/23
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ReservacionesKayak implements IReserva {

    //Atributos
    private ArrayList<Usuario> usuarios;
    private ArrayList<Reserva> reservas;
    private Archivo archivoUsuarios;//sirve para crear CSV Usuarios
    private Archivo archivoReservas;//sirve para crear CSV Reservas
    private int indexUser;
    private boolean flagReserva;

    public ReservacionesKayak() {
        //valor inicial al index del usuario que inicio sesion, como no ha iniciado nadie guardo
        //un valor que no puede tener ningun index
        indexUser = -1;
        File file1 = new File("Usuarios.csv");
        File file2 = new File("Reservas.csv");

        archivoUsuarios = new Archivo("Usuarios.csv");
        archivoReservas = new Archivo("Reservas.csv");

        //verifico si existe el CSV para saber si llenar el array o no con datos de dicho archivo
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
                leerReserva();
            } catch (FileNotFoundException e) {
                System.out.println("\n\nError al cargar información de usuarios!");
            } catch (IOException ioe) {
                System.out.println("\n\nError al cargar información de usuarios!");
            }
        } else {
            reservas = new ArrayList<>();
        }

    }

    
    /** 
     * @param username
     * @param password
     * @return Usuario
     * Funcion que permite iniciar sesion, devuelve un objeto de tipo usuario para verificar
     * si este proceso se realizo correctamente y asi permitir que el usuario vea el menu2 del sistema
     */
    public Usuario login(String username, String password) {
        Usuario newUser = null;
        if (usuarios.size() > 0) {
            for (int x = 0; x < usuarios.size(); x++) {
                if ((username.equals(usuarios.get(x).getUsername()))
                        && (password.equals(usuarios.get(x).getPassword()))) {
                    indexUser = x;
                    newUser = new Usuario(username, password, usuarios.get(x).getTipoPlan());
                    break;
                } else {

                }
            }
        } else {
            System.out.println("\n\nDebe registrarse para iniciar sesión!");

        }

        if (indexUser == -1) {
            System.out.println("\n\nCredenciales incorrectas!");
        } else {
            System.out.println("\n\nSesion iniciada correctamente!");
        }

        return newUser;

    }

    
    /** 
     * @param tipo
     * @return boolean
     * Funcion que ayuda a que la variable tipoPlan se guarde correctamente
     * en las instancias de Usuario
     */
    public boolean setTipoPlan(String tipo) {
        boolean tipoPlan = false;
        if (tipo.equals("premium")) {
            tipoPlan = true;
        } else if (tipo.equals("gratuito")) {
            tipoPlan = false;
        }
        return tipoPlan;
    }

    
    /** 
     * @param username
     * @return boolean
     * en este metodo si encuentra el username en el array devuelve true, de lo
     * contrario devuelve false. Sirve para validar que dos usuarios no tengan el mismo
     * nombre registrado y evitar errores al almacenar datos
     */
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

    
    /** 
     * @param username
     * @param password
     * @param tipo
     * Método que permite que un usuario se registre
     */
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

    
    /** 
     * @param nuevaPassword
     * Método para actualizar contraseña del usuario que inició sesion
     */
    public void cambiarPassword(String nuevaPassword) {
        if (!nuevaPassword.equals("")) {
            usuarios.get(indexUser).setPassword(nuevaPassword);
            System.out.println("\n\nContraseña actualizada correctamente!");
        } else {
            System.out.println("\nError, campo vacío!");
            return;
        }

    }

    /*
     * Método para mejorar el plan del cliente
     */

    public void cambiarTipoUsuario() {
        if (usuarios.get(indexUser).getTipoPlan()) {
            System.out.println("\nNo es posible cambiar su plan porque usted es un cliente premium!");
        } else {
            usuarios.get(indexUser).setTipoPlan(true);
            System.out.println("\nSe ha mejorado su plan exitosamente!");
        }
    }

    
    /** 
     * @param fechaVuelo
     * @param tipoVuelo
     * @param cantidadBoletos
     * @param aerolinea
     * @param username
     * Método para crear una reservacion de vuelos
     */
    public void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea,
            String username) {
        if ((fechaVuelo.equals("")) || (aerolinea.equals(""))) {
            System.out.println("\nCampo vacío!");
            return;
        }
        reservas.add(new Reserva(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea, username, 0, 0, false, "", 0));
        System.out.println("\n\nReserva creada con éxito!");
        System.out.println(imprimirReserva());
        flagReserva = true;
    }

    
    /** 
     * @param username
     * @return int
     * Funcion que devuelve el index de una reserva dentro del array reservas segun el nombre de
     * usuario que tenga
     */
    public int encontrarReserva(String username) {
        int index = 0;
        for (int x = 0; x < reservas.size(); x++) {
            if (username.equals(reservas.get(x).getUsername())) {
                index = x;
            }
        }
        return index;
    }

    
    /** 
     * @param claseVuelo
     * @return boolean
     * Funcion para mostrar correctamente el valor de la variable claseVuelo
     */
    public boolean verClaseVuelo(String claseVuelo) {
        boolean c = false;
        if (claseVuelo.equals("primera clase")) {
            c = true; // true -> primera clase
        } else {
            c = false; // false -> coach
        }
        return c;
    }

    
    /** 
     * @param numeroTarjeta
     * @param cuotas
     * @param claseVuelo
     * @param numeroAsiento
     * @param cantidadMaletas
     * Método para confirmar una reservacion creada por un cliente
     */
    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento,
            int cantidadMaletas) {
        if ((numeroTarjeta.equals("")) || (numeroAsiento.equals(""))) {
            System.out.println("\nCampo vacío!");
            return;
        }

        if (!flagReserva) {
            System.out.println("\n\nError, debe crear su reservacion para poder realizar la confirmación!");
        } else {
            reservas.get(encontrarReserva(usuarios.get(indexUser).getUsername()))
                    .setNumeroTarjeta(Long.parseLong(numeroTarjeta));
            reservas.get(encontrarReserva(usuarios.get(indexUser).getUsername())).setCuotas(cuotas);
            reservas.get(encontrarReserva(usuarios.get(indexUser).getUsername()))
                    .setClaseVuelo(verClaseVuelo(claseVuelo));
            reservas.get(encontrarReserva(usuarios.get(indexUser).getUsername())).setNumeroAsiento(numeroAsiento);
            reservas.get(encontrarReserva(usuarios.get(indexUser).getUsername())).setCantidadMaletas(cantidadMaletas);
            System.out.println("\n\nReserva confirmada exitosamente!");
            System.out.println(itinerario());
        }

    }

    
    /** 
     * @return String
     * Funcion que muestra toda la informacion general de la reservacion de un cliente
     */
    public String itinerario() {
        String cadena = "";

        cadena = reservas.get(encontrarReserva(usuarios.get(indexUser).getUsername())).toStringReserva();
        cadena += "\n" + reservas.get(encontrarReserva(usuarios.get(indexUser).getUsername())).toStringItinerario();
        return cadena;
    }

    
    /** 
     * @return String
     * Funcion que devuelve la informacion basica de una reserva
     */
    public String imprimirReserva() {
        return reservas.get(encontrarReserva(usuarios.get(indexUser).getUsername())).toStringReserva();
    }

    
    /** 
     * @throws Exception
     * método para guardar el CSV de reservas
     */
    public void guardarReserva() throws Exception {
        if (reservas.size() > 0)
            archivoReservas.crearReservaCSV(reservas);

    }

    
    /** 
     * @throws FileNotFoundException
     * @throws IOException
     * método para obtener la informacion del csv Reserva y guardarla en el array reservas
     */
    public void leerReserva() throws FileNotFoundException, IOException {
        reservas = archivoReservas.leerReservaCSV();
    }

    
    /** 
     * @throws Exception
     * método para guardar el CSV de usuarios
     */
    public void guardarUsuario() throws Exception {
        if (usuarios.size() > 0)
            archivoUsuarios.crearUserCSV(usuarios);
    }

    
    /** 
     * @throws FileNotFoundException
     * @throws IOException
     * método para obtener la informacion del csv Usuario y guardarla en el array usuarios
     */
    public void leerUsuario() throws FileNotFoundException, IOException {
        usuarios = archivoUsuarios.leerUserCSV();

    }

}
