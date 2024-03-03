package offer;

import java.util.HashMap;
import java.util.Map;

public class Demo49 {
    /*
   丑数只包含因子 2, 3, 5，因此有 “丑数 = 某较小丑数 * 某因子”
   a,b,c为索引指向目前已有丑数(2, 3, 5对应的)的索引
   X[n + 1] = min(Xa * 2, Xb * 3, Xc * 5)
   */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            //丑数只包含质因子 2、3 和 5
            //用已经有的丑数计算下一丑数
            //候选丑数
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));

            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
