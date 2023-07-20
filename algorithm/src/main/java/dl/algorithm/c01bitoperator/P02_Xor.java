package dl.algorithm.c01bitoperator;

/**
 * @author WuJi
 **/
public class P02_Xor {
    /**
     * int[] 数组中有n个数,已知只有一种数出现了奇数次,找到该数
     */
    public int findOddTimesNum(int[] num) {
        int res = 0;
        for (int j : num) {
            res = res ^ j;
        }
        return res;
    }

    /**
     * int[] 数组中有n个数,已知只有两种数出现了奇数次,找到它们
     */
    public int[] findOddTimesNum2(int[] num) {
        int xor = 0;
        for (int i : num) {
            xor = xor ^ i;
        }

        // xor 是 a 和 b两数的 异或结果,
        // a和b不同则xor必有一位是1
        int x = 0;
        int rightOne = xor & (~xor + 1); // 提出右边的1
        for (int i : num) {
            if ((rightOne & i) == 0) {
                x = x ^ rightOne;
            }
        }
        return new int[]{x, xor ^ x};
    }
}
