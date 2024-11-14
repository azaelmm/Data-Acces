package Models;

import java.util.ArrayList;

public class PhysicalBook extends Book{

    private int publicationYear;

    // constructor with the heredation

    public PhysicalBook(String ISBN, String title, String author, ArrayList<String> list_genres, int publicationYear) {
        super(ISBN, title, author, list_genres);
        this.publicationYear = publicationYear;
    }

    // empty constructor

    public PhysicalBook() {
    }

    // getters and setters

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    // getter all the info about the physical Book

    @Override
    public String toString() {
        return super.toString() +" "+ getClass().getSimpleName()+
                "publicationYear=" + publicationYear +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", list_genres=" + list_genres  ;
    }
}
