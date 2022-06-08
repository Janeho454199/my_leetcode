public class 力扣最大连续1的个数 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            int j = i;
            while(nums[j] == 1){
                j++;
            }
            if(j - i > result){
                result = j;
            }
        }
        return result;
    }
}
