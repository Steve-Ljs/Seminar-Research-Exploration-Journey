package niuke;

import java.util.Arrays;
import java.util.HashSet;

public class JZ44 {
    public String ReverseSentence(String str) {
        StringBuilder result = new StringBuilder();

        //传入"    "还要输出这个原本的
        if ("".equals(str.trim())) return str;

        String[] strings = str.trim().split(" ");

        for (int i = strings.length - 1; i >= 0; i--) {
            //如果单词之间有几个空格，同样忽略掉
            if (" ".equals(strings[i])) continue;

            if (result.length() != 0) result.append(" ");
            result.append(strings[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "    ab  c d e  ";
        System.out.println(s.trim());
        s = s.trim();
        String[] strings = s.split(" ");
        System.out.println(Arrays.toString(strings));
        System.out.println(strings.length);
    }
}
