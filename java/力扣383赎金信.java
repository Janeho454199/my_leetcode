import java.util.HashMap;
import java.util.Map;

public class 力扣383赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Integer> occur1 = new HashMap<String, Integer>();
        // 统计出现次数
        for (int i = 0; i < magazine.length(); i++) {
            String temp = String.valueOf(magazine.charAt(i));
            occur1.put(temp, occur1.get(temp) == null? 1:occur1.get(temp)+1);
        }
        for (int j = 0; j < ransomNote.length(); j++) {
            String temp = String.valueOf(ransomNote.charAt(j));
            if (occur1.containsKey(temp) && occur1.get(temp) != 0) {
                occur1.put(temp, occur1.get(temp) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] counts = new int[26];
        char[] chars = magazine.toCharArray();
        // 统计词频
        for(char c : chars){
            counts[c - 'a']++;
        }
        char[] ransomChars = ransomNote.toCharArray();
        for(char c : ransomChars){
            int index = c-'a';
            counts[index]--;
            if(counts[index] < 0){
                return false;
            }
        }
        return true;
    }
}
