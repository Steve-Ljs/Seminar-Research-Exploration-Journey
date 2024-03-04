package offer;

public class Demo65 {
    /*
    数值一律用补码来表示和存储。
    补码的优势： 加法、减法可以统一处理（CPU只有加法器）。
    因此，以上方法同时适用于正数和负数的加法。


    令c为(a + b)的进位和，则c = (a & b) << 1
    令n为(a + b)的非进位和，则n = (a ^ b)
    a + b = n + c

    例如：7+14
    0111
    1110

    c = 01100
    n = 01001

    c = 10000
    n = 00101

    c = 00000
    n = 10101

    res = 21

    时间复杂度：O(1) 最坏也就32次
    */
    public int add(int a, int b) {
        //b其实就代表了c，如果没有了进位，则计算结束
        while (b != 0) {
            int temp = b;//因为下面改变了b
            //计算(a + b)的进位和，并且存储在b中
            b = (a & b) << 1;
            //计算(a + b)的非进位和
            a = a ^ temp;
        }
        return a;
    }
}
