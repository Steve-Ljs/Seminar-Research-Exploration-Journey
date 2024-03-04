package offer;

public class Demo64 {
    private int result = 0;
    public int sumNums(int n) {
        boolean temp = n > 1 && sumNums(n - 1) > 0;
        result += n;
        return result;
    }

    public int sumNums1(int n) {
        if (n == 1) return 1;
        return n + sumNums1(n - 1);
    }
}
