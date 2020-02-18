package data.structure.BST;

/**
 * Created by dell on 2020/2/18.
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    public BinaryNode<AnyType> root;

    public void inOrderPrint(BinaryNode<AnyType> root){
        if (root == null)
            return;
        inOrderPrint(root.left); // 这个执行完
        System.out.println(root.element);
        inOrderPrint(root.right);
    }

    public boolean contains(AnyType element){
        return false;
    }

}
