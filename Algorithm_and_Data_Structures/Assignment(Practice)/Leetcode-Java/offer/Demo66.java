package offer;

public class Demo66 {
    public int[] constructArr(int[] a) {
        if (a.length == 0) return new int[0];
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = a[i - 1] * left[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = a[i + 1] * right[i + 1];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
