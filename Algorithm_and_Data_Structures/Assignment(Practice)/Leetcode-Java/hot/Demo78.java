package hot;

import java.util.LinkedList;
import java.util.List;

public class Demo78
{
    //本质上就是模拟一个个元素不断加入集合的过程
    public List<List<Integer>> subsets1(int[] nums)
    {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());//刚开始为空集

        for (int i = 0; i < nums.length; i++)
        {
            //加入元素nums[i]所得到的额外的list
            List<List<Integer>> list = new LinkedList<>();
            for (List<Integer> e : result)//就是通过原本的每个集合都加入该元素
            {
                List<Integer> temp = new LinkedList<>(e);
                temp.add(nums[i]);
                list.add(temp);
            }
            result.addAll(list);
        }
        return result;
    }

    private List<Integer> temp = new LinkedList<>();
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums)
    {
        recursive(nums, 0);
        return result;
    }

    public void recursive(int[] nums, int start)
    {
        result.add(new LinkedList<>(temp));

        for (int i = start; i < nums.length; i++)
        {
            temp.add(nums[i]);
            recursive(nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
