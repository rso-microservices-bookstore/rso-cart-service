package si.fri.rso.carts;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private String id;
    private List<Book> books;

    public Cart() {
        books = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Book> getBooks() {
        return books;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
