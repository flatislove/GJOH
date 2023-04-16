package task3;

public class SinglyLinkedListAction {
    public static Node reversal(Node head) {
        Node currentNode = head;
        Node previousNode = null;
        Node nextNode;

        while (currentNode != null) {
            nextNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    public static void print(Node head) {
        Node pointer = head;
        while (pointer != null) {
            System.out.print(pointer.getValue() + " ");
            pointer = pointer.getNext();
        }
        System.out.println();
    }
}
