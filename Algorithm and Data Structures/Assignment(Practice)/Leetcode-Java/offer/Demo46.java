package offer;

public class Demo46 {
    /*
   动态规划
   记数字num的第i位数字位x[i],位数为n
   例如num=12258的n=5,x[1]=1
   dp[i]代表以x[i]为结尾的数字的翻译方案数量
   若x[i]和x[i - 1]组成的两位数字可以被翻译,dp[i] = dp[i - 1] + dp[i - 2]
   初始状态:dp[0] = dp[1] = 1
   返回值dp[n]
   */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            String temp = s.substring(i - 2, i);
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }

    //空间优化
    public int translateNum1(int num) {
        String s = String.valueOf(num);
        int first = 1, second = 1, result = 1;
        for (int i = 2; i < s.length() + 1; i++) {
            String temp = s.substring(i - 2, i);
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                result = first + second;
            }
            else {
                result = second;
            }
            first = second;
            second = result;
        }
        return result;
    }
}
