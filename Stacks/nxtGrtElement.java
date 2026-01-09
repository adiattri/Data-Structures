import java.util.*;
public class nxtGrtElement {
    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        Stack<Integer> s = new Stack<>();
        int grt[] = new int[arr.length];

        for(int i = arr.length-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                grt[i] = -1;
            }
            else{
                grt[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for(int i = 0; i<grt.length; i++){
            System.out.print(grt[i] + " ");
        }
        System.out.println();
    }
}
