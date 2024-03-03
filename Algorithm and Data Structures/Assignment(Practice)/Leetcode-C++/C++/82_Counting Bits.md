```
Given a non negative integer number num. 
For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:
Input: 2
Output: [0,1,1]

Example 2:
Input: 5
Output: [0,1,1,2,1,2]
意思是,5由0,1,2,3,4,5组成,他们的二进制的1的个数分别是[0,1,1,2,1,2]
Follow up:
It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
```
```c++
class Solution 
{
public:
	vector<int> countBits(int num) 
	{
		vector<int> result(num + 1, 0);
		for (int i = 1; i <= num; ++i)
			result[i] = result[i & (i - 1)] + 1;
		//例如：i = 14，其二进制表示为1110，因此i-1为1101，i＆（i-1）= 1100，其二进制表示中的“1”数减1,所以1100代表的'1'数再加1即可
		//例如：i = 15，其二进制表示为1111，因此i-1为1110，i＆（i-1）= 1110，其二进制表示中的“1”数减1,所以1110代表的'1'数再加1即可
		return result;
	}
};
```
