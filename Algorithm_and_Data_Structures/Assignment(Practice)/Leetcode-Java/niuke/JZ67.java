package niuke;

public class JZ67 {
    public int cutRope(int n) {
        if (n < 1) return 0;
        if (n == 2) return 2;
        if (n == 3) return 2;



        if (n % 3 == 0) {
            return (int)Math.pow(3, n / 3);
        }
        else if (n % 3 == 1) {
            return (int)Math.pow(3, n / 3 - 1) * 4;
        }
        else {
            return (int)Math.pow(3, n / 3) * 2;
        }
    }
}
