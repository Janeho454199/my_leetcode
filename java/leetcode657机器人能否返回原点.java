public class leetcode657机器人能否返回原点 {
    public boolean judgeCircle(String moves) {
        //初始化机器人位置和行动
        int[] robot = {0, 0};
        String R = "R";
        String L = "L";
        String U = "U";
        String D = "D";
        //判断输入是否只有一步或者不动
        if(moves.length() == 1)
        {
            return false;
        }else if(moves.length() == 0)
        {
            return true;
        }
        //遍历字符串,进行位置运算
        int i;
        for (i=0;i<moves.length()-1;i++)
        {
            if(moves.substring(i,i+1).equals("R")){
                robot[0] += 1;
            }
            if(moves.substring(i,i+1).equals("R")){
                robot[0] -= 1;
            }
            if(moves.substring(i,i+1).equals("R")){
                robot[1] += 1;
            }
            if(moves.substring(i,i+1).equals("R")){
                robot[1] -= 1;
            }
        }
        if(robot[0]==0 && robot[1]==0){
            return true;
        }else
        {
            return false;
        }
    }
}
