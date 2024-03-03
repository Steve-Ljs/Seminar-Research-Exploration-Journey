package niuke;

public class JZ33 {
    /*
   1 2 3 4 5 6 9 10 15
   维护三个指针，代表*2,*3,*5的索引位置

   dp[i]代表带i+1个丑数
   初始值dp[0] = 1
   递推公式：
   最后返回dp[index - 1]
   */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        int[] dp = new int[index];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < index; i++) {
            int value2 = dp[p2] * 2, value3 = dp[p3] * 3, value5 = dp[p5] * 5;
            dp[i] = Math.min(value2, Math.min(value3, value5));
            if (dp[i] == value2) p2++;
            if (dp[i] == value3) p3++;
            if (dp[i] == value5) p5++;
        }
        return dp[index - 1];
    }
}
