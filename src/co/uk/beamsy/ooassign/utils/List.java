package co.uk.beamsy.ooassign.utils;

import java.lang.reflect.Array;

public class List<T> {
    private ListItem<T> first;
    private ListItem<T> last;
    private int count;

    public List() {
        count = 0;
    }

    public List<T> fromArray(T[] arr) {
        for (int i =0; i < arr.length; i++) {
            this.addItem(arr[i]);
        }
        return this;
    }

    public T[] toArray (Class<T> clazz) {
        T[] a = (T[]) Array.newInstance(clazz, count);
        return a;
    }

    public void addItem (T item) {
        if (last != null) {
            ListItem newItem = new ListItem(item, last);
            last.setNext(newItem);
            last = newItem;
        } else {
            last = new ListItem(item, null);
            first = last;
        }
        count++;
    }

    public T getFirst () {
        return first.data;
    }

    public T get (int index) {

        return getItem(index).data;
    }

    private ListItem<T> getItem (int index) {
        ListItem<T> item = first;
        for (int i = 0; i < index; i++) {
            item = item.next;
        }
        return item;
    }

    public T getLast() {
        return last.data;
    }

    public int getCount() {
        return count;
    }

    public void removeItemAtIndex (int index) {
        ListItem item = getItem(index);
        item.previous.setNext(item.next);
        item.next.setPrevious(item.previous);
        count--;
    }

    public void replaceItemAtIndex (int index) {

    }

    private class ListItem<T>{

        private ListItem next;
        private ListItem previous;
        private T data;

        public ListItem(T data, ListItem previous) {
            this.data = data;
            this.previous = previous;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(ListItem next) {
            this.next = next;
        }

        public void setPrevious(ListItem previous) {
            this.previous = previous;
        }
    }

}