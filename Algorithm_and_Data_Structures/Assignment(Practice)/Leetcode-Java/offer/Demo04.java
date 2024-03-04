package offer;

public class Demo04 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0) return false;
        int i = 0, j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            if (array[i][j] < target) {
                i++;
            }
            else if (array[i][j] > target) {
                j--;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Demo04().Find(0, null);
    }
}
