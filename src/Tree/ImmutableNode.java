package Tree;

import java.util.ArrayList;
import java.util.Collection;

public class ImmutableNode<T extends Number> implements Node<T> {

    T value;
    ImmutableNode<T> parent;
    Collection<Node<T>> children;
    T childSum;
    private final static int bias = 2;

    public ImmutableNode(T value,
                         Collection<Node<T>> children, ImmutableNode<T> parent) {
        this.value = value;
        this.parent = parent;
        this.children = children;
    }

    public ImmutableNode(T value,
                         ImmutableNode<T> parent) {
        this.value = value;
        this.parent = parent;
        children = new ArrayList<Node<T>>();
    }

    public ImmutableNode(T value, Collection<Node<T>> children) {
        this(value, children, null);
    }


    @Override
    public T getChildsSum() {
        return childSum;
    }

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
    public Number getValue() {
        return value;
    }
}
