package niuke;

public class JZ12 {
    public double Power(double base, int exponent) {
        if (base == 0) {
            if (exponent > 0) {
                return 0;
            }
            else {
                throw new RuntimeException("Illegal Argument");
            }
        }
        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        boolean isNegative = false;
        if (exponent < 0) {
            isNegative = true;
            exponent = - exponent;
        }

        double result = Power(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }

        if (isNegative) {
            return 1 / result;
        }
        return result;
    }



    /*
   特殊情况：
   base = 0,exponent为正数则为1，exponent为0或负数无意义

   exponent为0，则返回1
   exponent为负数，最后要1/值


   dp[i] 代表base的i次方
   dp[i] = dp[i / 2] * dp[ (i + 1) / 2]
   dp[0] = 1.0, dp[1] = base
   */
    public double Power1(double base, int exponent) {
        if (base == 0) {
            if (exponent > 0) return 0;
            else throw new RuntimeException("输入不合法！");
        }
        if (exponent == 0) return 1;
        int n = Math.abs(exponent);
        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        dp[1] = base;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i / 2] * dp[(i + 1) / 2];
        }
        if (exponent < 0) {
            return 1 / dp[n];
        }
        return dp[n];
    }
}
