package niuke;

public class JZ53 {
    /*
    正负号，只能出现一个(在最前面)或者没有
    指数eE没有或只有一个 后面可以紧接着出现正负号 前后必须出现数字 后面不能出现小数点
    小数点

    没出现数字不是
    出现其他字符则不是
    */
    public boolean isNumeric(char[] str) {
        //判断是否出现数字
        boolean hasNum = false;
        //判断是否出现小数点
        boolean hasDot = false;
        //判断是否出现指数
        boolean hasE = false;

        for (int i = 0; i < str.length; i++) {
            char ch = str[i];
            if (ch == '+' || ch=='-') {
                if (i == 0 || (str[i - 1] == 'e' || str[i - 1] == 'E')) {
                    //出现在开头，或者出现在e/E后面是合法的
                }
                else {
                    return false;
                }
            }
            else if (ch == 'e' || ch == 'E') {
                //已经存在了指数
                if (hasE) return false;
                //指数前没有数字
                if (!hasNum) return false;
                //注意之后要判断后面有没有数字
                hasE = true;

                hasNum = false;
            }
            else if (ch == '.') {
                if  (hasDot) return false;
                if (hasE) return false;
                //注意之后要判断后面有没有数字
                hasDot = true;
            }
            else if (ch >= '0' && ch <= '9') {
                hasNum = true;
            }
            else {
                return false;
            }
        }
        return hasNum;
    }

    public static void main(String[] args) {
        System.out.println(new JZ53().isNumeric("123.".toCharArray()));
    }
}
