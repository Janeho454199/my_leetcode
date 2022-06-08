public class 力扣移动零 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1){
            return;
        }
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                for(int j = i; j < n - 1; j++){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
                n = n - 1;
            }
        }
    }
    public static void moveZeroes1(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[left] != 0) {
                left++;
                right++;
                continue;
            }
            if (left == right) {
                right++;
            } else if (nums[left] == 0 && nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right++;
            } else {
                right++;
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {-48764,-37585,13045,0,68754,-47747,14202,83944,-68075,-8137,12497,-8260,-97065,-7820,-41210,19833,52812,0,-54665,-84822};
        moveZeroes1(a);
    }
}
