package niuke;

public class JZ48 {
    /*
    二进制进位法
    carry为num1,num2的进位和,cur为num1,num2的非进位和
    carry = (num1 & num2) << 1;
    cur = (num1 ^ num2);
    num1 + num2 = carry + cur
    因为carry会不断左移，最多32次carry一定变为0,此时cur即为结果
    */
    //num1代表carry, num2代表cur
    public int Add(int num1, int num2) {
        while (num1 != 0) {
            int temp = num1;
            num1 = (num1 & num2) << 1;
            num2 = temp ^ num2;
        }
        return num2;
    }
}
