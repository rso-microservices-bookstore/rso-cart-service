package si.fri.rso.carts;

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
}
