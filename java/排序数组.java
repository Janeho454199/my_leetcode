class Solution1 {
        public int[] sortArray(int[] nums) {
            int i;
            for(i=0;i<nums.length;i++)
            {
                int cur = nums[i];
                int intensionindex = i - 1;
                while (intensionindex >= 0 && nums[intensionindex] > cur)
                {
                    nums[intensionindex + 1] = nums[intensionindex];
                    intensionindex--;
                }
                nums[intensionindex + 1] = cur;
            }
            return nums;
        }
}
