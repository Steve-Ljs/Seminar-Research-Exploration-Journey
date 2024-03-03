```
给定包含n + 1个整数的数组nums，其中每个整数在1和n之间（包括1和n），证明必须存在至少一个重复的数字。假设只有一个重复的数字，找到重复的数字。

例1：

输入： [1,3,4,2,2]
输出： 2
例2：

输入： [3,1,3,4,2]
 输出： 3
注意：

您不能修改数组（假设该数组是只读的）。
您必须仅使用常量O（1）额外空间。
您的运行时复杂度应小于O（n 2）。
数组中只有一个重复的数字，但它可以重复多次。
```

```c++
class Solution 
{
public:
	int findDuplicate(vector<int>& nums)
	{
		int slow = 0;
		int fast = 0;
		//[3,1,3,4,2] 想象成链表 3->4->2->3
		//因为只有一个重复元素,所以不管怎样都会走入一个包含重复元素的圆圈
		while (true)
		{
			slow = nums[slow];//slow一步步走,3-4-2-3
			fast = nums[nums[fast]];//fast跨两步
			if (slow == fast) break;
		}
		fast = 0;//和之前那题一样,从链表开头走到两者相遇时,即到了链表开头,即重复元素处
		while (fast != slow)
		{
			fast = nums[fast];
			slow = nums[slow];
		}
		return slow;
	}
};
```
