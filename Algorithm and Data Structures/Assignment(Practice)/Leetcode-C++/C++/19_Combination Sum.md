```
给定一组候选数字（candidates）（没有重复）和目标数字（target），找到candidates 候选数字相加的所有唯一组合target。

的相同重复数目可以选自candidates 无限次数。

注意：

所有数字（包括target）都是正整数。
解决方案集不得包含重复的组合。
例1：

输入： candidate = [2,3,6,7], target = 7，
 解决方案集是：
[
  [7],
  [2,2,3]
]
例2：

输入：候选= [2,3,5] , 目标= 8，
 解集是：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
```

```c++
class Solution 
{
public:
	vector<vector<int> > combinationSum(vector<int> &candidates, int target) 
	{
		sort(candidates.begin(), candidates.end());
		vector<vector<int> > result;
		vector<int> vec;
		recursive(candidates, target, result, vec, 0);
		return result;
	}
private:
	void recursive(vector<int> &candidates, int target, vector<vector<int>> &result, vector<int> &vec, int lo) 
	{
		if (target==0) //==0正好找到
		{
			result.push_back(vec);
			return;
		}
		for (int i = lo; i != candidates.size() && target >= candidates[i]; ++i) //点睛之笔
		{
			vec.push_back(candidates[i]);
			recursive(candidates, target - candidates[i], result, vec, i);//继续在[i,target]的范围里面找
			vec.pop_back();//消除对i增加的下一次查找产生的影响
		}
	}
};
```
