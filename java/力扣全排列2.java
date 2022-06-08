import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 力扣全排列2 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    int[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new int[nums.length];
        Arrays.sort(nums);
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < nums.length; i++) {
            if(used[i] == 1) continue;
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 1) continue;
            used[i] = 1;
            path.add(nums[i]);
            dfs(nums);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
