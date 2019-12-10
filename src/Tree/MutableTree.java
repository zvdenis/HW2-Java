package Tree;/*
 * Created by Denis Zvyagintsev on 30.11.2019
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.BinaryOperator;

public class MutableTree<T extends Number> extends AbstractTree{
    public MutableTree(MutableNode<T> root, BinaryOperator<T> sum, Comparator<T> comparator, T zero) {
        super(root, sum, comparator, zero);
    }



    @Override
    public AbstractTree removeSubtree(Node rootSubTree) {
        if(rootSubTree.getParent() != null)
            rootSubTree.getParent().getChildren().remove(rootSubTree);
        return this;
    }

    @Override
    AbstractTree maximize() {
        return null;
    }

    void removeNegativeLeafs(){
        ArrayList<Node<T>> bfs = new ArrayList<Node<T>>();
        bfs.add(this.getRoot());
    }
}
