package lesson4.stack_list;

import lesson4.Link;

public class StackLinkedList {
    public Link first;

    public StackLinkedList(){
        first = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insert(String name, int age){
        Link newLink = new Link(name, age);
        newLink.next = first;
        first = newLink;
    }
    public Link delete(){
        Link temp = first;
        first = first.next;
        return temp;

    }

    public void display(){
        Link current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
    }

}
