package lesson5;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private final double size;
    private int bestPrice;
    private List<Item> bestItems;


    public Backpack(double size) {
        this.size = size;
    }

    private int calcWeight(List<Item> items) {
        int sumWeight = 0;

        for (Item item: items) {
            sumWeight += item.getWeight();
        }
        return sumWeight;
    }

    private int calcPrice(List<Item> items) {
        int sumPrice = 0;

        for (Item item: items) {
            sumPrice += item.getPrice();
        }
        return sumPrice;
    }

    private void checkBestSet(List<Item> items) {
        if (bestItems == null) {
            if (calcWeight(items) <= size) {
                bestItems = items;
                bestPrice = calcPrice(items);
            }
        } else {
            if(calcWeight(items) <= size && calcPrice(items) > bestPrice) {
                bestItems = items;
                bestPrice = calcPrice(items);
            }
        }
    }

    public void calcBestSets(List<Item> items) {
        if (items.size() > 0) {
            checkBestSet(items);
        }

        for (int i = 0; i < items.size(); i++) {
            List<Item> newSet = new ArrayList<>(items);
            newSet.remove(i);
            calcBestSets(newSet);
        }
    }

    public List<Item> getBestItems() {
        return bestItems;
    }
}
