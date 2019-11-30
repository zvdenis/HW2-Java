import java.util.Collection;

public class MutableNode<T extends Number> implements Node<T>{

    T value;
    MutableNode<T> parent;
    Collection<Node<T>> children;

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

    public void addChild(MutableNode<T> child){
        children.add(child);
    }

    public void removeChild(MutableNode<T> child){
        children.remove(child);
    }
}
