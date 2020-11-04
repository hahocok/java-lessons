package lesson5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(exponentiation(5, -2));

        final List<Item> listItem = new ArrayList<>();
        listItem.add(new Item("Книга", 600, 1));
        listItem.add(new Item("Бинокль", 5_000, 2));
        listItem.add(new Item("Аптечка", 1_500, 4));
        listItem.add(new Item("Ноутбук", 40_000, 2));
        listItem.add(new Item("Котелок", 500, 1));

        final Backpack backpack = new Backpack(4);
        backpack.calcBestSets(listItem);
        final List<Item> items = backpack.getBestItems();
        if (items != null) {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public static double exponentiation(double number, int rank) {
        if (number == 0) {
            if (rank > 0) {
                return 0;
            } else {
                throw new IllegalArgumentException("Invalid rank = " + rank);
            }
        }

        if (rank < 0) {
            return 1 / (number * exponentiation(number, -rank - 1));
        } else if (rank > 0) {
            return number * exponentiation(number, rank - 1);
        } else {
            return 1;
        }
    }
}
