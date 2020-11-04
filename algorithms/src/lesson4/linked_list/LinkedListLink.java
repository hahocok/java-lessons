package lesson4.linked_list;

class LinkedListLink<E> {
    private E link;
    private LinkedListLink<E> next;

    public LinkedListLink(E link){
        this.link = link;
    }

    public LinkedListLink<E> getNext() {
        return next;
    }

    public void setNext(LinkedListLink<E> next) {
        this.next = next;
    }

    public E getValue(){
        return link;
    }
}

