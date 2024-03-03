package niuke;

public class JZ50 {
    /*
    所有数字都在0到n-1的范围内，所以可以直接把该数字放在他的索引位置上
    不断判断，直到找到重复的元素

    如果i所在的元素值为i，则i++
    如果i所在的元素值小于0，或者大于等于n，抛出异常
    如果i所在的元素值val与numbers[val]相同，则重复
    否则交换两个元素值，且i不变，继续判断
*/
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                int val = numbers[i];
                if (val == numbers[val]) {
                    duplication[0] = val;
                    return true;
                } else {
                    numbers[i] = numbers[val];
                    numbers[val] = val;
                }
            }
            //因为和必须返回第一个重复的数字 玄学问题，第一个应该是解决不掉的
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new JZ50().duplicate(new int[]{6, 3, 2, 0, 2, 5, 0}, 7, new int[1]));
    }
}
