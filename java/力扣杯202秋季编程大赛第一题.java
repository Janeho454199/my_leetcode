public class 力扣杯202秋季编程大赛第一题 {
    public int paintingPlan(int n, int k) {
        if(k < n){
            return 0;
        }
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                int sum = (n*i) + (j*(n - i));
                if(sum == k){
                    if(i == n || j == n) return 1;
                    if(i == j) return Combination(n,j) * Combination(n,i);
                    else return Combination(n,i) * Combination(n,j) * 2;
                }
            }
        }
        return 0;
    }
    public static int Combination(int n, int k){
        if(k > n) return 0;
        else if(k == 0 || k == n) return 1;
        else return Combination(n - 1,k) + Combination(n - 1, k - 1);
    }
}
