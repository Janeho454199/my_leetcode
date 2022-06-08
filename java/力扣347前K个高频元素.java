import java.util.*;

public class 力扣347前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 用哈希存储值和出现次数
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 利用最小堆保存频率最大的k个元素
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            // 当堆没满的时候直接添加
            if (pq.size() < k) {
                pq.add(key);
                // 否则与堆中的peek的元素比较，
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        int[] res = new int[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i] = pq.remove();
            i++;
        }
        return res;
    }
}
