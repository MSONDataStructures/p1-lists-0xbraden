public class MyArrayList {
    private Integer[] list;
    private int size;

    // init list w/ size 10
    public MyArrayList() {
        list = new Integer[10];
        size = 0;
    }

    // add item to end of list
    public void addLast(Integer item) {
        if (item == null) throw new NullPointerException();
        ensureCapacity();
        list[size++] = item;
    }

    // check if theres enough capacity, if not it just doubnbles it
    private void ensureCapacity() {
        if (size == list.length) {
            Integer[] newList = new Integer[list.length * 2];
            System.arraycopy(list, 0, newList, 0, list.length);
            list = newList;
        }
    }

    // insert into index
    public void add(int index, Integer item) {
        if (item == null) throw new NullPointerException();
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity();
        System.arraycopy(list, index, list, index + 1, size - index);
        list[index] = item;
        size++;
    }

    // remove item in index, also returns it
    public Integer remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Integer removed = list[index];
        System.arraycopy(list, index + 1, list, index, size - index - 1);
        size--;
        list[size] = null;
        return removed;
    }

    // returns what is in given index
    public Integer get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return list[index];
    }

    // replace item in index with the item given
    public void set(int index, Integer item) {
        if (item == null) throw new NullPointerException();
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        list[index] = item;
    }

    // returns size of list
    public int size() {
        return size;
    }

    // return first index of an item
    public int indexOf(Integer item) {
        if (item == null) throw new NullPointerException();
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) return i;
        }
        return -1;
    }

    // check if list has item
    public boolean contains(Integer x) {
        return indexOf(x) != -1;
    }

    // clear list
    public void clear() {
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0;
    }

    // check if list is empty
    public boolean isEmpty() {
        return size == 0;
    }
}
