public class Product {
    public final String name;
    public final double price;

    Product(final String name, final double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + RublesFormatter.formatRubles(price);
    }
}
