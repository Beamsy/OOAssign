package co.uk.beamsy.ooassign.utils;

public class List<T> {
    private ListItem<T> first;
    private ListItem<T> last;
    private List() {

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
    }

    public T getLast() {
        return last.data;
    }

    private class ListItem<T>{

        private ListItem next;
        private ListItem previous;
        private T data;

        public ListItem(T data, ListItem previous) {
            this.data = data;
            this.previous = previous;
        }

        public void setNext(ListItem next) {
            this.next = next;
        }
    }

}