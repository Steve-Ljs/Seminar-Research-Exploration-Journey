package offer;

public class Demo67 {
    public int strToInt(String str) {
        if (str == null) return 0;
        int bndry = Integer.MAX_VALUE / 10;
        int res = 0;

        boolean isNegative = false; //正负号

        int i = 0;
        boolean firstSymbol = false;

        //去掉开头的空格 并且判断正负号
        for (; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                continue;
            }
            else if (ch == '-') {
                isNegative = true;
                i++;
                break;
            }
            else if (ch == '+') {
                i++; //跳过该符号
                break;
            }
            else if ((ch >= '0' && ch <= '9')) {
                break;
            }
            else {
                //说明是不合法的
                return 0;
            }
        }

        //从这里开始的是数字
        for (; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch >= '0' && ch <= '9')) {
                //注意处理溢出
                if (res > bndry || res == bndry && ch > '7')
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

                res = res * 10 + (ch - '0');
            }
            else {
                break; //忽略后面的字符
            }
        }
        return isNegative ? -res : res;
    }
}
