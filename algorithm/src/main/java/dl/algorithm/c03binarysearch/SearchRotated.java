package dl.algorithm.c03binarysearch;

//搜索旋转排序数组
public class SearchRotated {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) return mid;
            if (nums[l] == target) return l;
            if (nums[r] == target) return r;
            // 左边有序
            if (nums[mid] < nums[r]) {
                // 目标值在右边
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                    // 目标值在左边
                } else {
                    r = mid - 1;
                }
                // 左边有序
            } else {
                // 目标值在左边
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                    // 目标值在右边
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
