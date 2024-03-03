package demo01_50;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo21_look
{
    /*
    用回溯算法更快
    给定一个 没有重复 数字的序列，返回其所有可能的全排列。
    这里没有说是按照数字大小的顺序,只要排序没有重复即可
    而这里的直接按照初始的数字顺利得到全排列 例如:7,6,8,1
    这里第一个是7,6,8,1
    而下面那个是,1,6,7,8
     */
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        boolean[] marked = new boolean[nums.length];

        recursive(nums,result,temp,marked);

        return result;
    }

    private void recursive(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] marked)
    {
        if(temp.size()==nums.length)
        {
            result.add(new LinkedList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if(!marked[i])
            {
                marked[i] = true;
                temp.add(nums[i]);
                recursive(nums,result,temp,marked);
                temp.remove(temp.size() - 1);
                marked[i] = false;
            }
        }
    }


    /*
    太慢了

    慢的原因是初始必须要求是一个有序的数组
    需要排序一遍(为了确保最后为逆序)

    既然之前写过找下一个排列,就用他把
    直到逆序就返回
     */
    public List<List<Integer>> permute1(int[] nums)
    {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length == 0) return result;

        Arrays.sort(nums);

        //先实现找下一个排序
        while (true)
        {
            //int [] 转List<Integer>
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            int i;
            for (i = nums.length - 2; i >= 0; --i)
            {
                if (nums[i] < nums[i + 1]) break;//必须严格小于,况且题目说没有重复
            }
            if (i == -1)//说明是逆序 只有一个元素时,也是逆序的,也进入了这里
            {
                break;//FBI warning,注意逆序也得先加入了,再检测,所以这里不用重新加入
            }
            for (int j = nums.length - 1; j >= 0; --j)//注意最后一个元素也要计算在内
            {
                if (nums[j] > nums[i])
                {
                    swap(nums, i, j);

                    for (int k = 0; k < (nums.length - i - 1) / 2; k++)
                    {
                        swap(nums, i + 1 + k, nums.length - 1 - k);
                    }
                    break;
                }
            }
        }
        return result;
    }

    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args)
    {
        List<List<Integer>> result = new Demo21_look().permute(new int[]{3,4,6,7,1,2});
        for (List<Integer> list : result)
        {
            for (Integer integer : list)
            {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
