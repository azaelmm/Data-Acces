package Models;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase de prueba que inicializa datos para la simulación de una biblioteca
 * con libros y socios.
 */
public class Testing {

    /**
     * Método principal para probar la creación de objetos como libros, socios y la biblioteca.
     * Se crean varias instancias de libros y socios, luego se agrupan en una instancia de biblioteca.
     *
     */
    public static void test () {

        // Creación de una lista de géneros que se asignarán a los libros
        ArrayList<String> list_generos = new ArrayList<>();
        list_generos.add("Terror");
        list_generos.add("Aventura");
        list_generos.add("Drama");
        list_generos.add("Comedia");

        // Creación de instancias de libros con sus respectivos atributos
        Book b1 = new Book("1243GF", "Rich dad Poor dad", "Robert", list_generos);
        Book b2 = new Book("500Y03", "La sociedad de la nieve", "Peter", list_generos);
        Book b3 = new Book("5554T3", "Programa en Java como si no hubiese un mañana", "Paco", list_generos);
        Book b4 = new Book("29762W", "Detras de mi", "Kristen", list_generos);

        // Creación de una lista de libros que contiene las instancias creadas anteriormente
        ArrayList<Book> list_books = new ArrayList<>();
        list_books.add(b1);
        list_books.add(b2);
        list_books.add(b3);
        list_books.add(b4);

        // Creación de instancias de socios con sus respectivos atributos
        Partner p1 = new Partner("55414459T", "Manolo", "Perez", 1000, 45900);
        Partner p2 = new Partner("86251937W", "Koke", "Perez", 1001, 45900);
        Partner p3 = new Partner("34927164R", "Mikel", "Perez", 1002, 45900);
        Partner p4 = new Partner("88665921P", "Unai", "Perez", 1003, 45900);

        // Creación de una lista de socios que contiene las instancias creadas anteriormente
        ArrayList<Partner> list_partner = new ArrayList<>();
        list_partner.add(p1);
        list_partner.add(p2);
        list_partner.add(p3);
        list_partner.add(p4);

        // Creación de una instancia de la biblioteca con los libros y socios
        Library library = new Library("lib & Azael", "Plaza España", list_books, list_partner);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        String fichero = "";
        ArrayList<String> list = new ArrayList<>();

        while (!exit) {
            // Menú de opciones
            System.out.println("Selecciona una opción:");
            System.out.println("1. Introducir nombre de fichero y número");
            System.out.println("2. Escribir en un fichero CSV");
            System.out.println("3. Guardar lista de libros en CSV");
            System.out.println("4. Leer contenido de un fichero CSV");
            System.out.println("5. Imprimir contenido de un ArrayList");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch (opcion) {
                case 1:
                    // Llamada al método para pedir nombre del fichero y número
                    fichero = pedirNombreYNumero(scanner);
                    break;
                case 2:
                    // Llamada al método para escribir en un fichero CSV
                    escribirCabeceraEnFicheroCSV(fichero);
                    break;
                case 3:
                    // Llamada al método para guardar lista de libros en el CSV
                    guardarListaEnCSV(fichero, list_books);
                    break;
                case 4:
                    // Llamada al método para leer el contenido de un fichero CSV
                    list = leerFicheroCSV(fichero);
                    break;
                case 5:
                    // Llamada al método para imprimir el contenido de un ArrayList
                    imprimirArrayList(list);
                    break;
                case 6:
                    // Salir
                    exit = true;
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        }

    }

    private static void imprimirArrayList(ArrayList<String> list) {

        for (String s: list) {
            System.out.println(s);
        }
    }

    private static ArrayList<String> leerFicheroCSV(String fichero) {

        ArrayList<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))){

            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);  // Agrega la línea completa a la lista
            }

            System.out.println("Se almaceno correctamente el fichero en el Arraylist.\n");

        } catch (Exception exception) {
            System.out.println("Error al intentar leer el fichero y pasarlo al arraylist! " + exception.getMessage());
        }

        return list;
    }

    private static void guardarListaEnCSV(String fichero, ArrayList<Book> list_books) {

        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream(fichero, true))){
            for (Book book:list_books) {
                dout.writeUTF("El ISBN: "+book.getISBN() + ", que tiene el titulo: "+ book.getTitle() + "y autor:" + book.getAuthor());
            }
            System.out.println("Se guardo la lista de libros existosamente");
        } catch (Exception exception) {
            System.out.println("Error al escribir la lista de libros en el fichero CSV indicado.");
        }

    }

    private static void escribirCabeceraEnFicheroCSV(String fichero) {
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream(fichero))){
            dout.writeChars("ISBN;TITULO;AUTOR;");
            System.out.println("\nSe escribio correctamente la cabecera\n");
        }catch (Exception exception){
            System.out.println("No se pudo escribir la cabecera :( " + exception.getMessage());
        }
    }

    private static String pedirNombreYNumero(Scanner scanner) {
        System.out.println("ingrese el nombre del fichero:");
        String nombreFile = scanner.nextLine();
        System.out.println("ingrese un numero para concatenar con el numero");
        String numero = scanner.nextLine();

        File f = new File(nombreFile+numero+".csv");

        System.out.println("Nombre final del archivo: " + nombreFile+numero+".csv\n");

        try {
            f.createNewFile();
        }catch (Exception exception){
            System.out.println("Error al crear este fichero." + exception.getMessage());
        }

        return nombreFile+numero+".csv";
    }
}
