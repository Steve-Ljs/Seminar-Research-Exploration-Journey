```
假设您有一个随机列表的人员排队。每个人用一对整数来描述(h, k)，其中h是人的身高，k是这个人身高大于或等于的人数h。编写算法来重建队列。

注意：
人数不到1,100。


例

输入：
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出：
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
```

```c++
/*
思路：贪心。从队列中找到最大高度的人，那么将不会存在比它更高的人，按k从低到高排，就是他们在队列的相对顺序。
然后，将排好的人剔除，从剩余人的队列中，再找出最高的，直至队列为空。

输入：[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

第一步：[[7,0],[7,1]]

next：[[7,0],[6,1],[7,1]]

next：[[5,0][7,0][5,2],[6,1],[7,1]]

end：[[5,0][7,0][5,2],[6,1],[4,4],[7,1]]
*/
class Solution 
{
public:
	vector<pair<int, int>> reconstructQueue(vector<pair<int, int>>& people) 
	{
		sort(people.begin(), people.end(), 
			[](const pair<int, int> & a, const pair<int, int> & b) 
			{
				return a.first > b.first || (a.first == b.first && a.second < b.second);//为了避免一开始就插入后面的位置
			});
		//people://[[7,0], [7,1], [6,1] , [5,0] , [5,2] , [4,4]]
		vector<pair<int, int>> result;
		for (auto a : people) 
		{
			result.insert(result.begin() + a.second, a);
		}
		return result;
	}
};
```
