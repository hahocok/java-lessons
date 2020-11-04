package lesson4;

import lesson4.link_iterator.IteratorLinkedList;
import lesson4.link_iterator.LinkIterator;
import lesson4.linked_list.LinkedList;
import lesson4.queue.Queue;
import lesson4.stack_list.StackList;

public class Main {
    public static void main(String[] args) {
        testLinkedList();

        testTwoSideLinkedList();

        testStackList();

        testQueue();

        testIteratorLinkedList();
    }

    private static void testLinkedList() {
        System.out.println("-----LinkedList-----");
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.insert("Artem");
        linkedList.insert("Roman");

        System.out.println(linkedList.find("Artem"));

        LinkedList<People> peopleList = new LinkedList<>();
        peopleList.insert(new People("Artem", 22));
        peopleList.insert(new People("Roman", 18));

        System.out.println(peopleList.find(new People("Artem", 22)).toString());

        for (String value : linkedList) {
            System.out.println(value);
        }
    }

    private static void testTwoSideLinkedList() {
        System.out.println("-----TwoSideLinkedList-----");
        TwoSideLinkedList twoSideLinkedList = new TwoSideLinkedList();
        twoSideLinkedList.insert("Artem", 30);
        twoSideLinkedList.insert("Misha", 10);
        twoSideLinkedList.insert("Vova", 5);
        twoSideLinkedList.insertLast("Petya", 25);

        twoSideLinkedList.display();
        System.out.println("Удаление элементов списка");

        twoSideLinkedList.delete("Vova");
        twoSideLinkedList.display();
    }

    private static void testStackList() {
        System.out.println("-----StackList-----");
        StackList sl = new StackList();
        sl.push("Artem", 30);
        sl.push("Viktor", 20);
        sl.push("Sergey", 10);
        sl.display();
        while (!sl.isEmpty()) {
            System.out.println("Элемент "+ sl.pop()+" удален из стека");
        }
    }

    private static void testQueue() {
        System.out.println("-----Queue-----");
        Queue q = new Queue();
        q.insert("Artem", 30);
        q.insert("Viktor", 20);
        q.insert("Sergey", 10);
        q.display();
        while (!q.isEmpty()) {
            System.out.println("Элемент "+ q.delete()+" удален из стека");
        }
    }

    private static void testIteratorLinkedList() {
        System.out.println("-----IteratorLinkedList-----");
        IteratorLinkedList list = new IteratorLinkedList();

        LinkIterator itr = new LinkIterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);

        list.display();
    }
}
