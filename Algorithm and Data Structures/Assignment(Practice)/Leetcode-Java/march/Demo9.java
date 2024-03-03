package march;

public class Demo9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        if (x % 10 == 0) return false; //个位为0，则反转不可能相等

        int reverse = 0;
        while (x > reverse) {
            int temp = x % 10;
            reverse = reverse * 10 + temp;
            x /= 10;
        }
        //1221 12321 奇偶数情况不一样
        if (x == reverse || x == reverse / 10) {
            return true;
        }
        return false;
    }
}
