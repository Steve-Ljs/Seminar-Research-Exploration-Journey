```
你正在爬楼梯。它需要n步才能达到顶峰。

每次你可以爬1或2步。您可以通过多少不同的方式登顶？

注意：给定n将是一个正整数。

例1：

输入： 2
 输出： 2
 说明：有两种方法可以爬到顶部。
1. 1步+ 1步
2. 2步
例2：

输入： 3
 输出： 3
 说明：有三种方法可以爬到顶部。
1. 1步+ 1步+ 1步
2. 1步+2步
3. 2步+ 1步
```

```c++
class Solution 
{
public:
	int climbStairs(int n) //实际上就是Fibonacci数列
	{
		if (n == 1) return 1;
		int first = 1,second = 2;
		for (int i = 3; i <= n; ++i) 
		{
			int third = first + second;
			first = second;
			second = third;
		}
		return second;
	}
};
```
