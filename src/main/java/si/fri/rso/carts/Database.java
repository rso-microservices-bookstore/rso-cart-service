package si.fri.rso.carts;

import com.kumuluz.ee.configuration.utils.ConfigurationUtil;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private final static List<Cart> carts = new ArrayList<>();

    public static List<Cart> getCarts() {
        return carts;
    }

    public static Cart getCart(String cartId) {
        for (Cart cart : carts) {
            if (cart.getId().equals(cartId))
                return cart;
        }
        return null;
    }

    public static int addCart(Cart cart) {
        cart.setId(Integer.toString(carts.size()));
        carts.add(cart);
        return carts.size()-1;
    }

    public static boolean addBook(String cartId, Book book) {
        for (Cart cart : carts) {
            if (cart.getId().equals(cartId))
                cart.getBooks().add(book);
            return true;
        }
        return false;
    }

    public static void deleteCart(String customerId) {
        for (Cart cart : carts) {
            if (cart.getId().equals(customerId)) {
                carts.remove(cart);
                break;
            }
        }
    }

    public static boolean deleteBook(String customerId, String bookId) {
        int id = Integer.parseInt(bookId);
        Cart cart = getCart(customerId);
            if (cart.getId().equals(customerId)) {
                if(cart.getBookByIdIndex(id)!=-1) {
                    carts.remove(cart.getBookByIdIndex(id));
                    return  true;
                }

                else {
                    return false;
                }
            }
            return false;
        }

}
