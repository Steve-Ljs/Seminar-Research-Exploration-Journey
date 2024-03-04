package demo01_50;

import java.util.LinkedList;
import java.util.List;

public class Demo33
{
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> result = new LinkedList<>();
        recursive(nums, result, new LinkedList<>(),0);
        return result;
    }

    private void recursive(int[] nums, List<List<Integer>> result, LinkedList<Integer> temp,int begin)
    {
        result.add(new LinkedList<>(temp));//FBI warning

        for (int i = begin; i < nums.length; i++)
        {
            temp.add(nums[i]);
            recursive(nums,result,temp,i+1);//FBI warning begin为i+1,不是begin+1,因为1,3时,下一个应该是4
            temp.remove(temp.size()-1);
        }
    }
}
