import java.util.Arrays;

public class 力扣88合并两个有序数组 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length;
        int[] result = new int[len];
        // 左右
        int left = 0;
        int right = 0;
        // 当前位置
        int cur = 0;
        while (cur < len) {
            if (left > m - 1) {
                result[cur++] = nums2[right];
                right++;
            } else if (right > nums2.length - 1) {
                result[cur++] = nums1[left];
                left++;
            } else if (nums1[left] <= nums2[right]) {
                result[cur++] = nums1[left];
                left++;
            } else {
                result[cur++] = nums2[right];
                right++;
            }
        }
        System.arraycopy(result, 0, nums1, 0, len);
    }

    public static void main(String[] args) {
        int[] a = {-1,2,3,0,0,0};
        int[] b = {2, 5, 6};
        int m = 3;
        int n = 3;
        merge(a, m, b, n);
    }
}
