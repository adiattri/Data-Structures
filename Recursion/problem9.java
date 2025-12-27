public class problem9 {

    public static int tiles(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        //vertical
        int verticalTiles = tiles(n-1);

        //horizonta

        int horizontalTiles = tiles(n-2);

        int totalways = verticalTiles + horizontalTiles;

        return totalways;
    }
    public static void main(String[] args) {
        System.out.println(tiles(4));
    }
}
