public class Archivo {
    private File archivo;

    public Archivo(String nombre){
        archivo = new File(nombre);
    }

   
    public void actualizarUserCSV(Usuario usuario) throws Exception{
        PrintWriter escritor = new PrintWriter(archivo, "UTF-8");
        String linea = "username,password,tipoPlan";
        escritor.println(linea);
        linea = usuario.getUsername() + "," + usuario.getPassword() + "," usuario.getTipoPlan();
        escritor.println(linea);
        escritor.close();
    }

    
    
    public Usuario leerUserCSV() throws FileNotFoundException, IOException{
        String linea = ""; 
        Usuario usuario = new Usuario();
        
        BufferedReader lector = new BufferedReader(new FileReader("productosCSV.csv"));
        //lee y descarta la linea de los titulos
        lector.readLine();

        while((linea = lector.readLine()) != null ){
            String elementos[] = linea.split(",");

            if(elementos.length >=13){
                int categoria = Integer.parseInt(elementos[12].trim()); 
                Bebida auxBeb = new Bebida() ;
                Snack auxSnac = new Snack();
                Helado auxHel = new Helado();

                if(categoria == 1){//Bebida
                    
                    auxBeb.setId(Integer.parseInt(elementos[0].trim()));
                    auxBeb.setNombre(elementos[1].trim());
                    auxBeb.setCantDisponible(Integer.parseInt(elementos[2].trim()));
                    auxBeb.setCantVendidos(Integer.parseInt(elementos[3].trim()));
                    auxBeb.setEstado(Boolean.parseBoolean(elementos[4].trim()));
                    auxBeb.setPrecio(Double.parseDouble(elementos[5].trim()));
                    auxBeb.setMl(Float.parseFloat(elementos[6].trim()));
                    auxBeb.setTipo(elementos[7].trim());

                    productosTemp.add(auxBeb);
                }else if(categoria == 2){//Snack

                    auxSnac.setId(Integer.parseInt(elementos[0].trim()));
                    auxSnac.setNombre(elementos[1].trim());
                    auxSnac.setCantDisponible(Integer.parseInt(elementos[2].trim()));
                    auxSnac.setCantVendidos(Integer.parseInt(elementos[3].trim()));
                    auxSnac.setEstado(Boolean.parseBoolean(elementos[4].trim()));
                    auxSnac.setPrecio(Double.parseDouble(elementos[5].trim()));
                    auxSnac.setGramos(Float.parseFloat(elementos[8].trim()));
                    auxSnac.setSabor(elementos[9].trim());
                    auxSnac.setSize(elementos[10].trim());

                    productosTemp.add(auxSnac);
                }else {//Helado

                    auxHel.setId(Integer.parseInt(elementos[0].trim()));
                    auxHel.setNombre(elementos[1].trim());
                    auxHel.setCantDisponible(Integer.parseInt(elementos[2].trim()));
                    auxHel.setCantVendidos(Integer.parseInt(elementos[3].trim()));
                    auxHel.setEstado(Boolean.parseBoolean(elementos[4].trim()));
                    auxHel.setPrecio(Double.parseDouble(elementos[5].trim()));
                    auxHel.setGramos(Float.parseFloat(elementos[8].trim()));
                    auxHel.setMarca(elementos[11].trim());
                    auxHel.setSabor(elementos[9].trim());

                    productosTemp.add(auxHel);
                }
                
            }

        }
        lector.close();
        return usuario;
    }

     public ArrayList<Usuario> leerUserCSV() throws FileNotFoundException, IOException{
        String linea = ""; 
        ArrayList<Producto> productosTemp = new ArrayList<>();
        
        BufferedReader lector = new BufferedReader(new FileReader("productosCSV.csv"));
        //lee y descarta la linea de los titulos
        lector.readLine();

        while((linea = lector.readLine()) != null ){
            String elementos[] = linea.split(",");

            if(elementos.length >=13){
                int categoria = Integer.parseInt(elementos[12].trim()); 
                Bebida auxBeb = new Bebida() ;
                Snack auxSnac = new Snack();
                Helado auxHel = new Helado();

                if(categoria == 1){//Bebida
                    
                    auxBeb.setId(Integer.parseInt(elementos[0].trim()));
                    auxBeb.setNombre(elementos[1].trim());
                    auxBeb.setCantDisponible(Integer.parseInt(elementos[2].trim()));
                    auxBeb.setCantVendidos(Integer.parseInt(elementos[3].trim()));
                    auxBeb.setEstado(Boolean.parseBoolean(elementos[4].trim()));
                    auxBeb.setPrecio(Double.parseDouble(elementos[5].trim()));
                    auxBeb.setMl(Float.parseFloat(elementos[6].trim()));
                    auxBeb.setTipo(elementos[7].trim());

                    productosTemp.add(auxBeb);
                }else if(categoria == 2){//Snack

                    auxSnac.setId(Integer.parseInt(elementos[0].trim()));
                    auxSnac.setNombre(elementos[1].trim());
                    auxSnac.setCantDisponible(Integer.parseInt(elementos[2].trim()));
                    auxSnac.setCantVendidos(Integer.parseInt(elementos[3].trim()));
                    auxSnac.setEstado(Boolean.parseBoolean(elementos[4].trim()));
                    auxSnac.setPrecio(Double.parseDouble(elementos[5].trim()));
                    auxSnac.setGramos(Float.parseFloat(elementos[8].trim()));
                    auxSnac.setSabor(elementos[9].trim());
                    auxSnac.setSize(elementos[10].trim());

                    productosTemp.add(auxSnac);
                }else {//Helado

                    auxHel.setId(Integer.parseInt(elementos[0].trim()));
                    auxHel.setNombre(elementos[1].trim());
                    auxHel.setCantDisponible(Integer.parseInt(elementos[2].trim()));
                    auxHel.setCantVendidos(Integer.parseInt(elementos[3].trim()));
                    auxHel.setEstado(Boolean.parseBoolean(elementos[4].trim()));
                    auxHel.setPrecio(Double.parseDouble(elementos[5].trim()));
                    auxHel.setGramos(Float.parseFloat(elementos[8].trim()));
                    auxHel.setMarca(elementos[11].trim());
                    auxHel.setSabor(elementos[9].trim());

                    productosTemp.add(auxHel);
                }
                
            }

        }
        lector.close();
        return productosTemp;
    }

     public void crearReservaCSV(Reserva reserva) throws Exception{
        PrintWriter escritor = new PrintWriter(archivo, "UTF-8");
        String linea = "id_producto,nombre,cantidad_disponible,cantidad_vendidos,estado,precio,ml,tipo,gramos,sabor,tamaño,marca,categoria";
        escritor.println(linea);
        for(Producto prod : productos){
            linea = prod.getId() + "," + prod.getNombre() + "," + prod.getCantDisponible() + "," + prod.getCantVendidos() + "," + prod.isEstado() + "," + prod.getPrecio() + ",";
            if(prod instanceof Bebida){
                linea += ((Bebida)prod).getMl() + "," + ((Bebida)prod).getTipo() + "," + "0.0" + "," + "" + "," + ""  +"," + "" + "," + 1;
            }else if(prod instanceof Snack){
                linea += "0.0" + "," + "" + "," + ((Snack)prod).getGramos() + "," + ((Snack)prod).getSabor() + "," + ((Snack)prod).getSize()  + "," + "" + "," + 2;
            }else if(prod instanceof Helado){
                linea += "0.0" + "," + "" + "," + ((Helado)prod).getGramos() + "," + ((Helado)prod).getSabor() + "," + "" + "," + ((Helado)prod).getMarca() + "," + 3;
            }
            escritor.println(linea);
        }
        escritor.close();
    }

    public Reserva leerReservaCSV() throws FileNotFoundException, IOException{
        String linea = ""; 
        ArrayList<Producto> productosTemp = new ArrayList<>();
        
        BufferedReader lector = new BufferedReader(new FileReader("productosCSV.csv"));
        //lee y descarta la linea de los titulos
        lector.readLine();

        while((linea = lector.readLine()) != null ){
            String elementos[] = linea.split(",");

            if(elementos.length >=13){
                int categoria = Integer.parseInt(elementos[12].trim()); 
                Bebida auxBeb = new Bebida() ;
                Snack auxSnac = new Snack();
                Helado auxHel = new Helado();

                if(categoria == 1){//Bebida
                    
                    auxBeb.setId(Integer.parseInt(elementos[0].trim()));
                    auxBeb.setNombre(elementos[1].trim());
                    auxBeb.setCantDisponible(Integer.parseInt(elementos[2].trim()));
                    auxBeb.setCantVendidos(Integer.parseInt(elementos[3].trim()));
                    auxBeb.setEstado(Boolean.parseBoolean(elementos[4].trim()));
                    auxBeb.setPrecio(Double.parseDouble(elementos[5].trim()));
                    auxBeb.setMl(Float.parseFloat(elementos[6].trim()));
                    auxBeb.setTipo(elementos[7].trim());

                    productosTemp.add(auxBeb);
                }else if(categoria == 2){//Snack

                    auxSnac.setId(Integer.parseInt(elementos[0].trim()));
                    auxSnac.setNombre(elementos[1].trim());
                    auxSnac.setCantDisponible(Integer.parseInt(elementos[2].trim()));
                    auxSnac.setCantVendidos(Integer.parseInt(elementos[3].trim()));
                    auxSnac.setEstado(Boolean.parseBoolean(elementos[4].trim()));
                    auxSnac.setPrecio(Double.parseDouble(elementos[5].trim()));
                    auxSnac.setGramos(Float.parseFloat(elementos[8].trim()));
                    auxSnac.setSabor(elementos[9].trim());
                    auxSnac.setSize(elementos[10].trim());

                    productosTemp.add(auxSnac);
                }else {//Helado

                    auxHel.setId(Integer.parseInt(elementos[0].trim()));
                    auxHel.setNombre(elementos[1].trim());
                    auxHel.setCantDisponible(Integer.parseInt(elementos[2].trim()));
                    auxHel.setCantVendidos(Integer.parseInt(elementos[3].trim()));
                    auxHel.setEstado(Boolean.parseBoolean(elementos[4].trim()));
                    auxHel.setPrecio(Double.parseDouble(elementos[5].trim()));
                    auxHel.setGramos(Float.parseFloat(elementos[8].trim()));
                    auxHel.setMarca(elementos[11].trim());
                    auxHel.setSabor(elementos[9].trim());

                    productosTemp.add(auxHel);
                }
                
            }

        }
        lector.close();
        return productosTemp;
    }
    
}
  

            