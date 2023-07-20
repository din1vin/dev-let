package dl.algorithm.c02sort;

import java.util.Arrays;

/**
 * @author WuJi
 **/
public abstract class Sort {
    protected abstract void sort(int[] arr);

    protected void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    protected void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
