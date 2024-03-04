package demo01_50;

public class Demo17
{
    /*
    画图分析!
    关键是先定下target的位置
    不存在重复,那么lo与hi对应的值不会相等(lo!=hi)时
     */
    public int search(int[] nums, int target)
    {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;

            if (target >= nums[lo])//区分target在左上还是右下
            {
                if (nums[mid] > target) hi = mid - 1;
                else
                {
                    if (nums[mid] >= nums[lo]) lo = mid + 1;
                    else hi = mid - 1;
                }
            }
            else
            {
                if (nums[mid] < target) lo = mid + 1;
                else
                {
                    if (nums[mid] >= nums[lo]) lo = mid + 1;
                    else hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
