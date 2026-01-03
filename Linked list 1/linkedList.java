public class linkedList{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public void addFirst(int data){
         //step 1 = create new node
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        //step 2 = new node next assign to head
        newNode.next = head;

        //step 3 = point head to new node
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(2);
        ll.addLast(2);



    }
}