```
Given an array of meeting time intervals consisting of start and end times  [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example, 
Given  [[0, 30],[5, 10],[15, 20]], 
return  2.
```


```c++
//LeetCode没有权限,所以没有在上面运行,应该是对的把
struct Interval 
{
    int start;
    int end;
    Interval() : start(0), end(0) {}
    Interval(int s, int e) : start(s), end(e) {}
};
 
//[[0, 30],[5, 10],[15, 20]]
class Solution 
{
public:
	int minMeetingRooms(vector<Interval>& intervals) 
	{
		map<int, int> inter_map;//按会议的时间排序 0 5 10 15 20 30
		for (auto val : intervals)
		{
			++inter_map[val.start];
			--inter_map[val.end];
		}
		int result = 0, sum = 0;
		for (auto val : inter_map)
		{
			sum += val.second;
			result = max(result, sum);
		}
		return result;
	}
};
int main()
{
	vector<Interval> intervals(3);
	intervals[0] = Interval(0, 30);
	intervals[1] = Interval(5, 10);
	intervals[2] = Interval(15, 20);
	Solution s;
	int result=s.minMeetingRooms(intervals);
	cout << result << endl;
}
```
