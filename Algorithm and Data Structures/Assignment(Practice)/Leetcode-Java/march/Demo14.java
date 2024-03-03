package march;

public class Demo14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int hi = 0;
            while (hi < result.length() && hi < strs[i].length() && result.charAt(hi) == strs[i].charAt(hi)) ++hi;
            //look 注意hi指向到了不相等的元素!
            result = result.substring(0, hi);
            if (result.equals("")) return "";
        }
        return result;
    }
}
