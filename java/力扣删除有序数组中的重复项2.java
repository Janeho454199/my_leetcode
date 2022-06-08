public class 力扣删除有序数组中的重复项2 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int count = 1;
        int index = 1;
        for (int i=1;i<n;i++) {
            // 当不相等的时候，直接赋值index并且重置count
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
                count = 1;
                // 当数据相等并且count < 2的时候说明出现次数在两次以内，直接赋值index，count++
            } else if (count < 2) {
                nums[index++] = nums[i];
                count++;
            } else {
                continue;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        力扣删除有序数组中的重复项2 test = new 力扣删除有序数组中的重复项2();
        int[] a = {1,1,1,2,2,3};
        test.removeDuplicates(a);
    }
}
