import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 力扣最后一块石头的重量 {
    static Comparator<Integer> cmp =  new Comparator<Integer>() {
        @Override
        public int compare(Integer e1,Integer e2) {
            return e2 - e1;
        }
    };
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>(cmp);
        for(int i = 0; i < stones.length; i++){
            pq.offer(stones[i]);
        }
        while(pq.size() > 1){
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if (stone1 > stone2){
                pq.offer(stone1 - stone2);
            }else if (stone2 > stone1){
                pq.offer(stone2 - stone1);
            }else if (stone1 == stone2){
                continue;
            }
        }
        return pq.isEmpty()? 0:pq.poll();
    }
}
