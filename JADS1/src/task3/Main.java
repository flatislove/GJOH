package task3;

public class Main {
    public static void main(String[] args) {

        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));

        SinglyLinkedListAction.print(head);

        head = SinglyLinkedListAction.reversal(head);

        SinglyLinkedListAction.print(head);
    }
}