public class 力扣最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        if(words.length == 0){
            return 0;
        }
        int n = words.length;
        return words[n - 1].length();
    }
}
