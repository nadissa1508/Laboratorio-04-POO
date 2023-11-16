
/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @description Clase para guardar información crucial para el funcionamiento del sistema en
 * archivos CSV, tambien crea ArrayList de tipo Usuario y Reserva por medio de la lectura de
 * estos mismos archivos, con el objetivo de lograr persistencia de datos
 * @date creación 11/11/2023 última modificación 15/11/23
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Archivo {

    private File archivo;

    public Archivo(String nombre) {
        archivo = new File(nombre);
    }

    /**
     * @param usuario
     * @throws Exception
     *                   Método para escribir el CSV de usuarios
     */
    public void crearUserCSV(ArrayList<Usuario> usuario) throws Exception {
        PrintWriter escritor = new PrintWriter(archivo, "UTF-8");
        String linea = "username,password,tipoPlan";
        escritor.println(linea);
        for (int i = 0; i < usuario.size(); i++) {
            linea = usuario.get(i).getUsername() + "," + usuario.get(i).getPassword() + ","
                    + usuario.get(i).getTipoPlan();
            escritor.println(linea);
        }

        escritor.close();
    }

    /**
     * @return ArrayList<Usuario>
     * @throws FileNotFoundException
     * @throws IOException
     *                               Función para leer la información del CSV de
     *                               usuarios, llena y devuelve un ArrayList de tipo
     *                               Usuario
     */
    public ArrayList<Usuario> leerUserCSV() throws FileNotFoundException, IOException {
        String linea = "";
        ArrayList<Usuario> tempUsuarios = new ArrayList<>();

        BufferedReader lector = new BufferedReader(new FileReader("Usuarios.csv"));
        // lee y descarta la linea de los titulos
        lector.readLine();
        // si la linea tiene datos se traen y guardan en el array temporal
        while ((linea = lector.readLine()) != null) {
            String elementos[] = linea.split(",");
            Usuario auxUser = new Usuario();

            if (elementos.length >= 3) {
                auxUser.setUsername(elementos[0].trim());
                auxUser.setPassword(elementos[1].trim());
                auxUser.setTipoPlan(Boolean.parseBoolean(elementos[2].trim()));
                tempUsuarios.add(auxUser);
            }

        }
        lector.close();
        return tempUsuarios;
    }

    /**
     * @param reservas
     * @throws Exception
     * Método para escribir el CSV de reservas
     */
    public void crearReservaCSV(ArrayList<Reserva> reservas) throws Exception {
        PrintWriter escritor = new PrintWriter(archivo, "UTF-8");
        String linea = "fechaVuelo,tipoVuelo,cantidadBoletos,aerolinea,username,numeroTarjeta,cuotas,claseVuelo,numeroAsiento,cantidadMaletas";
        escritor.println(linea);
        for (int i = 0; i < reservas.size(); i++) {
            linea = reservas.get(i).getFechaVuelo() + "," + reservas.get(i).isTipoVuelo()
                    + "," + reservas.get(i).getCantidadBoletos() + "," + reservas.get(i).getAerolinea()
                    + "," + reservas.get(i).getUsername() + "," + reservas.get(i).getNumeroTarjeta()
                    + "," + reservas.get(i).getCuotas() + "," + reservas.get(i).isClaseVuelo()
                    + "," + reservas.get(i).getNumeroAsiento() + "," + reservas.get(i).getCantidadMaletas();
            escritor.println(linea);
        }
        escritor.close();
    }

    /**
     * @return ArrayList<Reserva>
     * @throws FileNotFoundException
     * @throws IOException
     * Función para leer la información del CSV de
     * reservas, llena y devuelve un ArrayList de tipo
     * Reserva
     */
    public ArrayList<Reserva> leerReservaCSV() throws FileNotFoundException, IOException {
        String linea = "";
        ArrayList<Reserva> tempReservas = new ArrayList<>();

        BufferedReader lector = new BufferedReader(new FileReader("Reservas.csv"));
        // lee y descarta la linea de los titulos
        lector.readLine();

        while ((linea = lector.readLine()) != null) {
            String elementos[] = linea.split(",");
            if (elementos.length >= 10) {
                Reserva auxReserva = new Reserva();
                auxReserva.setFechaVuelo(elementos[0].trim());
                auxReserva.setTipoVuelo(Boolean.parseBoolean(elementos[1].trim()));
                auxReserva.setCantidadBoletos(Integer.parseInt(elementos[2].trim()));
                auxReserva.setAerolinea(elementos[3].trim());
                auxReserva.setUsername(elementos[4].trim());
                auxReserva.setNumeroTarjeta(Long.parseLong(elementos[5].trim()));
                auxReserva.setCuotas(Integer.parseInt(elementos[6].trim()));
                auxReserva.setClaseVuelo(Boolean.parseBoolean(elementos[7].trim()));
                auxReserva.setNumeroAsiento(elementos[8].trim());
                auxReserva.setCantidadMaletas(Integer.parseInt(elementos[9].trim()));
                tempReservas.add(auxReserva);
            }
        }
        lector.close();
        return tempReservas;
    }

}
