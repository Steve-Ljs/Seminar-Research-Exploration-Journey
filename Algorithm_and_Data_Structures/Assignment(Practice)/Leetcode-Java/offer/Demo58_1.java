package offer;

public class Demo58_1 {
    //最快的方式
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] strs = s.trim().split(" ");
        for (int i = strs.length - 1; i >= 0; i--) {
            if ("".equals(strs[i])) continue;
            res.append(strs[i]).append(" ");
        }
        return res.toString().trim();
    }

    //双指针法
    public String reverseWords1(String s) {
        StringBuilder res = new StringBuilder();
        s = s.trim(); //删除首尾空格
        //双指针,从尾部不断找到单词,并且放到前面
        int lo = s.length() - 1, hi = lo;
        while (lo >= 0) {
            //搜索该单词前的首个空格
            while (lo >= 0 && s.charAt(lo) != ' ') lo--;
            res.append(s.substring(lo + 1, hi + 1) + " "); //添加首个单词
            while (lo >= 0 && s.charAt(lo) == ' ') lo--; //跳过单词间空格
            hi = lo; //hi指向下一个单词的尾字符
        }
        //最后一个单词还有一个空格
        return res.toString().trim();
    }
}
