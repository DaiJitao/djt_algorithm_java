package data.structure.BST;

/**
 * Created by dell on 2020/2/18.
 */
public class BinaryNode<AnyType> {
    public BinaryNode<AnyType> left;
    public BinaryNode<AnyType> right;
    public AnyType element;

    public BinaryNode(AnyType theElement) {
        this.element = theElement;
    }

    public BinaryNode(AnyType theElement, BinaryNode left, BinaryNode right){
        this.element = theElement;
        this.left = left;
        this.right = right;
    }
}
