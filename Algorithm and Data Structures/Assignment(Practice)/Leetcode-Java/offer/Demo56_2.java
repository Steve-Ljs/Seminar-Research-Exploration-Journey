package offer;

public class Demo56_2 {
    /*
    所有位加起来,能被3整除
    而单独的加入,不能被三整除的位置为1
    */
    public int singleNumber(int[] nums) {
        //java int类型有32位，其中首位为符号位
        int[] counts = new int[32];
        for (int num : nums) {
            int bitMask = 1;
            for (int i = 0; i < 32; i++) {
                if ((num & bitMask) != 0) counts[i]++;
                bitMask = bitMask << 1;
            }
        }
        //恢复到res上
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            //counts[31 - i] % 3只可能是0或1,因为只有一个是不同的
            // |=是保障res其他的地方仍然正确
            res |= counts[31 - i] % 3;
        }
        return res;
    }
}
