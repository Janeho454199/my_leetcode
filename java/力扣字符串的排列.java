import java.util.Arrays;

public class 力扣字符串的排列 {
    public boolean checkInclusion(String s1, String s2) {
        //count1，count2分别统计s1，s2的各个字母出现次数
        //从n开始滑动窗口，添加和减少滑动过程种的字母出现次数的变化
        //每次变化判断窗口种的数组是否相等即可
        int n = s1.length();
        int m = s2.length();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i = 0; i < n; i++){
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(count1,count2)){
            return true;
        }
        for(int i = n; i < m; i++){
            count2[s2.charAt(i) - 'a']++;
            count2[s2.charAt(i - n) - 'a']--;
            if(Arrays.equals(count1,count2)){
                return true;
            }
        }
        return false;
    }
}
