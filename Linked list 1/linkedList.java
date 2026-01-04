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
    public static int size;

    public void addFirst(int data){
         //step 1 = create new node
        Node newNode = new Node(data);
        size++;
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
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        //i=idx-1;
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MAX_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail= null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //prev i = size-2;
        Node prev = head;
        for(int i = 0; i<size-2; i++){
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;

    }

    public int itersearch(int key){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        head = prev;

    }

    public void deleteNthFromEnd(int n){    
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        if(n == sz){
            head = head.next;
            return;
        }
        int i = 1;
        int idxToFind = sz-n;
        Node prev = head;
        while(i<idxToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;

    }
    //slow-fast approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public boolean checkPalindrome(){
        //step 1 to find mid
        //step 2 reverse second half
        //step 3 check left and right half

        if(head == null || head.next == null){
            return true;
        }
        Node midNode = findMid(head);

        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
    }
    return true;
}

public boolean iscycle(){
    Node slow = head;
    Node fast = head;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
            return true;
        }   
    }
    return false;
}
private Node getMid(Node head){
    Node slow = head;
    Node fast = head.next;

    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

public Node merge(Node head1, Node head2){
    Node mergedLL = new Node(-1);
    Node temp = mergedLL;

    while(head1 != null && head2 != null){
        if(head1.data <= head2.data){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        else{
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
    }
    while(head1 != null){
        temp.next = head1;
        head1 = head1.next;
        temp = temp.next;
    }
    while(head2 != null){
        temp.next = head2;
        head2 = head2.next;
        temp = temp.next;
    }
    return mergedLL.next;
}

public Node mergeSort(Node head){
    if(head == null || head.next == null){
        return head;
    }
    Node mid = getMid(head);
    Node rightHead = mid.next;
    mid.next = null;
    Node newLeft = mergeSort(head);
    Node newRight = mergeSort(rightHead);
    return merge(newLeft, newRight);
}

    public static void main(String[] args) {
        linkedList ll = new linkedList();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.add(2, 9);
        // ll.print();
        // // System.out.println(ll.size);
        // // ll.removeFirst();
        // // ll.print();
        // // ll.removeLast();
        // // ll.print();
        // // System.out.println(ll.itersearch(2));
        // // ll.reverse();
        // // ll.print();
        // ll.deleteNthFromEnd(3);
        // ll.print();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.print();



    }
}