package demo01_50;

public class Demo31
{
    /*
    三项快排的思想
     */
    public void sortColors(int[] nums)
    {
        if(nums==null || nums.length==0) return;

        int lo = 0, hi = nums.length - 1;//lo为第一个1的位置,hi为hi+1为2
        int i = 0;//i为遍历的位置
        while(i<=hi)//因为hi+1才为2,hi还需要判断的
        {
            if(nums[i]==0) exch(nums,i++,lo++);
            else if(nums[i]==1)  ++i;
            else  exch(nums,i,hi--);
        }
    }

    private void exch(int [] nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
