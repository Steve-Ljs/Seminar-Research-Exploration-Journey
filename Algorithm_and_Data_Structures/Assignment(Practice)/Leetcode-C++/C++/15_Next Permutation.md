```
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
```

```c++
class Solution 
{
public:
    void nextPermutation(vector<int>& nums) 
    {
    	int n = nums.size(), k, l;
    	for (k = n - 2; k >= 0; k--) 
      {
            if (nums[k] < nums[k + 1]) 
            {
                break;
            }
        }
    	if (k < 0) 
      {
    	    reverse(nums.begin(), nums.end());
    	} else 
      {
    	    for (l = n - 1; l > k; l--) 
          {
                if (nums[l] > nums[k]) 
                {
                    break;
                }
            } 
    	    swap(nums[k], nums[l]);
    	    reverse(nums.begin() + k + 1, nums.end());
        }
    }
}; 
```
