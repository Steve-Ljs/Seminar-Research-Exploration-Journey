package niuke;

public class JZ47 {
    private int result = 0;

    public int Sum_Solution(int n) {
        result += n;
        boolean temp = (n > 1) && (Sum_Solution(n - 1) > 0);
        return result;
    }
}
