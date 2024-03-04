package offer;

public class Demo17 {
    public int[] printNumbers(int n) {
        if (n <= 0) return new int[0];
        int [] result = new int[(int)Math.pow(10,n) - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
