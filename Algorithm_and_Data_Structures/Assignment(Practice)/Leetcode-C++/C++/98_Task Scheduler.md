```
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
You need to return the least number of intervals the CPU will take to finish all the given tasks.
 
Example:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 
Note:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
```

```c++
#include<unordered_map>
#include<vector>
#include<algorithm>
#include<iostream>

using namespace std;

class Solution {
public:
	int leastInterval(vector<char>& tasks, int n) 
	{
		unordered_map<char, int>mp;
		int count = 0;
		for (auto e : tasks)
		{
			++mp[e];
			count = max(count, mp[e]);
		}
		//BCA/BCA/BC 最多的减去1个循环，每个循环大小为n+1
		int result = (count - 1) * (n + 1);
		//加上最多的那个
		for (auto e : mp)
		{
			if (e.second == count)
			{
				++result;
			}
		}
		return max((int)tasks.size(), result);
	}
};

int main()
{
	vector<char>tasks = { 'A','A','B','B','B','C','C','C' };
	int n = 3;
	Solution s;
	int result=s.leastInterval(tasks, n);
	cout << result;//10
	//BCA/BCA/BC
}
```
