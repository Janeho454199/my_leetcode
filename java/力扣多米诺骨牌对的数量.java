import java.util.HashMap;

public class 力扣多米诺骨牌对的数量 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int result =0;
        HashMap <Integer,Integer>maps = new HashMap<>();
        for(int i=0;i<dominoes.length;i++){
            //由于dominoees中的数在1~9之间，因此只需要计算每组中的min*10+max即是每组的唯一键
            int a = dominoes[i][0];
            int b = dominoes[i][1];
            int min = Math.min(a,b);
            int max = Math.max(a,b);
            int key = min*10+max;
            if(maps.containsKey(key)){
                int val = maps.get(key);
                result = result+val;
                maps.put(key,val+1);
            }
            else {
                maps.put(key,1);
            }
        }
        return result;
    }
}
