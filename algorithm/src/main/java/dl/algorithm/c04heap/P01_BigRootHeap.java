package dl.algorithm.c04heap;

/**
 * @author WuJi
 **/
public class P01_BigRootHeap {
    private int heapSize;
    private int capacity = 16;
    private int[] nums = new int[16];

    public void heapInsert(int n) {
        nums[heapSize++] = n;
        int index = heapSize;
        while (nums[index] > nums[(index - 1) / 2]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void heapify(int index) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize & nums[left] < nums[left + 1] ? left + 1 : left;
            largest = nums[index] < nums[largest] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(nums, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
