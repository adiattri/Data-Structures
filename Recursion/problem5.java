public class problem5 {
    public static int fibonacci(int n){
        if(n == 0){
            return n;
        }
        if(n == 1){
            return n;
        }

       return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        //f(n) = f(n-1) + f(n-2)
        int n = 5;
        int x = fibonacci(n);
        System.out.println(x);
    }

}
