```
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, calculate the Hamming distance.
Note:
0 ≤ x, y < 231. 
Example: 
Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
```

```c++
#include<iostream>
#include<string>
#include<vector>
#include<algorithm>

#include<unordered_map>

using std::vector;
using std::string;
using std::cout;
using std::cin;
using std::endl;

/*
因为要比较有多少bit是不同的，所以先^，不同的异或后都是1，然后循环弄出有多少个1

^:按位异或运算符，它对操作数中相应的位进行异或运算。
如果相应的位各不相同，例如一个位是1，另一个位是0，结果位就是1。如果相应的位相同，结果位就是0

Considering this example. Let's say n = 10101, and dist = 0 asccording to above code of @pengr7.

Before we go into the while loop. n = 10101, dist = 0
Loop 1. dist = 1, n =10101 & 10100 = 10100
Loop 2. dist = 2, n =10100 & 10011 = 10000
Loop 3. dist = 3, n =10000 & (0)1111 = 0
Loop ends. dist = 3

The change of n :

10101
10100
10000
00000

Conclusion: n & (n-1) converts the right most 1 to 0 .
This is the key idea solving the problem. 
By counting how many times we can perform this operation, 
we know how many 1 exists in the binary representation of n
*/
class Solution 
{
public:
	int hammingDistance(int x, int y) 
	{
		int dist = 0, n = x ^ y;
		while (n) 
		{
			++dist;
			n &= n - 1;
		}
		return dist;
	}
};
```
