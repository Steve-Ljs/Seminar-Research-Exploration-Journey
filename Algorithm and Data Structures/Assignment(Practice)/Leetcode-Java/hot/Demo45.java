package hot;

import java.util.LinkedList;
import java.util.List;

public class Demo45
{
    /*
    这里没有说是按照数字大小的顺序,只要排序没有重复即可
    而这里的直接按照初始的数字顺利得到全排列 例如:7,6,8,1
    这里第一个是7,6,8,1
    而下面那个是,1,6,7,8
    */
    private List<List<Integer>> result = new LinkedList<>();
    private List<Integer> temp = new LinkedList<>();
    private boolean[] marked;
    public List<List<Integer>> permute(int[] nums)
    {
        marked = new boolean[nums.length];
        recursive(nums,0);
        return result;
    }

    private void recursive(int[] nums,int length)
    {
        if(length==nums.length)
        {
            result.add(new LinkedList<>(temp));//防止引用问题
            return;//终止循环
        }
        for (int i = 0; i < nums.length; i++)
        {
            //用一个标记数组更加快
//            if(!temp.contains(nums[i]))//避免重复的
//            {
//                temp.add(nums[i]);
//                recursive(nums,length+1);
//                temp.remove(temp.size()-1);
//            }

            if(!marked[i])
            {
                temp.add(nums[i]);
                marked[i] = true;
                recursive(nums,length+1);
                marked[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
