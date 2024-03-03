package niuke;

public class JZ35 {
    private int result = 0;
    private int[] aux;

    public int InversePairs(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
        return result;
    }

    public void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, hi, mid);
    }

    public void merge(int[] a, int lo, int hi, int mid) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) aux[k] = a[k];

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                /*
                只有后面的数组要越过前面的数组时才会产生逆序对，此时左边数组还剩下的是[i,mid]个元素，如果越过到前方
                放入右边的数组，那么产生的逆序对数是mid - i + 1个
                 */
                a[k] = aux[j++];
                result = (result + mid - i + 1) % 1000000007;
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
