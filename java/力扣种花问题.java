public class 力扣种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;
        int count = 0;
        int cur = 0;
        //特殊情况
        //当土地数目小于0，需要种的花大于0时
        if(l == 0 && n > 0){
            return false;
        }
        //当可以只种一朵花和不需要种话的时候
        if((l == 1 && flowerbed[0] == 0 && n == 1) || n == 0){
            return true;
        }
        while(cur < l){
            //头判断
            if(cur == 0) {
                if (flowerbed[cur] == 0 && flowerbed[cur + 1] != 1) {
                    flowerbed[cur] = 1;
                    cur++;
                    count++;
                }
                cur++;
                continue;
            }
            //尾判断
            else if(cur == l - 1) {
                if (flowerbed[cur] == 0 && flowerbed[cur - 1] != 1) {
                    flowerbed[cur] = 1;
                    cur++;
                    count++;
                }
                cur++;
                continue;
                //正常判断，判断前后，能种就种
            }else if(flowerbed[cur] == 0 && flowerbed[cur -1] != 1 && flowerbed[cur + 1] != 1){
                flowerbed[cur] = 1;
                cur++;
                count++;
            }else{
                cur++;
                continue;
            }
        }
        return count >= n ? true:false;
    }
}
