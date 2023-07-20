package dl.algorithm.c02sort;

import java.util.Arrays;

/**
 * @author WuJi
 **/
public class Test {
    public static void main(String[] args) {
        int[] nums = {2,3,4,2,1,3};
        new P04_MergeSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
