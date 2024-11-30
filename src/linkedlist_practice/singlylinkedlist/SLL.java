package linkedlist_practice.singlylinkedlist;

public class SLL<T> {

    private ListNode<T> head;

    private static class ListNode<T> {
        private T data;
        private ListNode<T> next;

        public ListNode(T data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        SLL<Object> sll = new SLL<>();
        sll.insertAtEnd(10);
        sll.insertAtEnd(5);
        sll.insertAtEnd(25);
        sll.insertAtEnd(15);
        sll.insertAtEnd(0);

        sll.insertAtStart(100);
        sll.insertAtStart(200);
        sll.insertAtStart(300);

        sll.insertAtGivenPosition(500, 3);
        sll.display();
        System.out.println();
        sll.deleteAtFirst();
        sll.deleteAtEnd();
        sll.display();
    }

    public void insertAtEnd(T data){

        if(head == null) {
            head = new ListNode<>(data);
        }

        else{
            ListNode<T> current = head;
            while(current.next != null){
                current = current.next;
            }
            ListNode<T> newNode = new ListNode<>(data);
            current.next = newNode;
        }

    }

    public void insertAtStart(T data){
        if(head == null){
            head = new ListNode<>(data);
        }
        else{
            ListNode<T> newNode = new ListNode<>(data);
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtGivenPosition(T data, int pos){
        ListNode<T> newNode = new ListNode<>(data);
        int count = 1;

        ListNode<T> current = head;
        while(count < pos - 1){
            current = current.next;
            count++;
        }

        if(current.next == null){
            current.next = newNode;

        }
        else {
            ListNode<T> nextNode = current.next;
            current.next = newNode;
            newNode.next = nextNode;
        }

    }

    public void deleteAtFirst(){
        if(head == null) return;
        ListNode<T> temp = head;
        head = head.next;
        temp.next = null;
    }

    public void deleteAtEnd(){
        if(head == null || head.next==null) {
            head = null;
            return;
        }
        ListNode<T> current = head;
        ListNode<T> previous = null;
        while(current.next != null){
            previous = current;
            current = current.next;
        }

        previous.next = null;
    }

    public void deleteAtGivenPos(int pos){


    }

    public void display(){
        ListNode<T> current = head;

        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("null");
    }
}
