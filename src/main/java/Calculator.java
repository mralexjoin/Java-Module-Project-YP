public class Calculator {
    private final int personCount;
    private double sum;
    private String products;

    Calculator(final int personCount) {
        this.personCount = personCount;
        this.products = "Добавленные товары:";
    }

    public void addProduct(Product product) {
        products += "\n" + product;
        sum += product.price;
    }

    public String getReport() {
        final double personExpenses = Math.floor(100 * sum / personCount) / 100;
        final double reminder = sum - personExpenses * personCount;

        return products
                + "\n\nКаждый человек должен заплатить: "
                + RublesFormatter.formatRubles(personExpenses)
                + ((reminder > 0) ? "\nНеделимый остаток: " + RublesFormatter.formatRubles(reminder) : "");
    }
}
