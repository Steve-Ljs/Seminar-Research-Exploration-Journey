package demo01_50;

import java.util.ArrayList;
import java.util.List;

public class Demo13_look
{

    public List<String> generateParenthesis(int n)
    {
        List<String> result = new ArrayList<>();
        if (n == 0) return result;//必须要,因为n==0时,不能进递归加入个"" FBI warning
        dfs("", n, n, result);
        return result;
    }

    /**
     * @param currentString 当前递归得到的结果
     * @param left          左括号还有几个可以使用
     * @param right         右括号还有几个可以使用
     * @param result        结果集
     */
    private void dfs(String currentString, int left, int right, List<String> result)
    {
        if (left == 0 && right == 0)
        {
            result.add(currentString);return;
        }
        if (left > right) return;// 此时肯定是不符合标准的
        //注意条件语句
        if (left > 0) dfs(currentString + "(", left - 1, right, result);
        if (right > 0) dfs(currentString + ")", left, right - 1, result);
    }
}
