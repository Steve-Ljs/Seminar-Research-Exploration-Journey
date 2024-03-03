```
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
```

```c++
class Solution 
{
public:
	vector<int> maxSlidingWindow(vector<int>& nums, int k) 
	{

		vector <int> result;
		if (nums.size() == 0) return result;
		deque <int> dq; //deque双向队列是一种双向开口的连续线性空间，可以高效的在头尾两端插入和删除元素
		int i;
		//保证最大的在前面,且deque后面还存着索引大于最大的,值第二大的 ,索引大于第二大的,值第三大的...
		for (i = 0; i != k; ++i) //5 4 6 3 5   结果:6 5
		{
			while (!dq.empty() && nums[i] >= nums[dq.back()])
				dq.pop_back();
			dq.push_back(i);//存索引
		}
		//i=k,从开始的窗口的下一个开始
		for (; i !=nums.size(); ++i)
		{
			result.push_back(nums[dq.front()]);//如刚进来,存的是第一个窗口的最大值
			while (!dq.empty() && dq.front() <= i - k)//窗口向前移动的时候,如果最大值的索引在窗口外面,则把最大值弹开
				dq.pop_front();
			while (!dq.empty() && nums[i] >= nums[dq.back()])
				dq.pop_back();
			dq.push_back(i);
		}
		result.push_back(nums[dq.front()]);
		return result;
	}
};
```
