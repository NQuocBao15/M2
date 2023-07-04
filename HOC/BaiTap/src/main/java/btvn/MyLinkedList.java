package btvn;

public class MyLinkedList {
    private  Node head;
    private  int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes++;
    }
    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }
    public void add(int index, Object data) {
        Node temp = head;
        Node holder;

        for(int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        // holder ? temp?
        holder = temp.next;
//        temp.next = new Node(data);
        //        temp.next.next = holder;
        Node addNode = new Node(data);
        temp.next = addNode;
        addNode.next = holder;


        numNodes++;
    }
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(5);
        myLinkedList.addFirst(6);
        myLinkedList.addFirst(7);
        myLinkedList.addFirst(8);
    }
}
