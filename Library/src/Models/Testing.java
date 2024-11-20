package Models;

import Exceptions.AddressNotFoundException;
import Exceptions.MemberNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Testing {

    public void test () throws MemberNotFoundException, AddressNotFoundException {

        ArrayList<Partner>listSocios = new ArrayList<>();

        // Crear la biblioteca
        Library library = new Library();

        // Crear socios (Partners)
        Partner socio1 = new Partner("12345678A");
        Partner socio2 = new Partner("23456789B");
        Partner socio3 = new Partner("34567890C");

        listSocios.add(socio1);
        listSocios.add(socio2);
        listSocios.add(socio3);

        // Agregar direcciones a los socios con datos valencianos
        socio1.agregarDireccion(new Address(1, "Carrer de Colón", 12, "València", 46004));
        socio1.agregarDireccion(new Address(2, "Avinguda del Marítim", 25, "València", 46011));
        socio1.agregarDireccion(new Address(3, "Carrer de Xàtiva", 56, "València", 46007));

        socio2.agregarDireccion(new Address(4, "Carrer de la Pau", 101, "Alacant", 15937));
        socio2.agregarDireccion(new Address(5, "Avinguda de l'Oceanografic", 22, "Alacant", 39016));
        socio2.agregarDireccion(new Address(6, "Carrer del Canyeret", 45, "Alacant", 39009));

        socio3.agregarDireccion(new Address(7, "Carrer de Ramón y Cajal", 55, "Castelló de la Plana", 12001));
        socio3.agregarDireccion(new Address(8, "Avinguda del Lidón", 10, "Castelló de la Plana", 12002));
        socio3.agregarDireccion(new Address(9, "Carrer de la Mare de Déu", 28, "Castelló de la Plana", 12003));

        // Agregar socios a la biblioteca
        library.agregarSocio(socio1);
        library.agregarSocio(socio2);
        library.agregarSocio(socio3);

        // Crear préstamos
        Prestamo prestamo1 = new Prestamo("978-3-16-148410-0", new Date(), "12345678A", "2024-12-01");
        Prestamo prestamo2 = new Prestamo("978-1-4028-9462-6", new Date(), "23456789B", "2024-12-02");
        Prestamo prestamo3 = new Prestamo("978-0-306-40615-7", new Date(), "34567890C", "2024-12-03");

        // Agregar préstamos a la biblioteca
        library.agregarPrestamo(prestamo1);
        library.agregarPrestamo(prestamo2);
        library.agregarPrestamo(prestamo3);

        // Mostrar las direcciones de un socio por NIF
        try {
            String direccionesSocio1 = library.direccionesSocio("12345678A");
            System.out.println("Direcciones de socio 12345678A:");
            System.out.println(direccionesSocio1);

            String direccionesSocio2 = library.direccionesSocio("23456789B");
            System.out.println("Direcciones de socio 23456789B:");
            System.out.println(direccionesSocio2);

            String direccionesSocio3 = library.direccionesSocio("34567890C");
            System.out.println("Direcciones de socio 34567890C:");
            System.out.println(direccionesSocio3);
        } catch (MemberNotFoundException e) {
            System.out.println("Socio no encontrado!" +e.getMessage());
        }

        // Buscar socio por dirección específica
        try {
            Partner partner = library.getEspecificoPartner("Carrer de la Pau", 101, 03001);
            System.out.println("Socio encontrado por dirección: " + partner.getNif());
        } catch (MemberNotFoundException e) {
            System.out.println("Socio no encontrado!" +e.getMessage());
        }

        // Buscar una dirección específica
        try {
            Address address = library.getEspecificAddress("Carrer de Xàtiva", 56, 46007);
            System.out.println("Dirección encontrada: " + address);
        } catch (AddressNotFoundException e) {
            System.out.println("direccion no encontrada!" +e.getMessage());
        }



        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        String fichero = "";

        while (!salir) {
            System.out.println("===== Menú de Opciones =====");
            System.out.println("1. Crear nombre para el fichero binario");
            System.out.println("2. Guardar lista de socios en fichero");
            System.out.println("3. Leer e imprimir contenido del fichero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de la opción seleccionada

            switch (opcion) {


                case 1:

                    fichero = crearNombreFichero(scanner);
                    break;

                case 2:

                    guardarListaSociosEnFichero(fichero, listSocios);
                    break;

                case 3:

                    leerYMostrarContenidoFichero(fichero);
                    break;

                case 4:

                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");


            }
            System.out.println();
        }

        scanner.close();
    }

    // Un método que pida por Scanner un nombre del fichero para crear el nombre final
    // del fichero binario.
    private static String crearNombreFichero(Scanner scanner) {

        System.out.print("Ingrese el nombre del fichero binario: ");

        String nombreFichero = scanner.nextLine();

        System.out.println("Nombre del fichero creado: " + nombreFichero);

        try {

            File f = new File(nombreFichero+".bin");

            f.createNewFile();

        }catch (Exception exception){

            System.out.println("Error: "+exception.getMessage());

        }

        return nombreFichero+".bin";
    }

    // Método que guarda la lista de socios en el fichero binario
    private static void guardarListaSociosEnFichero(String fichero, ArrayList<Partner> listSocios) {

        String datos_socios = "";

        try (DataOutputStream escribir = new DataOutputStream(new FileOutputStream(fichero))) {

            for (Partner p : listSocios) {
                // String datosSocio = p.getNif();

                for (Address address : p.getAddressArrayList()) {
                    escribir.writeUTF(address.getCiudad());
                    escribir.writeUTF(address.getCalle());
                    escribir.writeInt(address.getCp());
                    escribir.writeInt(address.getNumero());
                }


            }

            System.out.println("Guardada la lista de socios en el fichero binario.");

        } catch (IOException exception) {

            System.out.println("Error: " + exception.getMessage());

        }

    }

    // Método que lee el contenido del fichero e imprime en pantalla usando printf
    private static void leerYMostrarContenidoFichero(String fichero) {

        try (DataInputStream leer = new DataInputStream(new FileInputStream(fichero))) {

            while (true) {  // Leer en un bucle infinito hasta alcanzar el final del archivo
                String datosCiudad = leer.readUTF();
                String datosCalle = leer.readUTF();
                int datosCp = leer.readInt();
                int datosNumero = leer.readInt();
                System.out.printf("Datos del socio: %-5s %-5s %-5s %-5s %n",
                        datosCiudad, datosCalle, datosCp, datosNumero);
            }

        } catch (EOFException eof) {
            System.out.println("Se acabo el contenido para leer y mostrar.");
        } catch (IOException exception) {
            System.out.println("Error, no se encontro el fichero: " + exception.getMessage());
        } catch (Exception exception){
            System.out.println("Fatal Error: "+exception.getMessage());
        }
    }
}
