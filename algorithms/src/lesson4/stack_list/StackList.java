package lesson4.stack_list;

public class StackList {
    private StackLinkedList list;

    public StackList(){
        list = new StackLinkedList();
    }

    public void push(String name, int age){
        list.insert(name, age);
    }

    public String pop(){
        return list.delete().name;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void display(){
        list.display();
    }

}
