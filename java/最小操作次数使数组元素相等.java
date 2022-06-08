public class 最小操作次数使数组元素相等 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int num:nums) {
            if (num < min) {
                min = num;
            }
        }

        for (int num:nums) {
            count += num - min;
        }
        return count;
    }
}
