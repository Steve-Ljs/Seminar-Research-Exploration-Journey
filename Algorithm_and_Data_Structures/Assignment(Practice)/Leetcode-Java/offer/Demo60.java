package offer;

public class Demo60 {
    /*
    n个骰子同时掷出，题目要我们求每个点数的概率组成的数组
    可以把n个骰子的点数分解为n-1个骰子的点数加上一个骰子的点数。
    假设n=2。
    则我们已知1的点数概率数组为{1/6d,1/6d,1/6d,1/6d,1/6d,1/6d}
    我们要求的2个骰子，可以分解为n-1个骰子和1个骰子
    同时易知2个骰子的点数概率数组长度为2*5+1。


    */
    public double[] dicesProbability(int n) {
        //初始化，1个骰子的点数概率数组
        double res[] = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
        //一共投n个骰子
        for (int i = 2; i <= n; i++) {
            //假设投了n个骰子，点数就是[n,6n],总共 5n + 1
            //temp即此刻的概率分布
            double temp[] = new double[5 * i + 1];

            //在旧的概率基础上，每个都有可能再抛出[1,6]
            //使得n-1点数概率数组和1点数概率数组元素两两相乘，并将乘积结果加到n点数概率数组上。
            for (int j = 0; j < res.length; j++)
                for (int k = 0; k < 6; k++)
                    temp[j + k] += res[j] / 6;

            //开始下一轮循环
            res = temp;
        }
        return res;
    }
}
