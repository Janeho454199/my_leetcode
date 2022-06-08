public class 力扣移除零 {
    public void moveZeroes(int[] nums) {
        int zeroNum = nums.length - 1;
        //先将0全部移至末尾
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0 && i < zeroNum){
                nums[i] = nums[zeroNum];
                nums[zeroNum] = 0;
                zeroNum--;
            }
        }
        //对非零元素进行排序
        for(int j = 0; j <= zeroNum - 1; j++){
            if(nums[j+1] < nums[j] && nums.length != 2){
                int temp = nums[j+1];
                nums[j+1] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
