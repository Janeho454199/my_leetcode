public class 力扣最大子序合和 {
//    public int maxSubArray(int[] nums) {
//        //f[i] = max(f[i - 1], 0) + num[i]
//        int last = Integer.MIN_VALUE;
//        int result = 0;
//        for(int i = 0; i < nums.length; i++){
//            int now = Math.max(last, 0) + nums[i];
//            result = Math.max(now, result);
//            last = now;
//        }
//        return result;
//    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i <= nums.length - 1; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = nums[i] + dp[i - 1];
                result = Math.max(dp[i], result);
            } else {
                dp[i] = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        int target = maxSubArray(a);
    }
}
