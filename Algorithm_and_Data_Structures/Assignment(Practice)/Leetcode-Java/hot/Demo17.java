package hot;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Demo17
{
    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private LinkedList<String> result = new LinkedList<>();
    private StringBuilder stringBuilder = new StringBuilder();


    //方法局部变量变成成员变量,加快速度
    public List<String> letterCombinations(String digits)
    {
        //look 长度为0,返回空,而不是空的字符串串
        if(digits==null || digits.length()==0) return result;
        recursive(digits,0);
        return result;
    }

    //result为结果集合,stringBuilder存储中间字符串,index代表递归到哪个数字字符
    private void recursive(String digits, int index)
    {
        if(index==digits.length())
        {
            result.add(stringBuilder.toString());
            return;
        }

        //优化速度
        String string = map[digits.charAt(index)-'0'];//例如abc
        for (int i = 0; i < string.length(); i++)
        {
            stringBuilder.append(string.charAt(i));//例如加入a
            recursive(digits, index + 1);//继续下一层
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);//删除刚刚加入的
        }
    }
}
