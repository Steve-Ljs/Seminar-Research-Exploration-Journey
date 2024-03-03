package march;

public class Demo7 {
    public int reverse(int x) {
        int result = 0;
        int positiveMod = Integer.MAX_VALUE % 10;
        int negativeMod = Integer.MIN_VALUE % 10;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > positiveMod)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < negativeMod)) {
                return 0;
            }

            result = result * 10 + pop;
        }
        return result;
    }
}
