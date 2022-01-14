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

    public int getBookByIdIndex(int id){
        int index =0;
        for ( Book b: books) {
            if(b.getId() == id)
                return index;
            index = index + 1;
        }
        return -1;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
