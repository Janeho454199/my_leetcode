import java.util.Comparator;
import java.util.PriorityQueue;

public class 力扣973最接近原点的K个点 {
    public int[][] kClosest(int[][] points, int K) {
        //定义一个优先队列并设置排序方式为降序
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2){
                return array2[0] - array1[0];
            }
        });
        int n = points.length;
        //先将前K个点的欧几里得距离存到优先队列中
        for(int i = 0; i < K; i++){
            int[] temp = {points[i][0]*points[i][0] + points[i][1]*points[i][1], i};
            pq.add(temp);
        }
        //将后面的数与优先队列的顶部比较，如果小于顶部则入队
        for(int i = K; i < n; i++){
            int temp = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            if(temp < pq.peek()[0]){
                pq.poll();
                pq.offer(new int[]{temp, i});
            }
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; ++i) {
            ans[i] = points[pq.poll()[1]];
        }
        return ans;
    }
}
