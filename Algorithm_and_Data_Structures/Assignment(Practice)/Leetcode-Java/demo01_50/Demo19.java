package demo01_50;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo19
{
    /*
    大于他的数组直接停止
    等于他的加入该元素也停止,因为都是正整数

     */
    private List<List<Integer>> result = new LinkedList<>();
    private List<Integer> temp = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        recursive(candidates,target,0);
        return result;
    }

    private void recursive(int[] candidates, int target, int begin)
    {
        if (target == 0)
        {
            result.add(List.copyOf(temp));//FBI warning
            return;
        }
        for (int i = begin; i < candidates.length; i++)
        {
            if (candidates[i] > target) break;
            else
            {
                temp.add(candidates[i]);
                recursive(candidates, target - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args)
    {
        new Demo19().combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
