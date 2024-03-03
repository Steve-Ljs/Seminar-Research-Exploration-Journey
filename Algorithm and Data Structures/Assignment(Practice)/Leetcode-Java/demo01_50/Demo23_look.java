package demo01_50;

import java.util.*;

public class Demo23_look
{
    /*
    不一样的素数相乘貌似是不一样的
     */
    //找n个素数
    /*int[] findPrime(int n)
    {
        int[] result = new int[n];
        int count = 0, temp = 2;//数组索引,素数
        while(count!=n)
        {
            int i;
            for (i = 2; i < temp; i++)
            {
                if(temp%i==0) break;
            }
            if(i==temp) result[count++] = temp;
            ++temp;
        }
        return result;
    }*/

    public List<List<String>> groupAnagrams(String[] strs)
    {
//        int[] primer = findPrime(26);
        List<List<String>> result = new LinkedList<>();
        int[] primer = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Integer, Integer> map = new HashMap<>();//乘数,组别
        int group = 0;

        for (String str : strs)
        {
            int index = 1;//FBI warning
            for (char ch : str.toCharArray())
            {
                index *= primer[ch - 'a'];
            }
            if (map.get(index) == null)
            {
                List<String> temp = new LinkedList<>();
                temp.add(str);
                result.add(temp);
                map.put(index, group++);
            }
            else
            {
                result.get(map.get(index)).add(str);
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        new Demo23_look().groupAnagrams(strs);
    }
}
