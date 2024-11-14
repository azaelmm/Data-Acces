package Interfaces;

import Models.Book;
import Exceptions.BookNotFoundException;
import Exceptions.MemberNotFoundException;
import Models.Partner;

import java.util.ArrayList;

public interface ILibrary {

    public Book getSpecificBook (String ISBN) throws BookNotFoundException;
    public ArrayList<Book> getSpecificBooks (String genres);
    public ArrayList<Partner> getSpecificPartners (int postalCode);
    public Partner getSpecificPartner (String NIF) throws MemberNotFoundException, MemberNotFoundException;


}
