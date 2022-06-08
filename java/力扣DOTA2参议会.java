import java.util.LinkedList;
import java.util.Queue;

public class 力扣DOTA2参议会 {
    public String predictPartyVictory(String senate) {
        //思路：模拟投票，并取最优选择
        int n = senate.length();
        Queue<Integer> Dire = new LinkedList<>();
        Queue<Integer> Radiant = new LinkedList<>();
        for(int i = 0; i < senate.length(); i++){
            if(senate.charAt(i) == 'R'){
                Radiant.add(i);
            }else {
                Dire.add(i);
            }
        }
        while (!Radiant.isEmpty() && !Dire.isEmpty()) {
            int radiantIndex = Radiant.poll(), direIndex = Dire.poll();
            if (radiantIndex < direIndex) {
                Radiant.offer(radiantIndex + n);
            } else {
                Dire.offer(direIndex + n);
            }
        }
        return !Radiant.isEmpty() ? "Radiant" : "Dire";
    }
}
