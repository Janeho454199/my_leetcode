public class 力扣557反转字符串中的单词 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String str = "";
        for(int i=0;i<words.length;i++){
            String temp = new StringBuffer(words[i]).reverse().toString();
            words[i] = temp;
        }
        for(int j=0;j<words.length;j++){
            if(j == words.length-1){
                str = str + words[j];
                break;
            }
            str = str + words[j] + " ";
        }
        return str;
    }
}
