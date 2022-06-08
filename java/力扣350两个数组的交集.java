import java.util.Arrays;

public class 力扣350两个数组的交集 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len = nums1.length;
        int left = 0;
        int right = 0;
        int[] result = new int[len];
        int cur = 0;
        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] < nums2[right]) {
                left++;
            } else if (nums1[left] > nums2[right]) {
                right++;
            } else if (nums1[left] == nums2[right]) {
                result[cur++] = nums1[left];
                left++;
                right++;
            }
        }
        return Arrays.copyOfRange(result, 0, cur);
    }
}
