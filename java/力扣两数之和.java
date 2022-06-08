import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 力扣两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[] {map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.sort(nums);
        //2,7,11,15
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if(nums[left]+nums[right]>target) right--;
            else if(nums[left]+nums[right]<target)left++;
            else break;
        }
        return result;
    }
}
