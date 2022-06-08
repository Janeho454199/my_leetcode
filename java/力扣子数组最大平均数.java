public class 力扣子数组最大平均数 {
    public double findMaxAverage(int[] nums, int k) {
        //滑动窗口
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < k; i++){
            sum = sum + nums[i];
        }
        int temp_sum = sum;
        for(int j = k; j < n; j++){
            temp_sum = temp_sum - nums[j - k] + nums[j];
            sum = Math.max(temp_sum,sum);
        }
        return 1.0 * sum/k;
    }
}
