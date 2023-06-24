import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final Calculator calculator = new Calculator(readPersonCount(scanner));
        readProducts(calculator, scanner);

        System.out.println(calculator.getReport());

        scanner.close();
    }

    private static int readPersonCount(final Scanner scanner) {
        while(true) {
            System.out.println("На скольких человек разделить счет?");
            try {
                final int personCount = scanner.nextInt();
                if (personCount == 1) {
                    System.out.println("Нет смысла делить счет на одного человека.");
                } else if (personCount < 1) {
                    System.out.println("Количество человек не может быть меньше единицы.");
                } else {
                    scanner.nextLine();
                    return personCount;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Некорректный ввод");
                scanner.nextLine();
            }
        }
    }

    private static void readProducts(final Calculator calculator, final Scanner scanner) {
        while (true) {
            final String stopWord = "Завершить";
            final String productName = readProductName(scanner);
            final double productPrice = readProductPrice(scanner);
            calculator.addProduct(new Product(productName, productPrice));

            System.out.printf(
                    "Введите \"%s\", чтобы завершить ввод товаров, или любую строку, чтобы продолжить:%n",
                    stopWord);
            if (scanner.nextLine().trim().equalsIgnoreCase(stopWord)) {
                return;
            }
        }

    }

    private static String readProductName(final Scanner scanner) {
        while (true) {
            System.out.println("Введите наименование товара:");
            final String productName = scanner.nextLine().trim();
            if (productName.isEmpty()) {
                System.out.println("Наименование товара не может быть пустым.");
            }
            else {
                return productName;
            }
        }
    }

    private static double readProductPrice(final Scanner scanner) {
        while (true) {
            System.out.println("Введите стоимость товара:");
            try {
                final double productPrice = scanner.nextDouble();
                if (productPrice <= 0) {
                    System.out.println("Стоимость товара должна быть больше нуля.");
                } else {
                    scanner.nextLine();
                    return productPrice;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Некорректный ввод");
                scanner.nextLine();
            }
        }
    }
}
