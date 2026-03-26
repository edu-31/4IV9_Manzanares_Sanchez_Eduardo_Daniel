//Examen de Eduardo Daniel Manzanares Sánchez del grupo 4IV9
import java.util.Scanner;

public class Examen {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nombre = "", apellidopaterno = "", apellidomaterno = "", fecha = "", direccion = "";
        int opcion = 0;

        do {
            System.out.println("Bienvenido a mi examen");
            System.out.println("\n--- Menu principal ---");
            System.out.println("1. Capturar datos del cliente");
            System.out.println("2. Mostrar tipos de piso");
            System.out.println("3. Calcular costo de instalación");
            System.out.println("4. Salir");

        while (true) {
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println("Eso no es un número");
                sc.next();
            }
        }   

            switch (opcion) {

                case 1:
                    System.out.println("\n--- Datos del Cliente ---");

                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();

                    System.out.print("Apellido paterno: ");
                    apellidopaterno = sc.nextLine();

                    System.out.print("Apellido materno: ");
                    apellidomaterno = sc.nextLine();

                    System.out.print("Fecha de nacimiento: ");
                    fecha = sc.nextLine();

                    System.out.print("Dirección: ");
                    direccion = sc.nextLine();
                    break;

                case 2:
                    System.out.println("\n--- Tipos de Pisos ---");
                    System.out.println("1. Porcelanato - $22.35 por m²");
                    System.out.println("2. Marmoleado - $34.27 por m²");
                    System.out.println("3. Acrílico - $22.94 por m²");
                    break;

                case 3:

                    if (nombre.equals("")) {
                        System.out.println("Primero ingresa los datos del cliente.");
                        break;
                    }

                    int cuartos;
                    double total = 0;

                
                    do {
                        System.out.print("Número de cuartos (2-4): ");

                        while (!sc.hasNextInt()) {
                            System.out.println("Ese numero no es valido");
                            sc.next();
                        }

                        cuartos = sc.nextInt();
                        sc.nextLine();

                        if (cuartos <= 1 || cuartos >= 5) {
                            System.out.println("elige entre 2 a 4 cuartos");
                        }

                    } while (cuartos <= 1 || cuartos >= 5);


                    for (int i = 1; i <= cuartos; i++) {

                        System.out.println("\n--- Cuarto " + i + " ---");

                        double largo, ancho;

                        System.out.print("Largo (m): ");
                        while (!sc.hasNextDouble()) {
                            System.out.println("Eso no es un numero");
                            sc.next();
                        }
                        largo = sc.nextDouble();

                        System.out.print("Ancho (m): ");
                        while (!sc.hasNextDouble()) {
                            System.out.println("Eso no es un numero");
                            sc.next();
                        }
                        ancho = sc.nextDouble();

                        double area = largo * ancho;


                        System.out.println("\nTipos de piso:");
                        System.out.println("1. Porcelanato - $22.35");
                        System.out.println("2. Marmoleado - $34.27");
                        System.out.println("3. Acrílico - $22.94");

                        int tipo;
                        String nombrePiso = "";
                        double precio = 0;

                        System.out.print("Seleccione tipo de piso: ");
                        while (!sc.hasNextInt()) {
                            System.out.println("Que eso no es un numero");
                            sc.next();
                        }
                        tipo = sc.nextInt();
                        sc.nextLine();



                        if (tipo == 1) {
                            nombrePiso = "Porcelanato";
                            precio = 22.35;
                        } else if (tipo == 2) {
                            nombrePiso = "Marmoleado";
                            precio = 34.27;
                        } else if (tipo == 3) {
                            nombrePiso = "Acrílico";
                            precio = 22.94;
                        } else {
                            System.out.println("No valido, te cobrare en Porcelanato.");
                            nombrePiso = "Porcelanato";
                            precio = 22.35;
                        }

                        double costo = area * precio;
                        double iva = costo * 0.16;
                        double subtotal = costo + iva;

                        total += subtotal;

                        System.out.println("Cuarto " + i + " - " + nombrePiso);
                        System.out.println("Área: " + area + " m²");
                        System.out.println("Costo sin IVA: $" + costo);
                        System.out.println("IVA (16%): $" + iva);
                        System.out.println("Costo con IVA: $" + subtotal);
                    }

                    System.out.println("\n--- Compra ---");
                    System.out.println("Cliente: " + nombre + " " + apellidopaterno + " " + apellidomaterno);
                    System.out.println("Dirección: " + direccion);
                    System.out.println("Total con IVA: $" + total);

                    sc.nextLine();
                    System.out.print("¿Desea realizar la compra? (s/n) cualquier otra opcion lo tomare como un no: ");
                    String resp = sc.nextLine();

                    if (resp.equalsIgnoreCase("s")) {
                        double descuento = total * 0.0795;
                        double totalFinal = total - descuento;

                        System.out.println("Descuento (7.95%): $" + descuento);
                        System.out.println("Total Final: $" + totalFinal);
                    } else {
                        System.out.println("Compra cancelada.");
                    }

                    break;

                case 4:
                    System.out.println("Saliendo del examen....");
                    break;

                default:
                    System.out.println("Opción invalida, debe ser un número del 1 al 4");
            }

        } while (opcion != 4);

        sc.close();
    }
}