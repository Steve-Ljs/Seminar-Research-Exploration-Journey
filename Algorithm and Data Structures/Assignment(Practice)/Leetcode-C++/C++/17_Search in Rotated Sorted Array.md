```
假设按升序排序的数组在事先未知的某个枢轴处旋转。

（也就是说，[0,1,2,4,5,6,7]可能会成为[4,5,6,7,0,1,2]）。

您将获得要搜索的目标值。如果在数组中找到则返回其索引，否则返回-1。

您可以假设数组中不存在重复。

算法的运行时复杂度必须为  O（log  n）。

例1：

输入： nums = [ 4,5,6,7,0,1,2]，target = 0
 输出： 4
例2：

输入： nums = [ 4,5,6,7,0,1,2]，target = 3
 输出： -1
 ```
 
 ```c++
 class Solution
{
public:
	int search(vector<int>& nums, int target)
	{
		int lo = 0, hi = nums.size() - 1;
		while (lo <= hi)//=仅仅为了防止nums.size()==1的情况
		{
			if (nums[lo] == target) return lo;
			if (nums[hi] == target) return hi;
			int mid = lo + (hi - lo)/ 2;
			if (nums[mid] < target)
			{
				if (nums[mid] < nums[hi] && nums[hi] > target) lo = mid + 1;
				else if (nums[lo] < nums[mid]) lo = mid + 1;
				else hi = mid-1;
			}
			else if (nums[mid] > target)
			{
				if (nums[lo] < nums[mid] && nums[lo] < target) hi = mid-1;
				else if (nums[hi] > nums[mid]) hi = mid-1;
				else lo = mid + 1;
			}
			else 
				return mid;
		}
		return -1;
	}
};
```
