import java.util.List;

public class 力扣反转字符串里的单词 {
    public String reverseWords(String s) {
        if(s.length() == 0 || s.equals(" ")) return "";
        if(s.length() == 1) return s;
        String[] strList = s.trim().split("\\s+");
        String result = "";
        for(int i = strList.length - 1; i >= 0; i--){
            if(i == 0){
                result += strList[i].trim();
                continue;
            }
            result += strList[i].trim() + " ";
        }
        return result;
    }
}
