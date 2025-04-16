abstract class ProductCategory {
    private String name;

    public ProductCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class BookCategory extends ProductCategory {
    public BookCategory(String name) {
        super(name);
    }
}

class ClothingCategory extends ProductCategory {
    public ClothingCategory(String name) {
        super(name);
    }
}

class GadgetCategory extends ProductCategory {
    public GadgetCategory(String name) {
        super(name);
    }
}

class Product<T extends ProductCategory> {
    private String productName;
    private double price;
    private T category;

    public Product(String productName, double price, T category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product Name: " + productName + ", Price: " + price + ", Category: " + category.getName();
    }
}

public class DynamicOnlineMarketplace {
    public static <T extends Product> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        double newPrice = product.getPrice() - discountAmount;
        product.setPrice(newPrice);
    }

    public static void main(String[] args) {
        BookCategory bookCategory = new BookCategory("Books");
        ClothingCategory clothingCategory = new ClothingCategory("Clothing");
        GadgetCategory gadgetCategory = new GadgetCategory("Gadgets");

        Product<BookCategory> bookProduct = new Product<>("Java Programming", 50.0, bookCategory);
        Product<ClothingCategory> clothingProduct = new Product<>("T-shirt", 20.0, clothingCategory);
        Product<GadgetCategory> gadgetProduct = new Product<>("Smartphone", 400.0, gadgetCategory);

        System.out.println("Before Discount:");
        System.out.println(bookProduct);
        System.out.println(clothingProduct);
        System.out.println(gadgetProduct);

        applyDiscount(bookProduct, 10);
        applyDiscount(clothingProduct, 15);
        applyDiscount(gadgetProduct, 5);

        System.out.println("\nAfter Discount:");
        System.out.println(bookProduct);
        System.out.println(clothingProduct);
        System.out.println(gadgetProduct);
    }
}