import java.util.Collection;

public class ImutableNode<T extends Number> implements Node<T> {

    T value;
    ImutableNode<T> parent;
    Collection<Node<T>> children;

    public Node<T> getParent() {
        return parent;
    }

    @Override
    public Collection<Node<T>> getChildren() {
        return children;
    }

    @Override
    public void print(int indents) {

    }

    @Override
    public Number getValue() {
        return value;
    }
}
