package offer;

public class Demo11 {
    public int minArray(int[] array) {
        if (array.length == 0) return 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return array[i];
            }
        }
        return array[0];
    }

    public int minNumberInRotateArray1(int[] array) {
        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {
            //只缩小到了最后一个,肯定是最小的
            if (lo == hi) return array[lo];

            //只能拿hi判断,如果拿lo判断,当array[mid] > array[lo]时,不懂往左边还是右边收缩
            int mid = lo + (hi - lo) / 2;
            if (array[mid] > array[hi]) {
                lo = mid + 1;
            }
            else {
                //mid有可能是最小的
                hi = mid;
            }
        }
        return 0;
    }
}
