package niuke;

public class JZ46 {
    /*
    反推出最后剩下那个元素在原数组中的位置
    初始：0,1,2,3,4
    第一轮：3,4,0,1
    第二轮：1,3,4
    第三轮：1,3
    第四轮：3

    每一轮相当于把最后那个元素向前移动m位

    一共要反推n-1轮
    最后一轮位置为0
    倒数第二轮位置为index: index向前位移m位到0,数组大小为2: (index - m) % 2
    反过来想，就是原本位置 （i + m） % 2 = index
    */
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0) return -1;
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            index = (index + m) % (2 + i);
        }
        return index;
    }
}
