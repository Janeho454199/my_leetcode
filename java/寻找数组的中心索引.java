import java.util.Arrays;

public class 寻找数组的中心索引 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int pre = 0;
        if(n < 3){
            return -1;
        }
        int sum = Arrays.stream(nums).sum();
        for(int i = 0; i < nums.length; i++){
            pre+=nums[i];
            if(pre - nums[i] == sum - pre){
                return i;
            }
        }
        return -1;
    }
}
