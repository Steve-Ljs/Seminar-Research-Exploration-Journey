```
有两个排序的数组nums1和nums2分别为m和n。

找到两个排序数组的中位数。总运行时间复杂度应为O（log（m + n））。

您可以假设nums1和nums2  不能都为空。

例1：

nums1 = [1,3]
nums2 = [2]

中位数是2.0
例2：

nums1 = [1,2]
nums2 = [3,4]

中位数为（2 + 3）/ 2 = 2.5
```

```
自己写的用i,j两个指针分别从两个数列往前走,但是把握不好走的距离,总是有小bug

```

```c++
//看了半天,终于理解了..中间一度想放弃
double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2)
	{
		//假设:  num2:  #2#3#    nums1:  #4#5#6#7#
		//不管是否有空vector,也不管单双都适用
		int N1 = nums1.size();
		int N2 = nums2.size();
		if (N1 < N2)
			return findMedianSortedArrays(nums2, nums1);//make sure nums2 is the shorter one
		int lo = 0, hi = N2 * 2;//共有2*N2+1个位置
		while (lo <= hi)//相当于二分法,寻找合适的切分位置
		{
			int mid2 = (lo + hi) / 2;//try cut 2
			int mid1 = N1 + N2 - mid2;
			//因为要保证切分完整体的左边元素等于右边元素,所以如果切了2,切1的位置就固定了
			//是否切的位置是vec的左边或者右边的#
			//如果切到元素身上,L,R都是该元素,对应关系可以通过列举列出来
			double L1 = (mid1 == 0) ? INT_MIN : nums1[(mid1 - 1) / 2];
			double L2 = (mid2 == 0) ? INT_MIN : nums2[(mid2 - 1) / 2];
			double R1 = (mid1 == N1 * 2) ? INT_MAX : nums1[(mid1) / 2];
			double R2 = (mid2 == N2 * 2) ? INT_MAX : nums2[(mid2) / 2];
			if (L1 > R2)//说明nums2切的地方小了,往右找,让nums2左右切的大一点
				lo = mid2 + 1;
			else if (L2 > R1)
				hi = mid2 - 1;
			else//L1<=R2&&L2<=R1  即切的缝正好夹着L1,R1,L2,R2
				return (max(L1, L2) + min(R1, R2)) / 2;
				//返回最贴近缝的两个数的中间值
		}
		return -1;
	}
  ```
