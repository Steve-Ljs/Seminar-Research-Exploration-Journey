package offer;

public class Demo14 {
    /*
    dp[n]为把长度为n的绳子剪成若干段后长度乘积最大值
    剪第一刀有n-1种可能,即第一段长度可能为[1,n-1]
    dp[n] = max(dp[n-i] * dp[i]) n >= 2     1 <= i <= n-1
     */
    public int cutRope(int target) {
        if (target < 0) return 0;
        if (target <= 3) return target - 1;

        int [] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= target; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * dp[j]);
            }
        }
        return dp[target];
    }

    /*
    贪心算法
    分成两段: 2*(n-2) > n  -> n>4
    分成三段: 3*(n-3) > n -> n>4.5
    所以n>=5时,分成两段或三段的长度要大于不拆分的
    3*(n-3) >= 2*(n-2),所以尽量分成三段

    n=4时,1*3 < 2*2,所以还是拆为2*2
     */
    public int cutRope1(int target) {
        //尽可能将绳子以长度3等分为多段时，乘积最大
        //当剩余4时,则分为2,2
        if (target < 2) return 0;
        if (target == 2) return 1;
        if (target == 3) return 2;

        int a = target / 3, b = target % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }
}
