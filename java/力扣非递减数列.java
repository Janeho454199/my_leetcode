public class 力扣非递减数列 {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if(n < 2){
            return true;
        }
        int count = 0;
        for(int i = 1; i < n; i++){
            // if(nums[i] < nums[i - 1]){
            //     count++;
            // }
            if(nums[i] < nums[i - 1]){
                count++;
                if(count > 1){
                    return false;
                }
                if(i == 1 || nums[i] >= nums[i - 2]){
                    nums[i - 1] = nums[i];
                }else{
                    nums[i] = nums[i - 1];
                }
            }
        }
        return count <= 1? true:false;
    }
}
