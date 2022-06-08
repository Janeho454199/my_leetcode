public class 力扣977有序数组的平方 {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        // 找到中间点
        int mid = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                mid = i;
            } else {
                // 全是正数直接返回
                break;
            }
        }
        // -4,-1,0,3,10
        // 16 1               0 9 10
        // 现在数组从mid开始左边都是负数，右边都是正数
        int[] result = new int[n];
        int i = mid;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针

        while (i >= 0 || j < n) {
            if (i < 0) {
                result[t] = nums[j] * nums[j];
                ++j;
            } else if (j == n) {
                result[t] = nums[i] * nums[i];
                --i;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                result[t] = nums[i] * nums[i];
                --i;
            } else {
                result[t] = nums[j] * nums[j];
                ++j;
            }
            ++t;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = {-4,-1,0,3,10};
        sortedSquares(a);
    }
}
