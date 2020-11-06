package lesson8;

public class Main {
    public static void main(String[] args) {
        HashTable<Item, Integer> hashTable = new LinkedHashTableImpl<>(5);
        Item orange = new Item(1, "Orange", 150);
        Item banana = new Item(71, "Banana", 100);
        Item lemon = new Item(60, "Lemon", 250);
        Item milk = new Item(52, "Milk", 120);
        Item potato = new Item(21, "Potato", 67);

        hashTable.put(orange, orange.getCost());
        hashTable.put(banana, banana.getCost());
        hashTable.put(lemon, lemon.getCost());
        hashTable.put(milk, milk.getCost());
        hashTable.put(potato, potato.getCost());

        System.out.println("Size is " + hashTable.size());
        System.out.println(hashTable.get(lemon));
        hashTable.display();
        hashTable.remove(milk);
        hashTable.display();

    }
}
