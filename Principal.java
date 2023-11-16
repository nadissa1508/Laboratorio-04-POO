import java.io.File;
import java.util.Scanner;

public class Principal {
    private static String tipoPlan = "", cod = "";

    public static void menu2(ReservacionesKayak kayak, Scanner teclado, String username) {

        int opcion = 0;
        String opUser = "";

        while (opcion != 5) {
            System.out.println("\n***************************");
            System.out.println("\nReservaciones Kayak!");
            System.out.println("\n***************************");
            System.out.println(
                    "\nOpciones: \n1.Crear una reservación \n2.Confirmar mi reservación \n3.Configurar mi perfil \n4.Ver mi reservación \n5.Regresar");
            System.out.println("\nSeleccione su opción: ");
            opUser = teclado.nextLine();

            try {
                opcion = Integer.parseInt(opUser);
            } catch (Exception e) {
                System.out.println("\nError, ingrese un número");
            }

            if (opcion < 1 || opcion > 5) {
                System.out.println("\nError, ingrese una opción del menú");
            } else {
                if (opcion == 1) {

                    String fechaVuelo = "", tipoVuelo = "", cantidadBoletos = "", aerolinea = "";
                    int cantBoletos = 0, tipVueloo = 0;
                    boolean tipVuelo = false, flag = true;

                    System.out.println("\n\n******************");
                    System.out.println("\nCREAR UNA RESERVACION");
                    System.out.println("\n******************");

                    System.out.println("\nIngrese la fecha de su vuelo: ");
                    fechaVuelo = teclado.nextLine();

                    System.out.println("\nIngrese el tipo de vuelo 1.Directo 2.Ida y vuelta: ");
                    tipoVuelo = teclado.nextLine();

                    try {
                        tipVueloo = Integer.parseInt(tipoVuelo);
                    } catch (Exception e) {
                        System.out.println("\nError, ingrese un número");
                        flag = false;

                    }

                    if (tipVueloo != 1 && tipVueloo != 2) {
                        flag = false;
                    }

                    if (tipVueloo == 1) {
                        tipVuelo = true; // true -> vuelo directo
                    } else {
                        tipVuelo = false; // true -> ida y vuelta
                    }

                    System.out.println("\nCantidad de boletos a comprar: ");
                    cantidadBoletos = teclado.nextLine();

                    try {
                        cantBoletos = Integer.parseInt(cantidadBoletos);
                    } catch (Exception e) {
                        System.out.println("\nError, ingrese un número");
                        flag = false;
                    }

                    if (cantBoletos <= 0) {
                        flag = false;
                    }

                    System.out.println("\nAerolinea con la que desea viajar: ");
                    aerolinea = teclado.nextLine();

                    if (flag) {
                        kayak.reservacion(fechaVuelo, tipVuelo, cantBoletos, aerolinea, username);
                    } else {
                        System.out.println("\nSe ingresaron datos erroneos, intente de nuevo! ");
                    }

                } else if (opcion == 2) {
                    boolean flag = true;
                    String numeroTarjeta = "", cuotas = "", claseVuelo = "", numeroAsiento = "", cantidadMaletas = "";
                    int cuotas2 = 0, cantidadMaletas2 = 0;

                    System.out.println("\n\n******************");
                    System.out.println("\nCONFIRMAR MI RESERVACION");
                    System.out.println("\n******************");

                    System.out.println("\nNumero de tarjeta: ");
                    numeroTarjeta = teclado.nextLine();

                    if (tipoPlan.equals("premium")) {

                        cuotas2 = 1;
                        claseVuelo = "primera clase";

                        System.out.println("\nNumero de asiento: ");
                        numeroAsiento = teclado.nextLine();

                        System.out.println("\nCantidad de maletas: ");
                        cantidadMaletas = teclado.nextLine();

                        try {
                            cantidadMaletas2 = Integer.parseInt(cantidadMaletas);
                        } catch (Exception e) {
                            System.out.println("\nError, ingrese un número");
                            flag = false;
                        }

                        if (cantidadMaletas2 <= 0) {
                            flag = false;
                        }

                    } else if (tipoPlan.equals("gratuito")) {

                        System.out.println("\nCantidad de cuotas para el pago: ");
                        cuotas = teclado.nextLine();

                        try {
                            cuotas2 = Integer.parseInt(cuotas);
                        } catch (Exception e) {
                            System.out.println("\nError, ingrese un número");
                            flag = false;
                        }

                        if (cuotas2 <= 0) {
                            flag = false;
                        }

                        System.out.println("\nClase para el vuelo, Coach o Primera clase: ");
                        claseVuelo = teclado.nextLine();

                        if (!claseVuelo.equalsIgnoreCase("coach") && !claseVuelo.equalsIgnoreCase("primera clase")) {
                            flag = false;
                        }

                        numeroAsiento = "Se asignara en el aeropuerto";
                        cantidadMaletas2 = 1;
                        System.out.println("\nSi tiene algún código de descuento, ingreselo, sino ingrese \"No\": ");
                        cod = teclado.nextLine();
                    }

                    if (flag) {
                        kayak.confirmacion(numeroTarjeta, cuotas2, claseVuelo, numeroAsiento, cantidadMaletas2);
                        if (tipoPlan.equals("gratuito")) {
                            System.out.println("Codigo descuento aplicado: " + cod);
                        }
                    } else {
                        System.out.println("\nSe ingresaron datos erroneos, intente de nuevo! ");
                    }

                } else if (opcion == 3) {
                    String op1 = "";
                    int op_1 = 0;

                    do {
                        System.out.println("\n\n******************");
                        System.out.println("\nCONFIRMAR MI PERFIL");
                        System.out.println("\n******************");
                        System.out.println("\nOpciones: \n1.Cambiar mi plan \n2.Cambiar mi contraseña \n3.Regresar");
                        System.out.println("\nSeleccione su opción: ");
                        op1 = teclado.nextLine();

                        try {
                            op_1 = Integer.parseInt(op1);
                        } catch (Exception e) {
                            System.out.println("\nError, ingrese un número");
                        }

                        if (op_1 < 1 || op_1 > 3) {
                            System.out.println("\nError, ingrese una opción del menú");
                        } else {
                            if (op_1 == 1) {
                                kayak.cambiarTipoUsuario();
                            } else if (op_1 == 2) {
                                String nuevaPassword = "";
                                System.out.println("\nIngrese su nueva contraseña: ");
                                nuevaPassword = teclado.nextLine();
                                kayak.cambiarPassword(nuevaPassword);
                            }
                        }
                    } while (op_1 != 3);

                } else if (opcion == 4) {
                    System.out.println(kayak.itinerario());
                    if (tipoPlan.equals("gratuito")) {
                        System.out.println("Codigo descuento aplicado: " + cod);
                    }
                }

            }

        }

    }

    public static void menuPrincipal() {
        ReservacionesKayak kayak = new ReservacionesKayak();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        String opUser = "";

        while (opcion != 3) {

            System.out.println("\n***************************");
            System.out.println("\nBienvenido a KAYAK!");
            System.out.println("\n***************************");
            System.out.println("\nOpciones: \n1.Registrarse \n2.Iniciar sesión \n3.Salir");
            System.out.println("\nSeleccione su opción: ");
            opUser = teclado.nextLine();

            try {
                opcion = Integer.parseInt(opUser);
            } catch (Exception e) {
                System.out.println("\nError, ingrese un número");
            }

            if (opcion < 1 || opcion > 3) {
                System.out.println("\nError, ingrese una opción del menú");
            } else {

                if (opcion == 1) {
                    String username = "", password = "", tipoPlan2 = "";
                    System.out.println("\n\n******************");
                    System.out.println("\nCREA TU CUENTA");
                    System.out.println("\n******************");

                    System.out.println("\nIngrese su nombre de usuario: ");
                    username = teclado.nextLine();

                    System.out.println("\nIngrese su contraseña: ");
                    password = teclado.nextLine();

                    System.out.println("\nEscriba con letras el tipo de plan que desea, premium o gratuito: ");
                    tipoPlan2 = teclado.nextLine();

                    kayak.registroUsuario(username, password, tipoPlan2.toLowerCase());

                } else if (opcion == 2) {
                    String username = "", password = "";
                    System.out.println("\n\n******************");
                    System.out.println("\nINICIO DE SESIÓN");
                    System.out.println("\n******************");

                    System.out.println("\nIngrese su nombre de usuario: ");
                    username = teclado.nextLine();

                    System.out.println("\nIngrese su contraseña: ");
                    password = teclado.nextLine();

                    Usuario userTemp = kayak.login(username, password);
                    if (userTemp != null) {
                        tipoPlan = userTemp.getTipoPlanUser();
                        menu2(kayak, teclado, username);
                    }

                } else if (opcion == 3) {
                    try {
                        kayak.guardarUsuario();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        System.out.println("ERROR AL GUARDAR CSV USUARIOS");
                    }
                    try {
                        kayak.guardarReservacion();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        System.out.println("ERROR AL GUARDAR CSV RESERVAS");
                    }
                }

            }
        }

    }

    public static void main(String[] args) {
        menuPrincipal();
    }

}
