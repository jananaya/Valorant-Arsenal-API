package types;

public class BinaryTree<E> {
    private BinaryTree left;
    private BinaryTree right;
    private E data;

    public BinaryTree(E dato) {
        this.data = dato;
    }
    
    public BinaryTree<E> left() {
        return this.left;
    }

    public BinaryTree<E> right() {
        return this.right;
    }

    public void linkLeft(BinaryTree<E> x) {
        this.left = x;
    }

    public void linkRight(BinaryTree x) {
        this.right = x;
    }

    public E getData() {
        return this.data;
    }

    public void shift(E x) {
        this.data = x;
    }
}