import java.io.File;
import java.util.Scanner;

public class Principal {
    static String tipoPlan = "";

    public static void menu2(ReservacionesKayak kayak, Scanner teclado, String username) {

        int opcion = 0;
        String opUser = "";

        while (opcion != 4) {
            System.out.println("\n***************************");
            System.out.println("\nReservaciones Kayak!");
            System.out.println("\n***************************");
            System.out.println("\nOpciones: \n1.Crear una reservación \n2.Confirmar mi reservación \n3.Configurar mi perfil \n4.Regresar");
            System.out.println("\nSeleccione su opción: ");
            opUser = teclado.nextLine();

            try {
                opcion = Integer.parseInt(opUser);
            } catch (Exception e) {
                System.out.println("\nError, ingrese un número");
            }

            if (opcion < 1 || opcion > 4) {
                System.out.println("\nError, ingrese una opción del menú");
            } else {
                if (opcion == 1) {
                    String fechaVuelo = "", tipoVuelo = "", cantidadBoletos = "", aerolinea = "";
                    int cantBoletos = 0, tipVueloo = 0;
                    boolean tipVuelo = false;

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
                        return;
                    }

                    if (tipVueloo != 1 || tipVueloo != 2) {
                        System.out.println("\nError, opción incorrecta para el tipo de vuelo");
                        return;
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
                        return;
                    }

                    if (cantBoletos <= 0) {
                        System.out.println("\nError, cantidad de boletos invalida");
                        return;
                    }

                    System.out.println("\nAerolinea con la que desea viajar: ");
                    aerolinea = teclado.nextLine();

                    kayak.reservacion(fechaVuelo, tipVuelo, cantBoletos, aerolinea, username);

                } else if (opcion == 2) {

                    String numeroTarjeta = "", cuotas = "", claseVuelo = "", numeroAsiento = "", cantidadMaletas = "", cod = "";
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
                            return;
                        }

                        if (cantidadMaletas2 <= 0) {
                            System.out.println("\nError, cantidad de maletas invalida");
                            return;
                        }

                    } else if (tipoPlan.equals("gratuito")) {

                        System.out.println("\nCantidad de cuotas para el pago: ");
                        cuotas = teclado.nextLine();

                        try {
                            cuotas2 = Integer.parseInt(cuotas);
                        } catch (Exception e) {
                            System.out.println("\nError, ingrese un número");
                            return;
                        }

                        if (cuotas2 <= 0) {
                            System.out.println("\nError, cantidad de cuotas invalida");
                            return;
                        }

                        System.out.println("\nClase para el vuelo, Coach o Primera clase: ");
                        claseVuelo = teclado.nextLine();

                        if (!claseVuelo.equalsIgnoreCase("coach") || !claseVuelo.equalsIgnoreCase("primera clase")) {
                            System.out.println("\nError, se ingreso una clase de vuelo invalida!");
                            return;
                        }

                        numeroAsiento = "Se asignará en el aeropuerto";
                        cantidadMaletas2 = 1;
                        System.out.println("\nSi tiene algún código de descuento, ingreselo, sino ingrese \"No\": ");
                        cod = teclado.nextLine();
                    }

                    kayak.confirmacion(numeroTarjeta, cuotas2, claseVuelo, numeroAsiento, cantidadMaletas2);

                } else if (opcion == 3) {
                    String op1 = "";
                    int op_1 = 0;
                    while (op_1 != 3) {
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
                            } else {
                                String nuevaPassword = "";
                                System.out.println("\nIngrese su nueva contraseña: ");
                                nuevaPassword = teclado.nextLine();
                                kayak.cambiarPassword(nuevaPassword);
                            }
                        }
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

                    if (!tipoPlan2.equalsIgnoreCase("premium") || !tipoPlan2.equalsIgnoreCase("gratuito")) {
                        System.out.println("\nError, se ingreso un plan invalido!");
                        return;
                    }

                    tipoPlan = tipoPlan2.toLowerCase();
                    kayak.registroUsuario(username, password, tipoPlan2);

                } else if (opcion == 2) {
                    String username = "", password = "";
                    System.out.println("\n\n******************");
                    System.out.println("\nINICIO DE SESIÓN");
                    System.out.println("\n******************");

                    System.out.println("\nIngrese su nombre de usuario: ");
                    username = teclado.nextLine();

                    System.out.println("\nIngrese su contraseña: ");
                    password = teclado.nextLine();

                    kayak.login(username, password);
                    menu2(kayak, teclado, username);

                } else if (opcion == 3) {
                    // codigo que podria ser de utilidad al cerrar el programa
                }

            }
        }

    }

    public static void main(String[] args) {
        menuPrincipal();
    }

}
