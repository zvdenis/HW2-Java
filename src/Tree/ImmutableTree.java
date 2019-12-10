package Tree;/*
 * Created by Denis Zvyagintsev on 30.11.2019
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.BinaryOperator;

public class ImmutableTree<T extends Number> extends AbstractTree<T> {

    public ImmutableTree(ImmutableNode<T> root, BinaryOperator<T> sum, Comparator<T> comparator, T zero) {
        super(root, sum, comparator, zero);
    }

    class FoundElementWrapper {
        Node<T> elementToFind;
        Node<T> clonedElement;
    }

    @Override
    public AbstractTree<T> removeSubtree(Node<T> rootSubTree) {
        FoundElementWrapper wrapper = new FoundElementWrapper();
        wrapper.elementToFind = rootSubTree;
        ImmutableTree<T> newTree = clone(wrapper);

        if (wrapper.clonedElement.getParent() != null)
            wrapper.clonedElement.getParent().getChildren().remove(rootSubTree);

        return newTree;
    }

    @Override
    AbstractTree<T> maximize() {
        return null;
    }

    public ImmutableTree<T> clone(FoundElementWrapper wrapper) {
        ImmutableTree<T> newTree = new ImmutableTree<T>((ImmutableNode<T>) this.root, this.adder, this.comparator, this.zero);
        newTree.root = new ImmutableNode<T>((T) root.getValue(), (ImmutableNode<T>) null);
        ArrayList<Node<T>> bfs = new ArrayList<Node<T>>();
        ArrayList<Node<T>> bfsClone = new ArrayList<Node<T>>();
        if (root != null)
            bfs.add(root);
        bfsClone.add(newTree.root);
        for (int o = 0; o < bfs.size(); o++) {
            Node<T> i = bfs.get(o);
            Node<T> cloned = bfsClone.get(bfs.indexOf(i));
            if (i == wrapper.elementToFind) wrapper.clonedElement = cloned;
            for (var j : i.getChildren()) {
                if (j == null) continue;
                if (bfs.indexOf(j) != -1)
                    continue;
                Node<T> clonedChild = new ImmutableNode<T>((T) j.getValue(), (ImmutableNode<T>) cloned);
                cloned.getChildren().add(clonedChild);
                bfsClone.add(clonedChild);
                bfs.add(j);
            }
        }

        return newTree;
    }

}
