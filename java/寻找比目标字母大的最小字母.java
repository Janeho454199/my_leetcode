class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i] == target)
            {
                break;
            }else
            {
                int[] temp = {-1, -1};
                return temp;
            }
        }
        int left = 0;
        int right = nums.length - 1;
        if(right == 0 && nums[0] == target)
        {
            int[] temp = {0 ,0};
            return temp;
        }
        if(right == 1 && nums[0]!=nums[1])
        {
            if(nums[0] == target)
            {
                int[] temp = {0, 0};
                return temp;
            }
            if(nums[1] == target)
            {
                int[] temp = {1, 1};
                return temp;
            }
        }
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target && right == 1 && nums[0] != nums[1])
            {
                int[] temp = {mid, mid};
                return temp;
            }
            if(nums[mid] == target && nums[mid] == nums[mid + 1])
            {
                int[] temp = {mid ,mid+1};
                return temp;
            }else if (nums[mid] == target && nums[mid] == nums[mid - 1])
            {
                int[] temp = {mid-1 ,mid};
                return temp;
            }
            else if(target > nums[mid])
            {
                left = mid + 1;
            }
            else if(target < nums[mid])
            {
                right = mid;
            }
            else
            {
                for(i=0;i<nums.length;i++)
                {
                    if(nums[i] == target)
                    {
                        int[] temp = {i, i};
                        return temp;
                    }
                }
            }
        }
        int[] temp = {left ,left};
        return temp;
    }
}