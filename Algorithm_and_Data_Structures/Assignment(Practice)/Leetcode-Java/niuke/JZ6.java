package niuke;

public class JZ6 {
    /*
    不断逼近直到lo=hi，此时达到最小值
    */
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        int lo = 0, hi = array.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            //说明在旋转的左边
            if (array[mid] > array[hi]) {
                lo = mid + 1;
            }
            /*else if (array[mid] < array[hi]) {
                hi = mid;
            }*/
            else {
                hi = mid;
            }
        }
        return array[hi];
    }
}
