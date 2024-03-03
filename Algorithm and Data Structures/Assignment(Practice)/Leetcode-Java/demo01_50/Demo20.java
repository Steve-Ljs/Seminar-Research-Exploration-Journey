package demo01_50;


public class Demo20
{
    /*
    一个位置能接的雨水数量是Math.min(leftMax,rightMax)-height[i]
     */
    public int trap(int[] height)
    {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int result = 0;
        for (int i = 1; i < n; i++)
        {
            leftMax[i] = Math.max(leftMax[i - 1], height[i-1]);
        }
        for (int i = n-2; i >=0 ; --i)
        {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        for (int i = 0; i < n; i++)
        {
            int temp = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(temp>0) result += temp;//FBI warning
        }
        return result;
    }
}
