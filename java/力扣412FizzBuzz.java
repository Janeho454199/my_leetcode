import java.util.LinkedList;
import java.util.List;


/*
写一个程序，输出从 1 到 n 数字的字符串表示。
    1. 如果n是3的倍数，输出“Fizz”；
    2. 如果n是5的倍数，输出“Buzz”；
    3.如果n同时是3和5的倍数，输出 “FizzBuzz”。
*/
public class 力扣412FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new LinkedList<>();
        int add_15 = 0;
        int add_5 = 0;
        int add_3 = 0;
        for(int i = 1; i <= n; i++){
            add_15 += 1;
            add_5 += 1;
            add_3 += 1;
            if (add_15 == 15){
                String temp = "FizzBuzz";
                result.add(temp);
                add_15 = 0;
                add_5 = 0;
                add_3 = 0;
            }else if (add_5 == 5){
                String temp = "Buzz";
                result.add(temp);
                add_5 = 0;
            }else if (add_3 == 3){
                String temp = "Fizz";
                result.add(temp);
                add_3 = 0;
            }else {
                String temp = Integer.toString(i);
                result.add(temp);
            }
        }
        return result;
    }
}
