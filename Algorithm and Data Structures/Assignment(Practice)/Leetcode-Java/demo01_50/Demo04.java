package demo01_50;

public class Demo04
{
    /*
    时间复杂度为 O(log(m + n)) 基本都是用二分法
    割可以割在两个数中间，也可以割在1个数上，如果割在一个数上，那么这个数即属于左边，也属于右边
    一个数组割后,割的左边是LMax1,割的右边是RMin1
    LMax1<=RMin1，LMax2<=RMin2 因为数组是有序的，左边肯定小于右边
    而如果割(Cut)在某个数上，则左右相等。

    如果我们让LMax1<=RMin2，LMax2<=RMin1,左半边全小于右半边
    如果左边的元素个数相加刚好等于k, 那么第k个元素就是Max(LMax1, LMax2)，
    这个比较好理解的，因为Max(LMax1, LMax2)肯定是左边k个元素的最大值，
    因为合并后的数组是有序，第k个元素肯定前面k个元素中最大的那个。

    那么如果 LMax1>RMin2，说明数组1的左边元素太大，我们把C1减小，C2=k-C1也就相应的增大。
    LMax2>RMin1同理，把C2减小，C1=k-C2也就相应的增大。


    虚拟加入‘#’，我们让m转换成2m+1 ，n转换成2n+1, 两数之和就变成了2m+2n+2，恒为偶数。
    每个位置可以通过/2得到原来元素的位置
    而对于割(Cut)，如果割在‘#’上等于割在2个元素之间，割在数字上等于把数字划到2个部分
    LMaxi = (Ci-1)/2 位置上的元素
    RMini = Ci/2 位置上的元素
    当两个数组的左半边小于右半边时,选最逼近的两个Mid = (Max(LMax1,LMax2) + Min(RMin1,RMin2) )/2

    只要C1或C2确定，另外一个也就确定了。这里，为了效率，我们肯定是选长度较短的做二分
    LMax1>RMin2，把C1减小，C2增大。—> C1向左二分
    LMax2>RMin1，把C1增大，C2减小。—> C1向右二分

    如果C1或C2已经到头,说明有个数组完全小于或大于中值 4种情况:
    C1 == 0 —— 数组1整体都在右边了，所以都比中值大，中值在数组2中，
    简单的说就是数组1割后的左边是空了，所以我们可以假定LMax1 = INT_MIN
     */
    /*public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        if(nums1.length>nums2.length) return findMedianSortedArrays(nums2, nums1);//用短的来二分
        int LMax1 = 0,RMin1=0, LMax2 = 0, RMin2 = 0;//nums1的切分后的左边最大和右边最小
        int c1, c2;//切分nums1,nums2的割
        int lo = 0, hi = 2 * nums1.length;//因为要虚拟加#,变成2n+1

        while(lo<=hi)
        {
            c1 = lo + (hi - lo) / 2;
            c2 = nums1.length + nums2.length - c1;//这样c1与c2的左边才会刚刚有一半的元素

            LMax1 = c1 == 0 ? Integer.MIN_VALUE : nums1[(c1 - 1) / 2];
            RMin1 = c1 == 2 * nums1.length ? Integer.MAX_VALUE : nums1[c1 / 2];
            LMax2 = c2 == 0 ? Integer.MIN_VALUE : nums2[(c2 - 1) / 2];
            RMin2 = c2 == 2 * nums2.length ? Integer.MAX_VALUE : nums2[c2 / 2];

            if(LMax1>RMin2) hi = c1 - 1;
            else if(LMax2>RMin1) lo = c1 + 1;
            else break;
        }
        return (Math.max(LMax1, LMax2) + Math.min(RMin1, RMin2)) /2.0;
    }*/

    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int L1, R1, L2, R2;

        int lo = 0, hi = 2 * nums1.length;
        int mid1, mid2;

        while (lo <= hi)
        {
            mid1 = lo + (hi - lo) / 2;
            mid2 = nums2.length + nums1.length - mid1;

            L1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            R1 = mid1 == 2 * nums1.length ? Integer.MAX_VALUE : nums1[(mid1) / 2];
            L2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            R2 = mid2 == 2 * nums2.length ? Integer.MAX_VALUE : nums2[(mid2) / 2];

            if(L1>R2) hi = mid1 - 1;
            else if(L2>R1) lo = mid1 + 1;
            else return (Math.max(L1,L2)+Math.min(R1,R2))/2.0;
        }
        return -1.0;
    }
}
