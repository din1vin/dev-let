package dl.algorithm.c03binarysearch;

public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int i = 1, j = arr.length - 2;
        while (i <= j) {
            int mid = i + ((j-i)>>1);
            if(arr[mid]>arr[mid-1]) i = mid+1;
            else j = mid-1;
        }
        return j;
    }
}
