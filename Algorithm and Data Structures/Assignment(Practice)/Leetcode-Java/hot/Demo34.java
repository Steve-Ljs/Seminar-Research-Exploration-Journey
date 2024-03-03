package hot;

public class Demo34
{
    /*
    寻找左边界
    result的取值范围为[0,N],当target大于所有数组元素时,result取到了N
     */
    public int leftBound(int[] nums, int target)
    {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > target) hi = mid - 1;
            else if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1; //不直接返回,往左逼近
        }
        //只要找到了,lo是不会移动的
        if(lo==nums.length || nums[lo]!=target) return -1;
        return lo;
    }

    public int rightBound(int[] nums, int target)
    {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > target) hi = mid - 1;
            else if (nums[mid] < target) lo = mid + 1;
            else lo = mid + 1; //不直接返回,往右边逼近
        }
        //只要找到了,hi是不会移动的 hi取值为[-1,N)
        if(hi==-1 || nums[hi]!=target) return -1;
        return hi;
    }
    public int[] searchRange(int[] nums, int target)
    {
        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }

    /*
    最坏情况下会退化成O(N)
     */
    public int[] searchRange1(int[] nums, int target)
    {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target)
            {
                int left = mid, right = mid;
                while (left - 1 >= lo && nums[left - 1] == nums[mid]) --left;
                while (right + 1 <= hi && nums[right + 1] == nums[mid]) ++right;
                return new int[]{left, right};
            }
            else if (nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;

        }
        return new int[]{-1, -1};
    }
}
