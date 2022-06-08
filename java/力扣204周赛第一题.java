public class 力扣204周赛第一题 {
    public boolean containsPattern(int[] arr, int m, int k) {
        //排除
        if(arr.length == 0 || arr.length<m*k){
            return false;
        }
        int flag = 0;
        int flag1 = 1;
        for(int i=0;i<arr.length-m*k+1;i++){
            int left = i + m;
            for(int j=0;j<arr.length-m;j++){
                if(arr[i] == arr[left]){
                    flag += 1;
                    if(flag == m){
                        flag1++;
                        if(flag1 == k){
                            return true;
                        }
                        flag = 0;
                    }
                    i++;
                    left++;
                }else if(flag1 == k){
                    return true;
                }
                else{
                    i-=flag;
                    flag = 0;
                    flag1 = 1;
                    break;
                }
            }
        }
        return false;
    }
}
