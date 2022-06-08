import java.util.ArrayList;
import java.util.List;

public class 力扣汇总区间 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        if(n == 0){
            return result;
        }
        if(n == 1){
            String s = String.valueOf(nums[0]);
            result.add(s);
        }
        int cur = 0;
        while (cur < n){
            int low = cur;
            cur ++;
            while(cur < n && nums[cur] == nums[cur - 1] + 1){
                cur++;
            }
            int hight = cur - 1;
            StringBuffer temp = new StringBuffer(String.valueOf(nums[low]));
            if(low < hight) {
                temp.append("->");
                temp.append(String.valueOf(nums[hight]));
            }
            result.add(temp.toString());

        }
        return result;
    }
}
