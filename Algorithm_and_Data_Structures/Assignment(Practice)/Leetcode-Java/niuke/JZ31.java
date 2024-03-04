package niuke;

public class JZ31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int result = 0;
        int dight = 1;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) result += high * dight;
            else if (cur == 1) result += high * dight + low + 1;
            else result += (high + 1) * dight;

            low += dight * cur;
            cur = high % 10;
            high /= 10;
            dight *= 10;
        }
        return result;
    }
}
