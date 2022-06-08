public class 力扣滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //将数组分成大小相等的块，每个块都可以理解为有两个数组 left 和 right。left 方向从左到右，right 相反。left[i]是指块从开始到下标 i 的最大元素，right[j]是指块从开始到下标 j 的最大元素。
        //假设滑动窗口的范围是[i, j]，很容易看出来，滑动窗口中的最大值就是 max(right[i], left[j])
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        for(int i = 1; i < n; i++){
            if(i % k == 0){
                left[i] = nums[i];
            }else {
                left[i] = Math.max(nums[i], left[i - 1]);
            }
        }
        for(int i = n - 2; i >= 0; i--){
            if((i + 1) % k == 0){
                right[i] = nums[i];
            }else {
                right[i] = Math.max(nums[i], right[i + 1]);
            }
        }
        int[] result = new int[n - k + 1];
        for(int i = 0; i < n - k + 1; i++){
            result[i] = Math.max(left[i + k - 1],right[i]);
        }
        return result;
    }
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums.length == 0) {
//            return new int[0];
//        }
//        if (k == 1) {
//            return nums;
//        }
//        int[] left = new int[nums.length];
//        int[] right = new int[nums.length];
//        left[0] = nums[0];
//        right[nums.length - 1] = nums[nums.length - 1];
//        for (int i = 1; i < nums.length; i++) {
//            // 从左到右生成left
//            if (i % k == 0) {
//                left[i] = nums[i];
//            } else {
//                left[i] = Math.max(left[i - 1], nums[i]);
//            }
//            // 从右到左生成 right
//            int j = nums.length - i - 1;
//            if ((j + 1) % k == 0) {
//                right[j] = nums[j];
//            } else {
//                right[j] = Math.max(right[j + 1], nums[j]);
//            }
//        }
//        int[] result = new int[nums.length - k + 1];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = Math.max(right[i], left[i + k - 1]);
//        }
//        return result;
//    }
}
