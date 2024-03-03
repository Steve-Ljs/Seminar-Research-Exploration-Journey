package niuke;

public class JZ49 {
    /*
    数值为0或者字符串不是一个合法的数值则返回0
    str可能为空
    (+-)数字
    */
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;

        int result = 0;
        boolean isNegative = false;
        //根据第一个字符，判断是否是正负数，或者不合法
        if (str.charAt(0) == '-') {
            isNegative = true;
        }
        else if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            result = str.charAt(0) - '0';
        }
        else if (str.charAt(0) != '+') {
            return 0;
        }

        for (int i = 1; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) return 0;
            result = (result * 10) + (str.charAt(i)- '0');
        }

        if (isNegative) return -result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new JZ49().StrToInt("123"));
    }
}
