public class x的平方根 {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        Double temp = Math.sqrt(Double.valueOf(x));
        int result = temp.intValue();
        return result;
    }
}
