public class MyLinkedList {
    private static class Node {
        public Integer value;
        public Node next;

        public Node(Integer value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node first;
    private int size;

    // init empty list
    public MyLinkedList() {
        first = null;
        size = 0;
    }

    // add item to beginning
    public void addFirst(Integer item) {
        if (item == null) throw new NullPointerException();
        Node newNode = new Node(item);
        newNode.next = first;
        first = newNode;
        size++;
    }

    // insert item to index
    public void add(int index, Integer item) {
        if (item == null) throw new NullPointerException();
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(item);
            return;
        }
        Node previous = getNode(index - 1);
        Node newNode = new Node(item);
        newNode.next = previous.next;
        previous.next = newNode;
        size++;
    }

    // remove item at index and return it
    public Integer remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            Integer removedValue = first.value;
            first = first.next;
            size--;
            return removedValue;
        }
        Node previous = getNode(index - 1);
        Integer removedValue = previous.next.value;
        previous.next = previous.next.next;
        size--;
        return removedValue;
    }

    // return whats at index
    public Integer get(int index) {
        return getNode(index).value;
    }

    // return node at index
    private Node getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // replace index with given item
    public void set(int index, Integer item) {
        if (item == null) throw new NullPointerException();
        getNode(index).value = item;
    }

    // list size
    public int size() {
        return size;
    }

    // index of first instance of item
    public int indexOf(Integer item) {
        if (item == null) throw new NullPointerException();
        Node current = first;
        for (int i = 0; i < size; i++) {
            if (current.value.equals(item)) return i;
            current = current.next;
        }
        return -1;
    }

    // checks if list has item
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    // clear list
    public void clear() {
        first = null;
        size = 0;
    }

    // check empty
    public boolean isEmpty() {
        return size == 0;
    }
}
