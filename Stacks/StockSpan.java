import java.util.*;
public class StockSpan {

    public static void span(int[] stock, int[] span){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i = 1; i<stock.length; i++){
            int currPrice = stock[i];

            while(!s.isEmpty() && currPrice > stock[s.peek()]){
                s.pop();
            }

            if(s.isEmpty()){
                span[i] = i+1;

            }else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            s.push(i);
        }
        

    }

    public static int brute(int[] stock){
        int maxSpan = Integer.MIN_VALUE;
        int currSpan = 0;
        for(int i = 0; i<stock.length; i++){
            for(int j = i; j>=0; j--){
                if(stock[j] <= stock[i]){
                    currSpan = i-j;
                }
                if(currSpan == 0){
                    currSpan = 1;
                }
            }
            if(currSpan>maxSpan){
                maxSpan = currSpan;
            }
        }
        return maxSpan;
    }
    public static void main(String[] args) {
        int stock[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stock.length];
        span(stock, span);
        System.out.println(span);
    }
}
