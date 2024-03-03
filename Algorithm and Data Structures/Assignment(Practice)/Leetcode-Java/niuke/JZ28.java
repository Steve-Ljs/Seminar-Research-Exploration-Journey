package niuke;

public class JZ28 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) return 0;
        int result = array[0];
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                count = 1;
                result = array[i];
            } else {
                if (array[i] == result) {
                    count++;
                } else {
                    --count;
                }
            }
        }
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) ++count;
            if (count > array.length / 2) return result;
        }
        return 0;
    }
}
