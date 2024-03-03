package demo51_100;


import java.util.*;

public class Demo89_good
{
    /*
        字符串的子字符串,滑动窗口模板
        hi向右相当于在寻找一个「可行解」，
        lo再向右优化这个「可行解」，最终找到最优解。
        左右指针轮流前进，窗口大小增增减减，窗口不断向右滑动。
        for (int lo=0,hi = 0; hi < s.length(); hi++)//lo,hi为左右窗口位置
        {
            window.put(s.charAt(hi), window.getOrDefault(s.charAt(hi), 0) + 1);
            while(valid)
            {
                window.remove(s[left]);
                left++;
            }
        }
     */

    public List<Integer> findAnagrams(String s, String p)
    {
        List<Integer> result = new ArrayList<>();
        int[] need = new int[26];
        //记录p中每个字符出现的次数
        for (char ch : p.toCharArray())
        {
            ++need[ch - 'a'];
        }
        int total = p.length();//如果p中所有元素都出现了,那total应该为0

        int[] window = new int[26];
        for (int lo=0,hi = 0; hi < s.length(); hi++)
        {
            //把元素放入window,为之后判定做准备
            int i = s.charAt(hi) - 'a';
            if(need[i]>0)//至少是p中的字符
            {
                ++window[i];
                //--total;不能这样做是因为 例如p:abc  而window:aab,a显然不能计数两次
                if(window[i]<=need[i]) --total;
            }
            //进入循环就代表着找到一个包含p中所有元素的window,但是也有可能包含其他的字符
            while(total==0)
            {
                if(hi-lo+1==p.length()) result.add(lo);

                //注意下面的都应该是index,因为要弄的是lo对应的元素
                int index = s.charAt(lo) - 'a';
                if(need[index]>0)
                {
                    --window[index];
                    if(window[index]<need[index]) ++total;//说明不符合条件了,应该hi向右寻找了
                }
                ++lo;
            }
        }
        return result;
    }

    //基本对了,但是aaaaaaaaaaa很多时总是出错,不懂为什么,换一个解法
    public List<Integer> findAnagrams1(String s, String p)
    {
        List<Integer> result = new LinkedList<>();

        int match = 0;//匹配了p的个数
        Map<Character, Integer> need = new HashMap<>();//存储p中的字符
        for (int i = 0; i < p.length(); i++)
        {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();//模拟window
        for (int lo = 0, hi = 0; hi < s.length(); hi++)//lo,hi为左右窗口位置
        {
            //都是为了之后判断窗口是否满足起码的条件
            if (need.containsKey(s.charAt(hi)))
            {
                window.put(s.charAt(hi), window.getOrDefault(s.charAt(hi), 0) + 1);
                //放入if中是因为,如果是大家都没有的元素,例如e,也会++match,显然是不对的
                if (window.get(s.charAt(hi)) == need.get(s.charAt(hi))) ++match;
            }

            //窗口中满足了起码的条件
            //在这题中,就是窗口中至少包含了p中所有元素,或许还包含了其他的
            //while(match==p.length())  如果p包含类似aa的就不正确了
            while (match == need.size())
            {
                if (hi - lo + 1 == p.length())
                {
                    result.add(lo);
                }
                if (need.containsKey(s.charAt(lo)))
                {
                    window.put(s.charAt(lo), window.get(s.charAt(lo)) - 1);
                    if (window.get(s.charAt(lo)) < need.get(s.charAt(lo))) --match;
                }
                ++lo;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(new Demo89_good().findAnagrams(s, p));
    }
}
