package hot;

public class Demo04
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int m = nums1.length, n = nums2.length;
        //只选取小的切分 所以取反,look 直接return,而不是调用
        if (m > n) return findMedianSortedArrays(nums2, nums1);

        int L1, R1, L2, R2;//切割元素左右两边的值
        int mid1, mid2;
        //逻辑上扩充成2*n+1,但是最后一个元素还要-1
        int lo = 0, hi = 2 * m;

        while (lo<=hi)
        {
            mid1 = lo + (hi - lo) / 2;
            mid2 = m + n - mid1;//计算得到
            //计算切分元素两边的值
            //look 首先判断条件是2*m,扩充后的数组
            //且L1,L2为值,不是索引,所以是nums1[(mid1 - 1) / 2]而不是(mid1 - 1) / 2
            L1 = (mid1 == 0 ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2]);
            R1 = (mid1 == 2*m ? Integer.MAX_VALUE : nums1[mid1 / 2]);
            L2 = (mid2 == 0 ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2]);
            R2 = (mid2 == 2*n ? Integer.MAX_VALUE : nums2[mid2 / 2]);

            if(L1 > R2) hi = mid1 - 1;
            else if(L2 > R1) lo = mid1 + 1;
            else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;//look 注意运算优先级
        }
        return -1.0;
    }
}
