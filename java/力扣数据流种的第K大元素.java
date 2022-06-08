import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> pq;
    private int tempk;
    public KthLargest(int k, int[] nums) {
        tempk = k;
        pq = new PriorityQueue<>();
        for(int i:nums){
            add(i);
        }
    }
    public int add(int val) {
        if(pq.size() < tempk){
            pq.offer(val);
        }else if(pq.peek() < val){
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
