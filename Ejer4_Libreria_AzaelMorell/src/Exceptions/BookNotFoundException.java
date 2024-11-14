package Exceptions;

public class BookNotFoundException extends Exception {

    public BookNotFoundException (String mensaje){
        super(mensaje);
    }
}
