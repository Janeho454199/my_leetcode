public class 力扣205周赛第二题 {
    public int numTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int answer = 0;
        //类型一
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < m; k++){
                    if(k == j){
                        continue;
                    }else{
                        if(Math.pow(nums1[i], 2) == nums2[j] * nums2[k]){
                            answer++;
                        }
                    }
                }
            }
        }
        //类型二
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(k == j){
                        continue;
                    }else{
                        if(Math.pow(nums1[i], 2) == nums2[j] * nums2[k]){
                            answer++;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
