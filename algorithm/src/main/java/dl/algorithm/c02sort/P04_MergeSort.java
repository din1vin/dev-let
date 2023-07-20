package dl.algorithm.c02sort;


/**
 * @author WuJi
 **/
public class P04_MergeSort extends Sort {
    @Override
    protected void sort(int[] arr) {
        process(arr, 0, arr.length - 1);
    }

    private void process(int[] arr, int l, int r) {
        if (l == r) return;
        int m = l + ((r - l) >> 1);
        process(arr, l, m);
        process(arr, m + 1, r);
        merge(arr, l, m, r);
    }


    private void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int k = 0;
        int i = l, j = m + 1;
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= m) {
            temp[k++] = arr[i++];
        }

        while (j <= r) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, l, temp.length);
    }
}
