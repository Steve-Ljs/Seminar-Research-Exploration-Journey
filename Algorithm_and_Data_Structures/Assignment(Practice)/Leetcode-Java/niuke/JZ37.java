package niuke;

public class JZ37 {
    /*

    让二分搜索始终指向出现的位置+1
    验证一下发现没有出现的情况也适用
    */
    public int GetNumberOfK(int[] array, int k) {
        return binarySearchRight(array, k) - binarySearchRight(array, k - 1);
    }

    //不能使用这个是因为索引会因为是否出现该元素而受到影响
    //而下面那个能保证无论是否出现该元素，都是指向比该元素大一个的位置
    /*private int binarySearchLeft(int [] array , int target) {
        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] < target) {
                lo++;
            }
            else if (array[mid] > target) {
                hi--;
            }
            else {
                //这里是要找的值，但是不一定是最左边的值
                //例如[1,3,3,3,3]可能mid=2
                //此时不用管，让下一次循环继续缩小范围即可
            }
        }
        //如果没有找到的话，例如[1,4,5]找3，则会返回0，即如果存在，那么0+1的位置就是该位置
        return hi;
    }*/

    private int binarySearchRight(int[] array, int target) {
        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] < target) {
                lo++;
            } else if (array[mid] > target) {
                hi--;
            } else {
                lo = mid + 1;
            }
        }
        //lo指向目标元素的下一个元素位置
        return lo;
    }
}
