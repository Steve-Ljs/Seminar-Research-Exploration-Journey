package hot;

public class Demo75
{
    public void sortColors(int[] nums)
    {
        int lo=0,hi=nums.length-1;
        int i=0;
        while(i<=hi)
        {
            if(nums[i]==0)
            {
                //exch(nums,i++,lo++); 由于特殊性,化简
                nums[i++] = nums[lo];
                nums[lo++] = 0;
            }
            else if(nums[i]==1)
            {
                ++i;
            }
            else
            {
//                exch(nums,i,hi--);
                nums[i] = nums[hi];
                nums[hi--] = 2;
            }

        }
    }
}
