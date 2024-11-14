package Models;

import java.util.ArrayList;

public class DigitalBook extends Book {

    private int ViewsNumber;

    // Constructor with the heredation
    public DigitalBook(String ISBN, String title, String author, ArrayList<String> list_genres, int viewsNumber) {
        super(ISBN, title, author, list_genres);
        ViewsNumber = viewsNumber;
    }

    // Empty Constructor

    public DigitalBook() {
    }

    //getters and setters

    public int getViewsNumber() {
        return ViewsNumber;
    }

    public void setViewsNumber(int viewsNumber) {
        ViewsNumber = viewsNumber;
    }

    // getter all the info about the digital book
    @Override
    public String toString() {
        return super.toString()+" "+getClass().getSimpleName()+
                "ViewsNumber=" + ViewsNumber +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", list_genres=" + list_genres;
    }
}
