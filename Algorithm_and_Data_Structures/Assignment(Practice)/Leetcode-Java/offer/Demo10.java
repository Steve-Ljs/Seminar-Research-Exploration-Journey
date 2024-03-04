package offer;

public class Demo10 {
    public int fib(int n) {
        if (n < 0) throw new RuntimeException("illegal Argument");
        if (n == 0 || n == 1) return n;
        int first = 0, second = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    /*
    因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
    跳1级，剩下n-1级，则剩下跳法是f(n-1)
    跳2级，剩下n-2级，则剩下跳法是f(n-2)
    所以f(n)=f(n-1)+f(n-2)+...+f(1)
    因为f(n-1)=f(n-2)+f(n-3)+...+f(1)
    所以f(n)=2*f(n-1)
    f(0)=1,f(1)=1 f(n) = 2^(n-1)
     */
    public int JumpFloorII(int target) {
        if (target < 0) throw new RuntimeException("Illegal Argument");
        if (target == 0 || target == 1) return 1;
        return (int)Math.pow(2, target - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Demo10().JumpFloorII(4));
    }
}
