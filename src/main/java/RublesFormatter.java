public class RublesFormatter {
    public static String formatRubles(double sum) {
        return String.format("%.2f рубл%s", sum, getRublesSuffix((int) sum));
    }

    private static String getRublesSuffix(int sum){
        final int tens = sum % 100 / 10;
        if (tens == 1) {
            return "ей";
        }
        final double ones = sum % 10;
        if (ones == 1) {
            return "ь";
        } else if (ones >= 2 && ones <= 4) {
            return "я";
        }
        return "ей";
    }
}
