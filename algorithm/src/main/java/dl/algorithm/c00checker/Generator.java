package dl.algorithm.c00checker;

import java.util.Random;

/**
 * @author WuJi
 **/
public class Generator {
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        Random r = new Random();
        int len = r.nextInt(maxSize);
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = r.nextInt(maxValue);
        }
        return res;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        int i = 0;
        for (int n : arr) {
            res[i++] = n;
        }
        return res;
    }

    public static boolean testArrayEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
