package lesson4.linked_list;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private LinkedListLink<T> first;

    public LinkedList(){
        first = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insert(T link){
        LinkedListLink<T> l = new LinkedListLink<>(link);
        l.setNext(first);
        this.first = l;
    }

    public LinkedListLink<T> delete(){
        LinkedListLink<T> temp = first;
        first = first.getNext();
        return temp;
    }

    public void display(){
        LinkedListLink<T> current = first;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public T find(T searchNode){
        LinkedListLink<T> findNode = new LinkedListLink<>(searchNode);
        LinkedListLink<T> current = first;
        while (current != null) {
            if (current.getValue().equals(findNode.getValue())){
                return findNode.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {

        private LinkedListLink<T> item = first;

        @Override
        public boolean hasNext() {
            return item != null;
        }

        @Override
        public T next() {
            final LinkedListLink<T> current = item;
            item = item.getNext();
            return current.getValue();
        }
    }
}
