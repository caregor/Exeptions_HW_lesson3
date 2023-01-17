public class Helper {
    public static boolean isDigit(String word) {
        boolean hasDigits = false;
        for (int i = 0; i < word.length() && !hasDigits; i++) {
            if (Character.isDigit(word.charAt(i))) {
                hasDigits = true;
            }
        }
        return hasDigits;
    }
}
