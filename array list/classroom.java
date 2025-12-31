import java.util.*;
public class classroom {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);//time complexity to add is O(n)
        list.add(5);



        System.out.println(list);

        int ele = list.get(2);//constant time
        System.out.println(ele);

        list.remove(2);
        System.out.println(list);

        //set
        list.set(2, 10);
        System.out.println(list);

        boolean check = list.contains(4);
        System.out.println(check);

        int size = list.size();
        System.out.println(size);



    }
}
