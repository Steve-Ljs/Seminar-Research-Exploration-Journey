package hot;

import java.time.temporal.Temporal;
import java.util.*;

public class Demo49
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        Map<Integer, List<String>> map = new HashMap<>();
        //List<Integer> prime = prime();
        //预先准备好
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        for (String string : strs)
        {
            int index = 1;
            for (char ch : string.toCharArray())
            {
//                index*=prime.get(ch - 'a');
                index*=prime[ch-'a'];
            }
            if(!map.containsKey(index)) map.put(index, new LinkedList<>());
            map.get(index).add(string);
        }
        return new LinkedList<>(map.values());
    }
    //生成素数
    private List<Integer> prime()
    {
        int N = 26;
        List<Integer> result = new LinkedList<>();

        for (int i = 2; i < 1000; i++)
        {
            int j;
            for (j = i - 1; j > 1; j--)
            {
                if (i % j == 0) break;
            }
            if(j==1) result.add(i);
            if(result.size()==N) break;
        }
        return result;
    }


    //map存储字典序字符串和对应的组。每次循环都把字符串转为字典序字符串，再判断
    public List<List<String>> groupAnagrams1(String[] strs)
    {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++)
        {
            //map中只存储字典序字符串
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String string = String.valueOf(chars);
            //第一次放入某类型的字母异位词
            if (!map.containsKey(string)) map.put(string, new LinkedList<>());

            map.get(string).add(strs[i]);
        }
        return new LinkedList<>(map.values());
    }

    public static void main(String[] args)
    {
        System.out.println(new Demo49().prime());
    }
}
