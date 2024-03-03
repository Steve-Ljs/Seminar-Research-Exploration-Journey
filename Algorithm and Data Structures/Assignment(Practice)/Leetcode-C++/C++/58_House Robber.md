```
你是一个专业的强盗，计划在街上抢劫房屋。每个房子都有一定数量的钱存在，阻止你抢劫他们的唯一限制是相邻的房屋有连接的安全系统，如果两个相邻的房子在同一个晚上被打破，它将自动联系警察。

给出一个代表每个房子的金额的非负整数列表，确定今晚可以抢劫的最大金额而不警告警察。
Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
```

```c++
class Solution
{
public:
	int rob(vector<int>& nums)
	{
		if (nums.empty()) return 0;
		if (nums.size() == 1) return nums[0];
		int first = nums[0], second = nums[1];
		int result = max(first, second);
		for (int i = 2; i != nums.size(); ++i)
		{
			int temp = second;
			second = first + nums[i];
			first = max(first,temp);
			result = max(result, second);
		}
		return result;
	}
};
```
