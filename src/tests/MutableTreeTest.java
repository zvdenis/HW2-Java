/*
 * Created by Denis Zvyagintsev on 10.12.2019
 */
package tests;

import Tree.ImmutableNode;
import Tree.MutableNode;
import Tree.MutableTree;
import Tree.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

public class MutableTreeTest {

    public MutableTree<Integer> tree;
    public Node<Integer> nodeToDelete;

    @BeforeEach
    void initialize() {
        MutableNode<Integer> root = new MutableNode<Integer>(1, new ArrayList<Node<Integer>>());
        BinaryOperator<Integer> sum = (x, y) -> x + y;
        Comparator<Integer> comparator = Integer::compareTo;
        Integer zero = 0;
        MutableTree<Integer> tree = new MutableTree<Integer>(root, sum, comparator, zero);

        MutableNode<Integer> node2 = new MutableNode<Integer>(2, new ArrayList<Node<Integer>>(), root);
        MutableNode<Integer> node3 = new MutableNode<Integer>(3, new ArrayList<Node<Integer>>(), root);

        root.getChildren().add(node2);
        root.getChildren().add(node3);

        MutableNode<Integer> node4 = new MutableNode<Integer>(4, new ArrayList<Node<Integer>>(), root);
        MutableNode<Integer> node5 = new MutableNode<Integer>(5, new ArrayList<Node<Integer>>(), root);

        node5.getChildren().add(root);

        MutableNode<Integer> node6 = new MutableNode<Integer>(6, new ArrayList<Node<Integer>>(), root);
        MutableNode<Integer> node7 = new MutableNode<Integer>(7, new ArrayList<Node<Integer>>(), root);

        nodeToDelete = node2;
        node2.getChildren().add(node4);
        node2.getChildren().add(node7);
        node3.getChildren().add(node5);
        node4.getChildren().add(node6);
        this.tree = tree;
    }


    @Test
    void TestNonEmptyMutableTreeCreation() {
        tree.print();
        System.out.println("\n");
        assertNotEquals(tree, null);
    }

    @Test
    void TestSumMutableTree() {
        assertEquals(28, tree.getSum());
    }

    @Test
    void TestSizeMutableTree() {
        assertEquals(7, tree.getSize());
    }

    @Test
    void TestRemoveSubtreeMutableTree() {
        tree.print();
        System.out.println();
        tree.removeSubtree(nodeToDelete);
        tree.print();
        assertEquals(3, tree.getSize());
        assertEquals(9, tree.getSum());
        System.out.println("\n");
    }

    @Test
    void TestChangeValueMutableTree() {
        tree.print();
        System.out.println();

        for (Object child:tree.getRoot().getChildren()
             ) {
            ((MutableNode<Integer>)child).setValue(1);

        }
        tree.print();
        assertEquals(7, tree.getSize());
        assertEquals(25, tree.getSum());
        System.out.println("\n");
    }
}
