package demo01_50;

public class Demo18
{
    public int[] searchRange(int[] nums, int target)
    {
        int lo = 0, hi = nums.length - 1;
        while(lo<=hi)
        {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid]<target) lo = mid + 1;
            else if(nums[mid]>target) hi = mid - 1;
            else
            {
                int left=mid,right=mid;
                while(left-1>=0 && nums[left]==nums[left-1]) --left;
                while(right+1<nums.length && nums[right]==nums[right+1]) ++right;
                return new int[]{left, right};
            }
        }
        return new int[]{-1, -1};
    }

}
