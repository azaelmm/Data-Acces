package Exceptions;

public class MemberNotFoundException extends Exception {

    public MemberNotFoundException(String s) {
        System.out.println("Error: "+s);
    }
}
