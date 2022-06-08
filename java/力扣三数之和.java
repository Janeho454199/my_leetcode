import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 力扣三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        //边界
        if(n < 3){
            return result;
        }
        for(int i = 0; i < n - 2; i++){
            if(nums[i] > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int k = n - 1;
            int cur = nums[i];
            for(int j = i + 1; j < n; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                while(j < k && nums[j] + nums[k] > -1*cur){
                    k--;
                }
                if(j == k){
                    break;
                }
                if(nums[j] + nums[k] + nums[i] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
