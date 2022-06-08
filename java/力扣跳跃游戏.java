public class 力扣跳跃游戏 {
    public boolean canJump(int[] nums) {
        int dist = 0;
        for(int i = 0; i < nums.length && dist < nums.length; i++){
            dist = Math.max(dist, nums[i] + i);
        }
        return dist >= nums.length - 1? true:false;
    }
}
