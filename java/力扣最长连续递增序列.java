public class 力扣最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int result = 0;
        if(n == 0){
            return result;
        }else if(n == 1){
            result = 1;
            return result;
        }
        for(int i = 0; i < nums.length - 1; i++){
            int temp = 1;
            //可优化
            while ((nums[i] < nums[i + 1]) && i < nums.length - 1){
                temp++;
                i++;
                if(i == n - 1){
                    break;
                }
            }
            if(temp > result){
                result = temp;
            }
        }
        return result;
    }
}
