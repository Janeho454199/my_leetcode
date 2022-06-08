public class 力扣搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid = 0;
        if (n == 0){
            return -1;
        }
        if (n == 1 && nums[0] != target){
            return -1;
        }
        // 找到旋转的下标
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i - 1]){
                continue;
            }else{
                mid = i - 1;
                break;
            }
        }
        // 判断target属于哪一个区间
        if(target > nums[0]){
            right = mid;
        }else if (target == nums[0]){
            return 0;
        }else{
            left = mid + 1;
        }

        // 开始二分搜索
        while (left <= right) {
            int mid2 = left + (right - left) / 2;
            //如果mid的第一个数小于目标数,目标数在右边
            if (nums[mid2] < target) {
                left = mid2 + 1;
            }else if(nums[mid2] == target){
                return mid2;
            }else {
                right = mid2 - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        力扣搜索旋转排序数组 test = new 力扣搜索旋转排序数组();
        int[] a = {4,5,6,7,0,1,2};
        int b = 0;
        test.search(a, b);
    }
}
