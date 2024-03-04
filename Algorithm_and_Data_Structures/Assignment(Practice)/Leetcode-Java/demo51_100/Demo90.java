package demo51_100;

import java.util.*;

public class Demo90
{
    /* nums[nums[i] - 1] *= -1;
     * nums[i]是本来元素值,例如7,为了之后让i是否存在对应与nums[i-1]是否为负数
     * 所以让7存在对应与nums[6]为负数
     *
     * 问题是,如果出现两个7,那么nums[6]又为正,要避免
     * 还有就是,如果nums[6]本来为2,应该让nums[1]为负数,但此时nums[6]被
     * 整成了-2,所以计算时又要按正数
     * */
    public List<Integer> findDisappearedNumbers(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            int newIndex = Math.abs(nums[i]) - 1;
            if(nums[newIndex]>0) nums[newIndex] *= -1;
        }
        //最后转换为nums[i-1]为负数,代表i存在
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i <= nums.length; i++)
        {
            if(nums[i-1]>0) result.add(i);
        }
        return result;
    }
    /*
    O(N) O(N)
     */
    public List<Integer> findDisappearedNumbers2(int[] nums)
    {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
        {
            set.add(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++)
        {
            if(!set.contains(i))
                result.add(i);
        }
        return result;
    }

    /*
    辣鸡方法,修改了不下6此次,只比25%人快
     */
    public List<Integer> findDisappearedNumbers1(int[] nums)
    {
        List<Integer> result = new ArrayList<>();
        if(nums.length==0) return result;
        Arrays.sort(nums);

        for (int i = 1; i < nums[0]; i++)
        {
            result.add(i);
        }

        for (int i = 1; i < nums.length; i++)
        {
            if(nums[i]-nums[i-1]>1)
            {
                int temp = nums[i - 1]+1;
                while(temp!=nums[i])
                {
                    result.add(temp);
                    ++temp;
                }
            }
        }

        for (int i = nums[nums.length-1]+1; i <= nums.length; i++)
        {
            result.add(i);
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("AA");
        new Demo90().findDisappearedNumbers(nums);
    }
}
