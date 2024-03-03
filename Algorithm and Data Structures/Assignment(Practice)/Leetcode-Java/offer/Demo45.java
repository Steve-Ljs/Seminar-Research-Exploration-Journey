package offer;

public class Demo45 {
    /*
    设两个字符串x,y拼接成的数字大小是[xy]
    定义一个比较规则,若[xy]>[yx],则认为x>y
    所以我们按该排序规则对整个数组排序即可

    */
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        quickSort(strings, 0, strings.length - 1);
        StringBuilder result = new StringBuilder();
        for (String s : strings) {
            result.append(s);
        }
        return result.toString();
    }

    private void quickSort(String[] strings, int lo, int hi) {
        while (lo >= hi) return;
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && (strings[lo] + strings[i]).compareTo(strings[i] + strings[lo]) > 0) ;
            while (--j >= lo && (strings[lo] + strings[j]).compareTo(strings[j] + strings[lo]) < 0) ;
            if (i >= j) break;
            String temp = strings[j];
            strings[j] = strings[i];
            strings[i] = temp;
        }
        String tmp = strings[lo];
        strings[lo] = strings[j];
        strings[j] = tmp;
        quickSort(strings, lo, j - 1);
        quickSort(strings, j + 1, hi);
    }
}
