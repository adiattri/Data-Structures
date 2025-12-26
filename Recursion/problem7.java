public class problem7 {
    public static int firstIndex(int arr[], int key, int i){
        
        if(i == arr.length){
            return -1;
        }

        if(arr[i] == key){
            return i;
        }

       
        return firstIndex(arr, key, i+1);
    }
    public static void main(String[] args) {
        int arr[] = {3,2,8,7,8,5,6,7,8};
        int x = firstIndex(arr, 8, 0);
        System.out.println(x);
    }
}
