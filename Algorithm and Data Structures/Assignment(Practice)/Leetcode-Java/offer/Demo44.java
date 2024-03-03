package offer;

public class Demo44 {
    /*
    先确定n所在的位数digit
    再确定n所在的数字num
    最后确定n是num中的哪一数位

      数字范围      位数          数位数量
    [start,end]    digit    9 * digit * start
    */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;

        //例如15
        while (n > count) {
            n -= count;
            ++digit;
            start *= 10;
            count = digit * start * 9;
        }
        //n = 6, start = 10, digit = 2
        //即从start = 10开始的第6数位
        //即处于数字12中
        long num = start + (n - 1) / digit;
        //处于12中的第1数位,即结果为2
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
