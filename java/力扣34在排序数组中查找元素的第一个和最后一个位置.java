public class 力扣34在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int temp = 0;
        int[] result = {-1,-1};
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                temp = nums[i];
                result[0] = i;
                break;
            }
        }
        if(result[0] == -1){
            return result;
        }
        temp = 0;
        for(int i = result[0]; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                temp++;
            }else{
                result[1] = result[0] + temp;
                return result;
            }
        }
        result[1] = result[0] + temp;
        return result;
    }
}
