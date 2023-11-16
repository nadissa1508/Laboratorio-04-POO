/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @description Clase que modela y guarda la información de los clientes de la emprese Kayak
 * @date creación 11/11/2023 última modificación 15/11/23
 */

public class Usuario {

    private String username;
    private String password;
    private boolean tipoPlan;

    //constructores
    public Usuario(String username, String password, boolean tipoPlan) {
        this.username = username;
        this.password = password;
        this.tipoPlan = tipoPlan;
    }

    public Usuario() {
        this.username = "";
        this.password = "";
        this.tipoPlan = false;
    }

    //getters y setters
    
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
     * @return String
     */
    public String getPassword() {
        return password;
    }

    
    /** 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    /** 
     * @return boolean
     */
    public boolean getTipoPlan() {
        return tipoPlan;
    }

    /** 
     * @param tipoPlan
     */
    public void setTipoPlan(boolean tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    
    /** 
     * @return String
     * Funcion que devuelve un string segun el valor de la variable tipoPlan
     * Esto se usa para cumplir con los requisitos de usar los mismos tipos de datos por la interfaz IReserva
     */
    public String getTipoPlanUser() {
        String c = "";
        if (tipoPlan) { // true -> premium
            c = "premium";
        } else {// false -> GRATUITO
            c = "gratuito";
        }
        return c;
    }

    
    /** 
     * @return String
     */
    public String toString(){
        String cadena = "";
    cadena = "\nNombre de usuario: "+ username
        + "\nContraseña: "+ password
        + "\nTipo de plan: " + getTipoPlan();
        return cadena;
    }

}
