package offer;

import java.util.Deque;

public class Demo05 {
    public String replaceSpace(String s) {
        /*
        String.replace() 和 String.replaceAll() 都是全部替换，可以把源字符串中的某一字符或字符串全部换成指定的字符或字符串
        replaceAll() 所用的替换参数可以是普通字符串，也可以是正则表达式。他需要先判断传入参数是不是正则表达式
         */
        return s.replace(" ", "%20");

    }
}
