
import java.util.*;
import java.util.stream.*;

class Sale {
    private String productId;
    private int quantity;
    private double price;

    public Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}

class ProductSales {
    private String productId;
    private double totalRevenue;

    public ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    public String getProductId() { return productId; }
    public double getTotalRevenue() { return totalRevenue; }

    public String toString() {
        return productId + " - $" + totalRevenue;
    }
}

public class ProductSalesAnalysis {
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale("P1", 5, 10.0),
                new Sale("P2", 15, 20.0),
                new Sale("P3", 25, 5.0),
                new Sale("P4", 12, 12.5),
                new Sale("P5", 30, 3.0),
                new Sale("P6", 9, 50.0),
                new Sale("P7", 11, 8.0)
        );

        List<ProductSales> topProducts = sales.stream()
                .filter(s -> s.getQuantity() > 10)
                .map(s -> new ProductSales(s.getProductId(), s.getQuantity() * s.getPrice()))
                .sorted(Comparator.comparingDouble(ProductSales::getTotalRevenue).reversed())
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("Top 5 Products by Revenue:");
        topProducts.forEach(System.out::println);
    }
}
