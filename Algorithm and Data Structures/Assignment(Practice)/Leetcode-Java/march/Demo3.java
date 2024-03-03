package march;

public class Demo3 {
    /*
从左到右寻找
单个，双个进行扩展
*/
    public String longestPalindrome(String s) {
        //look 不能写s.length
        if (s == null || s.length() == 0) return "";
        //look 返回的不是一个数result，而是一个字符串
        //look 注意变量名不要写错
        int lo = 0, hi = 0;

        for (int i = 0; i < s.length(); i++) {
            //单个扩展
            int left = i, right = i;
            while (left - 1 >= 0 && right + 1 < s.length() && s.charAt(left - 1) == s.charAt(right + 1)) {
                --left;
                ++right;
            }

            if ((hi - lo + 1) < (right - left + 1)) {
                lo = left;
                hi = right;
            }


            //双向扩展
            //look 不是赋值不能这样写：left = i, right = i + 1;
            left = i;
            right = i + 1;
            if (right < s.length() && s.charAt(left) == s.charAt(right)) {
                while (left - 1 >= 0 && right + 1 < s.length() && s.charAt(left - 1) == s.charAt(right + 1)) {
                    --left;
                    ++right;
                }
                if ((hi - lo + 1) < (right - left + 1)) {
                    lo = left;
                    hi = right;
                }
            }
        }

        //look 用法：public String substring(int beginIndex, int endIndex)
        //[beginIndex, endIndex)
        return s.substring(lo, hi + 1);
    }
}
