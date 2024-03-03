package niuke;

public class JZ13 {
    /*
    和力扣的略有不同
    插入排序
*/
    public void reOrderArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                for (int j = i; j - 1 >= 0 && (array[j - 1] & 1) == 0; j--) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
