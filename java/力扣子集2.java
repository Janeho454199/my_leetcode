import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 力扣子集2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int[] used = new int[nums.length];
        for(int size = 0; size <= nums.length; size++){
            dfs(0, size, cur, ans, used, nums);
        }
        return ans;
    }

    public void dfs(int start, int size, List<Integer> cur, List<List<Integer>> ans, int[] used, int[] nums){
        if(cur.size() == size){
            ans.add(new ArrayList<Integer>(cur));
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1] != 1) continue;
            cur.add(nums[i]);
            used[i] = 1;
            dfs(i+1, size, cur, ans, used, nums);
            cur.remove(cur.size() - 1);
            used[i] = 0;
        }
    }
    public static void main(String[] args) {
        力扣子集2 test = new 力扣子集2();
        int[] a = {1, 1, 2};
        test.subsetsWithDup(a);
    }
}
