import java.util.*;

public class 字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        if(strs.length == 0){
            return result;
        }
        for(String i:strs){
            char[] temp = i.toCharArray();
            String temp_string = String.copyValueOf(temp);
            Arrays.sort(temp);
            String sorted_temp_string = String.copyValueOf(temp);
            if (map.containsKey(sorted_temp_string)){
                map.get(sorted_temp_string).add(temp_string);
            }else {
                map.put(sorted_temp_string, new LinkedList<>());
                map.get(sorted_temp_string).add(temp_string);
            }
        }
        for(String i:strs){
            char[] temp = i.toCharArray();
            List<String> temp_list = new ArrayList<>();
            Arrays.sort(temp);
            String cur = String.valueOf(temp);
            for(int j = 0; j < map.get(cur).size(); j ++){
                temp_list.add(map.get(cur).get(j));
            }
            map.remove(cur);
            result.add(temp_list);
        }
        return result;
    }
}
