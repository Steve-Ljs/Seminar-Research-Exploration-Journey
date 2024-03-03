package demo51_100;

public class Demo58
{
    /*
    done,notDone代表当天偷钱/不偷钱获得的最大收入
    返回Math.max(done,notDone)
    转移方程:done[i]=nums[i]+notDone[i-1]
    notDone[i]=Math.max(done[i-1],notDone[i-1])
    
    初始值:done[0]=nums[0],notDone[0]=0

    空间优化:
        done,notDone
        返回Math.max(done,notDone)
        初始值:done=nums[0],notDone=0
        转移方程:
        int temp=done;
        done=nums[i]+notDone;
        notDone=Math.max(notDone,temp);
     */
    public int rob(int[] nums)
    {
        int N = nums.length;
        if(N==0) return 0;
        int done = nums[0], notDone = 0;
        for (int i = 1; i < N; i++)
        {
            int temp=done;
            done=nums[i]+notDone;
            notDone=Math.max(notDone,temp);
        }
        return Math.max(notDone, done);
    }
    public int rob1(int[] nums)
    {
        int N = nums.length;
        if(N==0) return 0;
        int[] done = new int[N];
        int[] notDone = new int[N];

        done[0] = nums[0];
        notDone[0] = 0;

        for (int i = 1; i < N; i++)
        {
            done[i] = nums[i] + notDone[i - 1];
            notDone[i] = Math.max(done[i - 1], notDone[i - 1]);
        }
        return Math.max(done[N - 1], notDone[N - 1]);
    }
}
