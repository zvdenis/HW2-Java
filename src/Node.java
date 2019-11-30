import java.util.Collection;

public interface Node<T extends Number> extends Wrapper{
    Node<T> getParent();
    Collection<Node<T>> getChildren();
    void print(int indents);
}
