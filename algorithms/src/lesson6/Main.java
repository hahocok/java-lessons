package lesson6;

import java.util.Random;

public class Main {
    private static final int MIN_RANGE = -100;
    private static final int MAX_RANGE = 100;
    private static final int TREE_COUNT = 20;
    private static final int TREE_MAX_LEVEL = 6;

    public static void main(String[] args) {

        int balancedTreeCount = 0;

        for (int i = 0; i < TREE_COUNT; i++) {
            Tree<Integer> theTree = initTree();

            System.out.println("tree #" + (i + 1));
            final boolean isBalance = theTree.isBalanced();
            System.out.println("isBalance ? = " + isBalance);
            theTree.display();
        }

        System.out.println("Balanced Tree Count = " + ((balancedTreeCount / (TREE_COUNT * 1.0)) * 100) + "%");

    }

    private static Tree initTree() {
        int nodeCount = (int) (Math.pow(2, TREE_MAX_LEVEL) - 1);
        Tree<Integer> theTree = new Tree<>(TREE_MAX_LEVEL);

        for (int i = 0; i < nodeCount; ++i) {
            theTree.add(getRandomNumberInRange(MIN_RANGE, MAX_RANGE));
        }
        return theTree;
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        final Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
