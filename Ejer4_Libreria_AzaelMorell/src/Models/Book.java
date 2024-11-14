package Models;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase que representa un libro.
 * Un libro tiene un ISBN, título, autor, una lista de géneros y un género principal aleatorio.
 * Implementa la interfaz Comparable para comparar libros por título, autor e ISBN.
 */
public class Book implements Comparable<Book>{

    protected String ISBN;
    protected String title;
    protected String author;
    protected ArrayList<String> list_genres = new ArrayList<>();
    private String Genero;

    /**
     * Constructor de la clase Book.
     * Inicializa un libro con su ISBN, título, autor y lista de géneros.
     * El género principal del libro es asignado aleatoriamente de la lista de géneros.
     *
     * @param ISBN ISBN del libro.
     * @param title Título del libro.
     * @param author Autor del libro.
     * @param list_genres Lista de géneros del libro.
     */
    public Book(String ISBN, String title, String author, ArrayList<String> list_genres) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.list_genres = list_genres;
        this.Genero = list_genres.get(numRamdom());
    }

    /**
     * Método privado para obtener un índice aleatorio dentro del rango de la lista de géneros.
     * Este índice es utilizado para seleccionar un género aleatorio.
     *
     * @return Índice aleatorio para seleccionar un género.
     */
    private int numRamdom() {
        Random random = new Random();
        return random.nextInt(0, list_genres.size());
    }

    // Constructor vacío de la clase Book
    public Book() {
    }

    // GETTERS Y SETTERS

    /**
     * Obtiene el ISBN del libro.
     *
     * @return ISBN del libro.
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Establece el ISBN del libro.
     *
     * @param ISBN ISBN del libro.
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return Título del libro.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Establece el título del libro.
     *
     * @param title Título del libro.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return Autor del libro.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Establece el autor del libro.
     *
     * @param author Autor del libro.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Obtiene la lista de géneros del libro.
     *
     * @return Lista de géneros del libro.
     */
    public ArrayList<String> getList_genres() {
        return list_genres;
    }

    /**
     * Establece la lista de géneros del libro.
     *
     * @param list_genres Lista de géneros del libro.
     */
    public void setList_genres(ArrayList<String> list_genres) {
        this.list_genres = list_genres;
    }

    /**
     * Obtiene el género principal del libro.
     *
     * @return Género principal del libro.
     */
    public String getGenero() {
        return Genero;
    }

    /**
     * Establece el género principal del libro.
     *
     * @param genero Género principal del libro.
     */
    public void setGenero(String genero) {
        Genero = genero;
    }

    /**
     * Representación en cadena del libro.
     * Devuelve una cadena con la información del libro, incluyendo ISBN, título, autor y género.
     *
     * @return Representación en formato String del libro.
     */
    @Override
    public String toString() {
        return super.toString() + " " + getClass().getSimpleName() +
                " ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genero=" + Genero +
                '}';
    }

    /**
     * Compara este libro con otro basándose en el título, autor e ISBN.
     * El orden es el siguiente: título, luego autor, luego ISBN.
     *
     * @param o El libro con el cual comparar.
     * @return Valor negativo si este libro es alfabéticamente anterior al otro,
     *         cero si son iguales, o valor positivo si es posterior.
     */
    @Override
    public int compareTo(Book o) {
        int result = this.getTitle().compareToIgnoreCase(o.getTitle());

        // FUNCIONAMIENTO:
        // Negativo si el título del libro actual es alfabéticamente anterior al título de o.
        // Cero si los títulos son iguales.
        // Positivo si el título del libro actual es alfabéticamente posterior al título de o.
        if (result != 0) {
            return result;
        }

        result = this.getAuthor().compareToIgnoreCase(o.getAuthor());
        if (result != 0) {
            return result;
        }

        return this.getISBN().compareToIgnoreCase(o.getISBN());
    }
}
