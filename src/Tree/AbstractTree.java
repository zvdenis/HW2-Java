package Tree;/*
 * Created by Denis Zvyagintsev on 30.11.2019
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.function.BinaryOperator;

abstract public class AbstractTree<T extends Number> {
    Node<T> root;
    BinaryOperator<T> adder;
    T sum;
    Comparator<T> comparator;
    T zero;
    HashSet<Node<T>> was;


    public Node<T> getRoot() {
        return root;
    }

    public AbstractTree(Node<T> root, BinaryOperator<T> adder, Comparator<T> comparator, T zero) {
        this.root = root;
        this.adder = adder;
        this.comparator = comparator;
        this.zero = zero;
    }

    public int getSize() {
        ArrayList<Node<T>> bfs = new ArrayList<Node<T>>();
        if (root != null)
            bfs.add(root);

        for (int i = 0;i < bfs.size();i++) {
            for (var j : bfs.get(i).getChildren()) {
                if (j == null) continue;
                if (bfs.indexOf(j) != -1)
                    continue;
                bfs.add(j);
            }
        }
        return bfs.size();
    }

    public T getSum() {
        was = new HashSet<Node<T>>();
        was.add(root);
        sum = getSum(root);
        return sum;
    }

    void updateNodesSum(Node<T> root) {
        was = new HashSet<Node<T>>();
        getSum(root);
    }

    T getSum(Node<T> cur) {
        T currentSum = (T) cur.getValue();

        for (Node<T> child : cur.getChildren()) {
            if(!was.contains(child)) {
                was.add(child);
                T childsSum = getSum(child);
                currentSum = adder.apply(currentSum, childsSum);
            }
        }

        return currentSum;
    }


    public abstract AbstractTree<T> removeSubtree(Node<T> rootSubTree);

    abstract AbstractTree<T> maximize();

    public void print() {
        was = new HashSet<Node<T>>();
        if (root != null)
            print(root, 0);
    }

    private void print(Node<T> cur, int depth) {
        if (was.contains(cur))
            return;
        was.add(cur);

        cur.print(depth);

        for (Node<T> child : cur.getChildren()) {
            print(child, depth + 1);
        }
    }
}
