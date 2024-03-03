package demo01_50;

import java.util.LinkedList;
import java.util.List;

public class Demo09
{
    /*
    和下面那个自己写的差不多，只不过小优化，一个是用数组存储 其中，0，1位置为空
    只需要digits.charAt(i)-'0'就能找到正确位置
    二是用stringBuilder代替string，但是再循环中，要加入ch进入递归，之后还得去掉加入这个
    因为是引用对象，不能一直加
     */

    String [] map={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> result = new LinkedList<>();

    public List<String> letterCombinations(String digits)
    {
        if(digits==null || digits.length()==0) return result;

        recursive(digits, 0, new StringBuilder());

        return result;
    }

    private void recursive(String digits, int i, StringBuilder stringBuilder)
    {
        if (i == digits.length())
        {
            result.add(stringBuilder.toString());
            return;
        }
        for (char ch : map[digits.charAt(i)-'0'].toCharArray())
        {
            stringBuilder.append(ch);
            recursive(digits,i+1,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }


    //最直观的递归，但是效率不高
    /*private List<String> result = new LinkedList<>();
    private Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits)
    {
        if(digits.length()==0) return result;

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        recursive(digits, 0, "");
        return result;
    }

    //digits的第i个元素代表的数字，加入string中
    private void recursive(String digits, int i, String string)
    {
        if (i == digits.length())
        {
            result.add(string);
            return;
        }
        for (char ch : map.get(digits.charAt(i)).toCharArray())
        {
            recursive(digits,i+1,string+ch);
        }
    }*/
}
