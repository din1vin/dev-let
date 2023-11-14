package dl.algorithm.c02sort;

import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray {
    Map<Integer, Integer> pos = new HashMap<>();

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            pos.put(arr2[i], i);
        }
        sort(arr1, 0, arr1.length - 1);
        return arr1;
    }

    private void sort(int[] arr, int left, int right) {
        if (left == right) return;
        int mid =  left + ((right - left) >> 1);
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, right, mid);
    }

    private void merge(int[] arr, int left, int right, int mid) {
        int[] temp = new int[right - left + 1];
        int k = 0, i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (less(arr[i], arr[j])) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, left, temp.length);

    }


    private boolean less(int x, int y) {
        boolean xx = pos.containsKey(x);
        boolean yy = pos.containsKey(y);
        if (xx && yy) {
            return pos.get(x) < pos.get(y);
        } else if (xx) {
            return true;
        } else if (yy) {
            return false;
        } else {
            return x < y;
        }
    }
}
