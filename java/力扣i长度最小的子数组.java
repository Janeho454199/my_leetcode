public class 力扣i长度最小的子数组 {
    public int minSubArrayLen(int s, int[] nums) {
        int result = 100;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            int tempNums = 0;
            j = i;
            while (tempNums < s && j < nums.length){
                tempNums += nums[j];
                j++;
                if(tempNums >= s){
                    if(j - i < result){
                        result = j - i;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
