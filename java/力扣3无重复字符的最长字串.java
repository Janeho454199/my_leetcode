import java.util.HashSet;
import java.util.Set;

public class 力扣3无重复字符的最长字串 {
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        int result = 0;
        int right = 0;
        for (int left = 0; left < n; left++) {
            if (left != 0) {
                occ.remove(s.charAt(left - 1));
            }
            while (right < n && !occ.contains(s.charAt(right))) {
                occ.add(s.charAt(right));
                right++;
            }
            result = Math.max(result, right - left);
        }
        return result;
    }
}
