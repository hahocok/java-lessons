package lesson4.queue;

public class Queue {
    private QueueLinkedList queue;

    public Queue(){
        queue = new QueueLinkedList();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void insert(String name, int age){
        queue.insert(name, age);
    }

    public String delete(){
        return queue.delete();
    }

    public void display(){
        queue.display();
    }

}
