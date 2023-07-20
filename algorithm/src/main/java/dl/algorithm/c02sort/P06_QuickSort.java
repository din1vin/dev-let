package dl.algorithm.c02sort;

/**
 * @author WuJi
 **/
@SuppressWarnings("unused")
public class P06_QuickSort extends Sort {

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    /**
     * 三色荷兰国旗问题解
     */
    private int[] partition(int[] arr, int l, int r) {
        int less = l - 1; // 小于区右边界
        int grater = r + 1; //大于区左边界
        while (l < grater) {
            if (arr[l] < arr[r]) {
                swap(arr, less++, l);
            } else if (arr[l] > arr[r]) {
                swap(arr, l, grater--);
            } else {
                l++;
            }
        }
        swap(arr, l, r);
        return new int[]{less + 1, grater};
    }
}
