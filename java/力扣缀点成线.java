public class 力扣缀点成线 {
    //自己想的笨比方法，精度不够
//    public boolean checkStraightLine(int[][] coordinates) {
//        int[] start = {coordinates[0][0],coordinates[0][1]};
//        int[] next = {coordinates[1][0],coordinates[1][1]};
//        //通过计算两点间距离公示计算第三边
//        int a = next[0] - start[0];
//        int b = next[1] - start[1];
//        double c = Math.sqrt((a * a) + (b * b));
//        start = new int[]{coordinates[1][0], coordinates[1][1]};
//        for(int i = 2; i < coordinates.length; i++){
//            //以上一个点为起点判断角度是否相同
//            //CosC=(a^2+b^2-c^2)/2ab
//            next = new int[]{coordinates[i][0], coordinates[i][1]};
//            int temp_a = next[0] - start[0];
//            int temp_b = next[1] - start[1];
//            double temp_c = Math.sqrt((temp_a * temp_a) + (temp_b * temp_b));
//            double last_cos = ((a*a) + (b*b) - (c*c))/(2*a*b);
//            double cos = ((temp_a*temp_a) + (temp_b*temp_b) - (temp_c*temp_c))/(2*temp_a*temp_b);
//            if(last_cos != cos){
//                return false;
//            }
//            else{
//                start = next;
//            }
//        }
//        return true;
//    }
    //优化，用比较斜率的方法
    public boolean checkStraightLine(int[][] coordinates) {
        for(int i = 1; i < coordinates.length - 1; i++){
            int x1 = coordinates[i][0] - coordinates[i - 1][0];
            int y1 = coordinates[i][1] - coordinates[i - 1][1];
            int x2 = coordinates[i + 1][0] - coordinates[i][0];
            int y2 = coordinates[i + 1][1] - coordinates[i][1];
            if(y1*x2 != y2*x1){
                return false;
            }
        }
        return true;
    }
}
