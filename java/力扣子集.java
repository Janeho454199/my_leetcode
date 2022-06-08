import java.util.ArrayList;
import java.util.List;

public class 力扣子集 {
    public static void main(String[] args) {
        力扣子集 subsets78 = new 力扣子集();
        int[] nums = {1, 2, 3};
        System.out.println(subsets78.subsets(nums));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> tempSubset = new ArrayList<>();
        for(int size = 0; size <= nums.length; ++size) {
            // 所有子集的长度可能为0到nums.length，每一个可能长度size我们都要dfs并且回溯他所有可能的排列组合
            backTracking(0, size, nums, tempSubset, allSubsets);
        }
        return allSubsets;
    }

    private void backTracking(int start, int size, int[] nums, List<Integer> tempSubset, List<List<Integer>> allSubsets) {
        // 当长度为可能的长度的时候
        if(tempSubset.size() == size) {
            allSubsets.add(new ArrayList<>(tempSubset));
            return;
        }

        for(int i = start; i < nums.length; ++i) {
            // 将当前元素添加
            tempSubset.add(nums[i]);
            // 递归
            backTracking(i + 1, size, nums, tempSubset, allSubsets);
            // 删除掉最后的元素
            tempSubset.remove(tempSubset.size() - 1);
        }
    }
}
