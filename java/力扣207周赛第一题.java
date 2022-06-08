public class 力扣207周赛第一题 {
    public String reorderSpaces(String text) {
        if(text.length() == 1){ 
            return text;
        }
        //统计单词数
        String result = "";
        String[] wordList = text.trim().split("\\s+");

        int spaceNum = 0;
        char[] strList = text.toCharArray();
        //统计空格数
        for(int i = 0; i < text.length(); i++){
            if(strList[i] == ' '){
                spaceNum++;
            }
        }
        if(wordList.length == 1){
            result += wordList[0];
            for(int i = 0; i < spaceNum; i++){
                result += " ";
            }
            return result;
        }
        int wordNum = wordList.length;
        int lastSpace = 0;
        //当空格数可以平均分
        if((spaceNum % (wordNum - 1)) == 0){
            for(int i = 0; i < wordList.length; i++){
                if(i == wordList.length - 1){
                    result += wordList[i];
                    continue;
                }
                result += wordList[i];
                for(int j = 0; j < spaceNum / (wordNum - 1); j++){
                    result += " ";
                }
            }
        }else{
            //当有多余空格
            lastSpace = spaceNum % (wordNum - 1);
            for(int i = 0; i < wordList.length; i++){
                if(i == wordList.length - 1){
                    result += wordList[i];
                    for(int j = 0; j < lastSpace; j++){
                        result += " ";
                    }
                    continue;
                }
                result += wordList[i];
                for(int k = 0; k < spaceNum / (wordNum - 1); k++){
                    result += " ";
                }
            }
        }
        return result;
    }
}
