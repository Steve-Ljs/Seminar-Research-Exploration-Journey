package hot;

public class Demo05
{
    public String longestPalindrome(String s)
    {
        if(s.length()==0) return s;
        int left = 0, right = 0;//结果

        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            int lo = i, hi = i;
            //单向扩展
            while(lo-1>=0 && hi+1<s.length() && s.charAt(lo-1)==s.charAt(hi+1))
            {
                --lo;
                ++hi;
            }
            //其实是right-left+1 < hi-lo+1
            if((right-left)<(hi-lo))
            {
                left = lo;
                right = hi;
            }

            //双向扩展
            lo = i;
            hi = i + 1;
            //如果一开始就不能双向扩展,就不用管了
            if(hi<s.length() && s.charAt(lo)==s.charAt(hi))
            {
                while(lo-1>=0 && hi+1<s.length() && s.charAt(lo-1)==s.charAt(hi+1))
                {
                    --lo;
                    ++hi;
                }
                if((right-left)<(hi-lo))
                {
                    left = lo;
                    right = hi;
                }
            }
        }
        return s.substring(left,right+1);
    }

    public static void main(String[] args)
    {
        String s = "";
        System.out.println(s.substring(0,-1));
    }
}
