package hot;

public class Demo11
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
            result = Math.max(result, (hi - lo) * Math.min(height[lo], height[hi]));
            if (height[lo] > height[hi]) //右边是短板
            {
                //因为底不断变小,所以高小于支柱的可以都淘汰
                int temp = height[hi];
                //必须先强制-1,不然可能死循环 高相等的总面积也小
                //不会越界,最多减小到lo
                while (--hi>lo && height[hi]<=temp);
            }
            else
            {
                int temp = height[lo];
                while(++lo<hi && height[lo]<=temp);
            }

        }
        return result;
    }
}
