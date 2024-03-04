package demo51_100;

public class Demo91
{
    /*
    一行代码
    bitCount实现的功能是计算一个int类型的数值在二进制下“1”的数量。
    x^y代表的是x异或y,此时如果他们二进制不同,则那个二进制位为1
    然后用bitCount计算1的数量,叼
    public int hammingDistance(int x, int y)
    {
        return Integer.bitCount(x ^ y);
    }
     */
    public int hammingDistance(int x, int y)
    {
        if(x<y)
        {
            int temp = x;
            x = y;
            y = temp;
        }
        String binaryStringX = Integer.toBinaryString(x);
        String binaryStringY = Integer.toBinaryString(y);
        int less = binaryStringX.length() - binaryStringY.length();
        StringBuilder lessString = new StringBuilder();
        for (int i = 0; i < less; i++)
        {
            lessString.append("0");
        }
        binaryStringY = lessString.toString() + binaryStringY;

        int result = 0;
        for (int i = 0; i < binaryStringX.length(); i++)
        {
            if(binaryStringX.charAt(i)!=binaryStringY.charAt(i))
                ++result;
        }

        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(3^4);
    }
}
