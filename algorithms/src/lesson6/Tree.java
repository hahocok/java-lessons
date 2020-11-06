package lesson6;

import java.util.Stack;

public class Tree<E extends Comparable<? super E>> {
    private Node<E> root;
    private int size;
    private final int maxLevel;

    public Tree(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public boolean add(E value) {
        if (!isCanAdd()) {
            return false;
        }

        Node<E> node = new Node<>(value);

        NodeAndParent nodeAndParent = doFind(value);
        Node<E> previous = nodeAndParent.parent;

        if (nodeAndParent.isEmpty()) {
            this.root = node;
            return true;
        } else if (nodeAndParent.current != null) {
            return false;
        } else if (previous.shouldBeLeft(value)) {
            previous.setLeftChild(node);
        } else {
            previous.setRightChild(node);
        }

        if (maxLevel != 0 && maxLevel < height(root)) {
            remove(value);
            return false;
        } else {
            size++;
        }

        return true;
    }

    public boolean isCanAdd() {
        if (size >= Math.pow(2, maxLevel) - 1) {
            return false;
        }

        if (size == 0) {
            return true;
        }

        return height(root) <= maxLevel;
    }

    private NodeAndParent doFind(E value) {
        if (isEmpty()) {
            return new NodeAndParent(null, null, 0);
        }

        Node<E> parent = null;
        Node<E> current = this.root;
        int level = 0;
        do {
            if (current.getValue().equals(value)) {
                return new NodeAndParent(current, parent, level);
            }

            parent = current;
            level++;
            if (current.shouldBeLeft(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        } while (current != null);

        return new NodeAndParent(null, parent, level);
    }

    public boolean remove(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> parent = nodeAndParent.parent;
        Node<E> removedNode = nodeAndParent.current;

        if (removedNode == null) {
            return false;
        }
        else if (removedNode.isLeaf()) {
            removeLeafNode(parent, removedNode);
        }
        else if ( removedNode.hasOnlySingleChild() ) {
            removeNodeWithSingleChild(parent, removedNode);
        }
        else {
            removeCommonNode(parent, removedNode);
        }

        size--;
        return true;
    }

    private void removeCommonNode(Node<E> parent, Node<E> removedNode) {
        Node<E> successor = getSuccessor(removedNode);
        if (removedNode == root) {
            root = successor;
        }
        else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(successor);
        }
        else {
            parent.setRightChild(successor);
        }

        successor.setLeftChild(removedNode.getLeftChild());
    }

    private Node<E> getSuccessor(Node<E> removedNode) {
        Node<E> successor = removedNode;
        Node<E> successorParent = null;
        Node<E> current = removedNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != removedNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }

        return successor;
    }

    private void removeNodeWithSingleChild(Node<E> parent, Node<E> removedNode) {
        Node<E> childNode;

        if (removedNode.getLeftChild() != null) {
            childNode = removedNode.getLeftChild();
        } else {
            childNode = removedNode.getRightChild();
        }

        if (removedNode == root) {
            root = childNode;
        }
        else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(childNode);
        }
        else {
            parent.setRightChild(childNode);
        }
    }

    private void removeLeafNode(Node<E> parent, Node<E> removedNode) {
        if (removedNode == root) {
            root = null;
        }
        else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(null);
        }
        else {
            parent.setRightChild(null);
        }
    }

    public void display() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................" +
                "................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................" +
                "................................................................");
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private int height(Node node) {
        if (node != null) {
            return 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
        } else {
            return 0;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    private class NodeAndParent {
        Node<E> current;
        Node<E> parent;
        int parentLevel;

        public NodeAndParent(Node<E> current, Node<E> parent, int parentLevel) {
            this.current = current;
            this.parent = parent;
            this.parentLevel = parentLevel;
        }

        public boolean isEmpty() {
            return current == null && parent == null;
        }
    }
}
