package hot;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo39
{
    private List<Integer> temp = new LinkedList<>();
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        recursive(candidates, target,0);
        return result;
    }
    void recursive(int[] candidates,int target,int begin)
    {
        if(target==0)
        {
            result.add(new LinkedList<>(temp));//look 这里有引用问题,应该是复制一个新的给result
            return;
        }
        for (int i = begin; i < candidates.length; i++)
        {
            if(candidates[i]>target) return;//剪枝条件
            //look 注意越界问题

            //可优化成开始条件
            //if(!temp.isEmpty() && candidates[i]<temp.get(temp.size()-1)) continue;//剪枝条件 避免重复

            temp.add(candidates[i]);//look 不需要sum
            recursive(candidates,target-candidates[i],i);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args)
    {
        List<List<Integer>> lists = new Demo39().combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : lists)
        {
            for (Integer integer : list)
            {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
