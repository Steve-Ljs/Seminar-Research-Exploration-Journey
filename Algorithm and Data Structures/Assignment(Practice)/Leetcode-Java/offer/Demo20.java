package offer;

public class Demo20 {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;

        //标记是否遇到这些情况
        boolean numSeen = false, dotSeen = false, eSeen = false;
        char[] string = s.trim().toCharArray();//trim去掉空格

        for (int i = 0; i < string.length; i++) {
            char ch = string[i];
            if (ch >= '0' && ch <= '9') {
                numSeen = true;
            }
            else if (ch == '.') {
                //.前不能出现e/E
                if (dotSeen || eSeen) return false;
                dotSeen = true;
            }
            else if (ch == '+' || ch == '-') {
                //+-必须出现再0位,或者出现在e/E后面一个字符
                if (i != 0 && string[i - 1] != 'e' && string[i - 1] != 'E') return false;
            }
            else if (ch == 'e' || ch == 'E') {
                //e前必须出现数,并且不能出现e
                if (!numSeen || eSeen) return false;
                eSeen = true;
                //重置numSeen 排除123e等情况,确保e后也出现数
                numSeen = false;
            }
            else {
                //出现其他字符
                return false;
            }
        }
        return numSeen;
    }
}
