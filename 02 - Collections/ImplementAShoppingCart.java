import java.util.*;
public class ImplementAShoppingCart {
    Map<String, Double> productPrices;
    Map<String, Double> cartLinkedMap;
    Map<String, Double> cartTreeMap;

    public ImplementAShoppingCart() {
        productPrices = new HashMap<>();
        cartLinkedMap = new LinkedHashMap<>();
        cartTreeMap = new TreeMap<>();
    }

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    public void addToCart(String product) {
        if (productPrices.containsKey(product)) {
            cartLinkedMap.put(product, productPrices.get(product));
            cartTreeMap.put(product, productPrices.get(product));
        } else {
            System.out.println("Product not found: " + product);
        }
    }

    public void removeFromCart(String product) {
        cartLinkedMap.remove(product);
        cartTreeMap.remove(product);
    }

    public void displayCart() {
        System.out.println("Cart items in insertion order:");
        for (Map.Entry<String, Double> entry : cartLinkedMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public void displayCartSortedByPrice() {
        System.out.println("Cart items sorted by price:");
        for (Map.Entry<String, Double> entry : cartTreeMap.entrySet()) {
            System.out.println(entry.getKey()  +" " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        ImplementAShoppingCart cart = new ImplementAShoppingCart();

        cart.addProduct("Apple", 0.99);
        cart.addProduct("Banana", 0.49);
        cart.addProduct("Orange", 0.89);
        cart.addProduct("Grapes", 2.99);

        cart.addToCart("Apple");
        cart.addToCart("Banana");
        cart.addToCart("Orange");

        cart.displayCart();
        cart.displayCartSortedByPrice();

        cart.removeFromCart("Banana");
        cart.displayCart();
    }
}