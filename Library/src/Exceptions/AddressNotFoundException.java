package Exceptions;

public class AddressNotFoundException extends Exception {
    public AddressNotFoundException(String s) {
        System.out.println("Error: "+s);
    }
}
