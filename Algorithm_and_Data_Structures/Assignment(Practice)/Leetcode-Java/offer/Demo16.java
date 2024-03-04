package offer;

public class Demo16 {
    /*
    注意base=0的特殊情况
    注意exponent为负数的情况

    a^n = a^(n/2)*a^(n/2) n为偶数
    a^n = a^(n/2)*a^(n/2)*a n为偶数
    */
    public double Power(double base, int exponent) {
        if (base == 0 && exponent <= 0) throw new RuntimeException("Illegal Argument");
        if (base == 0) return 0;
        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        boolean isNegative = false;
        if (exponent < 0) {
            isNegative = true;
            exponent = -exponent;
        }

        double result = Power(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }
        if (isNegative) return 1 / result;
        return result;
    }
}
