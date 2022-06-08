import java.util.*;
public class 力扣841钥匙和房间 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int rl = rooms.size();
        //用数组表示门是否打开，用count记录打开的门数
        int count = 1;
        boolean[] room = new boolean[rl];
        //利用队列存储钥匙
        Queue<Integer> keys = new LinkedList<>();
        //第一个门默认打开
        room[0] = true;
        //拿第一个门的钥匙
        for(Integer key:rooms.get(0)){
            keys.offer(key);
        }
        //根据手上的钥匙去开门，当手里没有钥匙的时候结束
        while(!keys.isEmpty()){
            //拿出钥匙去开门并移除
            int key = keys.poll();
            if(room[key]){
                continue;
            }
            //开门
            room[key] = true;
            count++;
            //取走钥匙
            for(Integer cur:rooms.get(key)){
                keys.offer(cur);
            }
        }
        return count == rooms.size();
    }
}
