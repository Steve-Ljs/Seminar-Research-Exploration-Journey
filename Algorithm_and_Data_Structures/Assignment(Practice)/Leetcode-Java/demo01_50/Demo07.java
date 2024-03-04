package demo01_50;

public class Demo07
{
    /*
    容器面积为底*高，可以从两边开始，此时底最大，然后找高大于他的
    算容器时，底是[1,n],但是是一样的(hi+1)-(lo+1)=hi-lo
    lo=0,hi=n-1
    area=Math.min(height[lo],height[hi])*(hi-lo)
    result=Math.max(result,area)
    因为取决于最小的那条边，所以从那条边开始，向中间找比他大的
     */
    public int maxArea(int[] height)
    {
        int n = height.length;
        int lo = 0, hi = n - 1;
        int result = 0;

        while (lo < hi)//lo==hi的话，只有一个，是没有面积的
        {
            if (height[lo] < height[hi])//左边的是短板
            {
                result = Math.max(result, height[lo] * (hi - lo));
                //lo向右边移动,且lo<hi,那么lo+1最多等于hi，不会越界
                int temp = height[lo];
                //FBI warning 只能和最初始的比，不能只和前一个比 必须强制往中心位移起码一次，不然会死循环！！
                while (lo < hi && height[++lo] <= temp);
            }
            else
            {
                result = Math.max(result, height[hi] * (hi - lo));
                int temp = height[hi];
                while(lo<hi && height[--hi]<=temp);
            }
        }
        return result;
    }
}
