import Exceptions.AddressNotFoundException;
import Exceptions.MemberNotFoundException;
import Models.Testing;

public class Main {
    public static void main(String[] args) throws AddressNotFoundException, MemberNotFoundException {


        Testing t = new Testing();
        t.test();
    }
}