import java.util.HashMap;
import java.util.Map;

public class 力扣重复元素 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> occur = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(occur.containsKey(nums[i])){
                return false;
            }else{
                occur.put(nums[i] , 0);
            }
        }
        return true;
    }
}
