package niuke;

public class JZ40 {

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            k ^= array[i];
        }
        //k最后为那两个不同数字异或的结构，必然有至少一位为1，不然那两个数字相同的
        //找到这个位置
        int mask = 1;
        while ((k & mask) == 0) {
            mask <<= 1;
        }

        //根据这个mask分成两个数组
        int a = 0, b = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & mask) == 0) {
                a ^= array[i];
            } else {
                b ^= array[i];
            }
        }
        num1[0] = a;
        num2[0] = b;
    }
}
