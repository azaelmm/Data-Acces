package Models;

import Exceptions.BookNotFoundException;
import Exceptions.MemberNotFoundException;
import Interfaces.ILibrary;

import java.util.ArrayList;

/**
 * Clase que representa una biblioteca.
 * Contiene información sobre el nombre, dirección, lista de libros y lista de socios.
 * Implementa la interfaz ILibrary que define los métodos necesarios para gestionar libros y socios.
 */
public class Library implements ILibrary {

    private String nameLibrary;
    private String address;
    private ArrayList<Book> list_books = new ArrayList<>();
    private ArrayList<Partner> list_partner = new ArrayList<>();

    /**
     * Constructor de la clase Library.
     * Inicializa una nueva biblioteca con el nombre, la dirección, los libros y los socios.
     *
     * @param nameLibrary Nombre de la biblioteca.
     * @param address Dirección de la biblioteca.
     * @param list_books Lista de libros disponibles en la biblioteca.
     * @param list_partner Lista de socios registrados en la biblioteca.
     */
    public Library(String nameLibrary, String address, ArrayList<Book> list_books, ArrayList<Partner> list_partner) {
        this.nameLibrary = nameLibrary;
        this.address = address;
        this.list_books = list_books;
        this.list_partner = list_partner;
    }

    /**
     * Constructor vacío de la clase Library.
     * Utilizado cuando se crea una biblioteca sin parámetros iniciales.
     */
    public Library() {
    }

    // GETTERS AND SETTERS

    /**
     * Obtiene el nombre de la biblioteca.
     *
     * @return Nombre de la biblioteca.
     */
    public String getNameLibrary() {
        return nameLibrary;
    }

    /**
     * Establece el nombre de la biblioteca.
     *
     * @param nameLibrary Nombre de la biblioteca.
     */
    public void setNameLibrary(String nameLibrary) {
        this.nameLibrary = nameLibrary;
    }

    /**
     * Obtiene la dirección de la biblioteca.
     *
     * @return Dirección de la biblioteca.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Establece la dirección de la biblioteca.
     *
     * @param address Dirección de la biblioteca.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Obtiene la lista de libros de la biblioteca.
     *
     * @return Lista de libros.
     */
    public ArrayList<Book> getList_books() {
        return list_books;
    }

    /**
     * Establece la lista de libros de la biblioteca.
     *
     * @param list_books Lista de libros.
     */
    public void setList_books(ArrayList<Book> list_books) {
        this.list_books = list_books;
    }

    /**
     * Obtiene la lista de socios de la biblioteca.
     *
     * @return Lista de socios.
     */
    public ArrayList<Partner> getList_partner() {
        return list_partner;
    }

    /**
     * Establece la lista de socios de la biblioteca.
     *
     * @param list_partner Lista de socios.
     */
    public void setList_partner(ArrayList<Partner> list_partner) {
        this.list_partner = list_partner;
    }

    /**
     * Método toString para representar la biblioteca como una cadena de texto.
     * Incluye el nombre, la dirección, los libros y los socios.
     *
     * @return Representación en formato String de la biblioteca.
     */
    @Override
    public String toString() {
        return super.toString() + " " + getClass().getSimpleName() +
                " nameLibrary='" + nameLibrary + '\'' +
                ", address='" + address + '\'' +
                ", list_books=" + list_books +
                ", list_partner=" + list_partner +
                '}';
    }

    /**
     * Método para obtener un libro específico mediante su ISBN.
     * Si el libro no se encuentra, lanza una excepción BookNotFoundException.
     *
     * @param ISBN ISBN del libro a buscar.
     * @return El libro con el ISBN especificado.
     * @throws BookNotFoundException Excepción lanzada si no se encuentra el libro.
     */
    @Override
    public Book getSpecificBook(String ISBN) throws BookNotFoundException {
        for (Book b : list_books) {
            if (b.getISBN().equalsIgnoreCase(ISBN)) {
                return b;
            }
        }

        throw new BookNotFoundException("Libro con ISBN: " + ISBN + " no encontrado.");
    }

    /**
     * Método para obtener una lista de libros con un género específico.
     * Si no se encuentran libros con el género solicitado, muestra un mensaje en consola.
     *
     * @param genres Género que se desea buscar en los libros.
     * @return Lista de libros que coinciden con el género.
     */
    @Override
    public ArrayList<Book> getSpecificBooks(String genres) {
        Boolean foundBooks = false;
        ArrayList<Book> listSpecificsBooks = new ArrayList<>();

        for (Book book : list_books) {
            for (String genero : book.getList_genres()) {
                if (genero.equalsIgnoreCase(genres)) {
                    foundBooks = true;
                    listSpecificsBooks.add(book);
                    break;
                }
            }
        }

        if (!foundBooks) {
            System.out.println("No se ha encontrado ningun libro con ese genero.");
        }

        return listSpecificsBooks;
    }

    /**
     * Método para obtener una lista de socios con un código postal específico.
     * Si no se encuentran socios con el código postal indicado, muestra un mensaje en consola.
     *
     * @param postalCode Código postal de los socios a buscar.
     * @return Lista de socios que coinciden con el código postal.
     */
    @Override
    public ArrayList<Partner> getSpecificPartners(int postalCode) {
        ArrayList<Partner> listSpecificsPartners = new ArrayList<>();

        for (Partner partner : list_partner) {
            if (partner.getPostalCode() == postalCode) {
                listSpecificsPartners.add(partner);
            }
        }

        if (listSpecificsPartners.isEmpty()) {
            System.out.println("No se encontro a nadie en ese codigo postal.");
        }

        return listSpecificsPartners;
    }

    /**
     * Método para obtener un socio específico mediante su NIF.
     * Si el socio no se encuentra, lanza una excepción MemberNotFoundException.
     *
     * @param NIF NIF del socio a buscar.
     * @return El socio con el NIF especificado.
     * @throws MemberNotFoundException Excepción lanzada si no se encuentra el socio.
     */
    @Override
    public Partner getSpecificPartner(String NIF) throws MemberNotFoundException {
        for (Partner partner : list_partner) {
            if (partner.getNIF().equalsIgnoreCase(NIF)) {
                return partner;
            }
        }

        throw new MemberNotFoundException("Socio con NIF " + NIF + " no encontrado.");
    }
}
