package Tree;

import java.util.ArrayList;
import java.util.Collection;

public class MutableNode<T extends Number> implements Node<T> {

    private static final int bias = 2;
    T value;
    MutableNode<T> parent;
    Collection<Node<T>> children;
    T childSum;


    public MutableNode(T value, ArrayList<Node<T>> children, MutableNode<T> parent) {
        this.value = value;
        this.children = children;
        this.parent = parent;
    }

    public MutableNode(T value, ArrayList<Node<T>> children) {
        this(value, children, null);
    }

    @Override
    public Node<T> getParent() {
        return parent;
    }

    @Override
    public Collection<Node<T>> getChildren() {
        return children;
    }

    @Override
    public void print(int indents) {
        for (int i = 0; i < indents; i++)
            for (int j = 0; j < bias; j++)
                System.out.print(" ");

        System.out.println(this.value);
    }

    @Override
    public T getChildsSum() {
        return childSum;
    }

    @Override
    public Number getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setParent(MutableNode<T> parent) {
        this.parent = parent;
    }

    public void setChildren(Collection<Node<T>> children) {
        this.children = children;
    }

    public void addChild(MutableNode<T> child) {
        children.add(child);
    }

    public void removeChild(MutableNode<T> child) {
        children.remove(child);
    }
}
