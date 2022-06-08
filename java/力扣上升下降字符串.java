import java.util.*;

public class 力扣上升下降字符串 {
    public String sortString(String s) {
        if(s.length() == 0){
            return s;
        }
        List<Character> slist = new ArrayList<>();
        char[] temp = s.toCharArray();
        for(char i:temp){
            slist.add(i);
        }
        //排序
        Collections.sort(slist);
        //准备一个去重的顺序的list
        List<Character> ldlist = new ArrayList<>();
        for(int i = 0; i < slist.size(); i++){
            if(!ldlist.contains(slist.get(i))) {
                ldlist.add(slist.get(i));
            }
        }
        //再准备一个倒序的list
        List<Character> rdlist = new ArrayList<>();
        for(int i = ldlist.size() - 1; i >= 0; i--){
            rdlist.add(ldlist.get(i));
        }
        //用哈希表统计每个字符出现的次数
        Map<Character, Integer> hlist = new HashMap<>();
        for(int i = 0; i < temp.length; i++){
            hlist.put(temp[i], hlist.get(temp[i]) == null? 1:hlist.get(temp[i])+1);
        }
        //准备结果集
        int cur = 0;
        char[] result = new char[s.length()];
        while(!hlist.isEmpty()){
            for(int i = 0; i < ldlist.size(); i++){
                if(hlist.containsKey(ldlist.get(i))){
                    result[cur] = ldlist.get(i);
                    hlist.put(ldlist.get(i), hlist.get(ldlist.get(i)) - 1);
                    cur++;
                }
                if(hlist.containsKey(ldlist.get(i)) && hlist.get(ldlist.get(i)) == 0){
                    hlist.remove(ldlist.get(i));
                }
            }
            if(cur == result.length){
                break;
            }
            for(int i = 0; i < rdlist.size(); i++){
                if(hlist.containsKey(rdlist.get(i))){
                    result[cur] = rdlist.get(i);
                    hlist.put(rdlist.get(i), hlist.get(rdlist.get(i)) - 1);
                    cur++;
                }
                if(hlist.containsKey(rdlist.get(i)) && hlist.get(rdlist.get(i)) == 0){
                    hlist.remove(rdlist.get(i));
                }
            }

        }
        String answer = String.valueOf(result);
        return answer;
    }
}
