package niuke;

public class JZ9 {
    public int JumpFloorII(int target) {
        if (target < 1) throw new RuntimeException("输入参数不合法！");
        if (target == 1 || target == 2) return target;
        int pre = 2, result = 0;
        for (int i = 3; i <= target; i++) {
            result = pre * 2;
            pre = result;
        }
        return result;
    }
}
