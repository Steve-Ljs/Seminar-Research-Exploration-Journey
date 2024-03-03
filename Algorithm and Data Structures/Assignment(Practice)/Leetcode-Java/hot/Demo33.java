package hot;

public class Demo33
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

            if (target > nums[hi])//target在数组切分后的左边
            {
                if(nums[mid] < target && nums[mid] > nums[lo]) lo = mid + 1;
                else hi = mid - 1;
            }
            else//在右边
            {
                //look 要考虑是纯递增的情况
                if(nums[mid] > target && nums[mid] < nums[hi]) hi = mid - 1;
                else lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(new Demo33().search(nums, 0));

    }
}
