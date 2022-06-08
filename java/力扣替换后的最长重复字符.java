public class 力扣替换后的最长重复字符 {
    public int characterReplacement(String s, int k) {
        //双指针
        //思路：遍历，left，right
        //left指向当前重复字母的第一个字母，right表示转换k个字母后的最长重复字母
        //当相等或者还有转换次数的时候，right往右移动，到边界终止
        //当遇到不相等的字符并且没有转换次数的时候，left指针左移
        int n = s.length();
        int[] nums = new int[26];
        int left = 0;
        int right = 0;
        int max_num = 0;
        while(right < n){
            //求出当前字串的重复次数最多的字母
            nums[s.charAt(right) - 'A'] += 1;
            max_num = Math.max(max_num, nums[s.charAt(right) - 'A']);
            //求出当前转换字符有没有超过可转换次数，如果超过，left右移并减去其对应的字母频数
            if(right - left + 1 - max_num > k){
                nums[s.charAt(left) - 'A'] -= 1;
                left += 1;
            }
            right += 1;
        }
        //right - left在整个过程是非递减的。只要right 的值加进去不满足条件，left和right就一起右滑，因为长度小于right - left的区间就没必要考虑了，所以right - left一直保持为当前的最大值
        return right - left;
    }
}
