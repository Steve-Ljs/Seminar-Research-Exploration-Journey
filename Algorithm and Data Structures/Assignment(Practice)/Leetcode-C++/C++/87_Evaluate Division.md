```
Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].
The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
According to the example above:
equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
```

```c++
#include<iostream>
#include<string>
#include<vector>
#include<unordered_map>
#include<unordered_set>

using namespace std;

//相当于一棵树，例如查找c/a,则c在顶部，逐渐向下找，先找到了b，且乘一个相应的数，再由b找到a，从而得到c/a的关系
class Solution 
{
private:
	unordered_map<string, vector<pair<string, double>>> graph;

	pair<bool, double> dfs(string& target, string& current, unordered_set<string>& visited, double value) 
	{
		//防止循环，例如a-b-a重复循环
		if (visited.count(current) > 0)
			return make_pair(false, -1.0);

		visited.insert(current);

		/*
		假设a:(b,2),(d,3)
		b:(a,0.5),(c,3)
		c:(b,0.33)
		假设找a,c
		*/
		for (auto& next : graph[current]) 
		{
			double temp = value * next.second;
			if (next.first == target) 
				return make_pair(true, temp);
			//以b为头部，继续找c，且值累计为了2
			auto result = dfs(target, next.first, visited, temp);
			if (result.first) 
				return result;
		}
		//x/x或者x/a的情况
		return make_pair(false, -1.0);
	}
public:
	vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) 
	{
		vector<double> result;
		if (equations.empty()) return result;

		for (int i = 0; i < equations.size(); ++i) 
		{
			graph[equations[i][0]].push_back(make_pair(equations[i][1], values[i]));
			graph[equations[i][1]].push_back(make_pair(equations[i][0], 1.0 / values[i]));
		}

		// dfs
		for (auto& query : queries) 
		{
			//visited在每次进来时都是空，只是为了在dfs里面起作用
			unordered_set<string> visited;
			//1.0是为了对刚刚进去的没有干扰 
			auto temp = dfs(query[1], query[0], visited, 1.0);
			if (query[0] == query[1] && graph.find(query[0]) == graph.end())
			{
				result.push_back(1.0);
			}
			else
			{
				result.push_back(temp.second);
			}
		}
		return result;
	}
};

int main()
{
	vector<vector<string>> equations = { {"a","b"},{"b","c"} };
	vector<double> values = { 2,3 };
	vector<vector<string>> queries = { {"a", "c"},{"b", "a"},{"a", "e"},{"a", "a"},{"x", "x"} };
	Solution s;
	vector<double>result=s.calcEquation(equations, values, queries);
	for (auto i : result)
	{
		cout << i << " ";
	}
}
```


