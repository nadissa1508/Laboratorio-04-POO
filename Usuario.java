public class Usuario {

    private String username;
    private String password;
    private boolean tipoPlan;

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
     * @return String
     */
    public String getTipoPlanUser() {
        String c = "";
        if (tipoPlan) { // true -> VIP
            c = "VIP";
        } else {// false -> GRATUITO
            c = "Gratuito";
        }
        return c;
    }

    
    /** 
     * @param tipoPlan
     */
    public void setTipoPlan(boolean tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    

    
    /** 
     * @return String
     */
    public String toString(){
        String cadena = "";
    cadena = "\nNombre de usuario: "+ username
        + "\nContraseña: "+ password
        + "\nTipo de plan: " + getTipoPlanUser();
        return cadena;
    }

}
