package hot;

public class Demo300 {
    /*
        dp[i]代表前i个的最大递增子数列数量
        转移状态方程:
        for j in [0,i)
            if (nums[i]>nums[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
        排除掉了前面比他大的那些.从中选取一条最长递增序列
        初始值:dp[i]=1,因为每个都构成序列为1的子数列
        返回值:途中的最大的一个,因为可能类似1 3 4 9 2 1的情况,最长递增子序列在中间
        */
        /*int result = 0;
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;*/

    /*
    时间复杂度 O(N logN):遍历 nums 列表需 O(N)
    在每个 nums[i]二分法需 O(logN)
    空间复杂度 O(N): tails 列表占用线性大小额外空间。

    result为当前tails的长度,代表直到当前的最长上升子序列长度
    每轮二分tails[0,result)找出该序列应该放入的位置
     */
    public int lengthOfLIS(int[] nums) {
        //tails[k]的值代表长度为 k+1的子序列尾部元素的值。
        /*注意,tails中并不一定是最小子序列,区分他的含义!
        如:[2,5,9,18,7]
        tails最后是:[2,5,7,18]
        7仅仅代表了,如果是长度为3的子序列尾部元素的值是7 !

         */
        //[10,9,2,5,3,7,101,18]
        int[] tails = new int[nums.length];
        int result = 0;
        //对数组中元素挨个判断,把他们最小的都放入tails中
        for (int num : nums) {
            int lo = 0, hi = result;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (tails[mid] < num) lo = mid + 1;
                else hi = mid;
            }
            tails[lo] = num;
            if (result == hi) result++;
        }
        return result;
    }
}
