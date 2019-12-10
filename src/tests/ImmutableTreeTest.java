/*
 * Created by Denis Zvyagintsev on 10.12.2019
 */
package tests;

import Tree.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

public class ImmutableTreeTest {

    public ImmutableTree<Integer> tree;
    public Node<Integer> nodeToDelete;

    @BeforeEach
    void initialize() {
        ImmutableNode<Integer> root = new ImmutableNode<Integer>(1, new ArrayList<Node<Integer>>());
        BinaryOperator<Integer> sum = (x, y) -> x + y;
        Comparator<Integer> comparator = Integer::compareTo;
        Integer zero = 0;
        ImmutableTree<Integer> tree = new ImmutableTree<Integer>(root, sum, comparator, zero);

        ImmutableNode<Integer> node2 = new ImmutableNode<Integer>(2,new ArrayList<Node<Integer>>(), root);
        ImmutableNode<Integer> node3 = new ImmutableNode<Integer>(3,new ArrayList<Node<Integer>>(), root);

        root.getChildren().add(node2);
        root.getChildren().add(node3);

        ImmutableNode<Integer> node4 = new ImmutableNode<Integer>(4,new ArrayList<Node<Integer>>(), root);
        ImmutableNode<Integer> node5 = new ImmutableNode<Integer>(5,new ArrayList<Node<Integer>>(), root);

        node5.getChildren().add(root);

        ImmutableNode<Integer> node6 = new ImmutableNode<Integer>(6,new ArrayList<Node<Integer>>(), root);
        ImmutableNode<Integer> node7 = new ImmutableNode<Integer>(7,new ArrayList<Node<Integer>>(), root);

        node2.getChildren().add(node4);
        nodeToDelete = node2;
        node2.getChildren().add(node7);
        node3.getChildren().add(node5);
        node4.getChildren().add(node6);
        this.tree = tree;
    }


    @Test
    void TestNonEmptyMutableTreeCreation() {
        tree.print();

        assertNotEquals(tree, null);
    }

    @Test
    void TestSumMutableTree(){
        assertEquals(28, tree.getSum());
    }

    @Test
    void TestSizeMutableTree(){
        assertEquals(7, tree.getSize());
    }


    @Test
    void TestRemoveSubtreeMutableTree() {
        System.out.println("Tree before delete");
        tree.print();
        System.out.println();
        ImmutableTree<Integer> newTree = (ImmutableTree<Integer>) tree.removeSubtree(nodeToDelete);
        System.out.println("Tree after delete");
        tree.print();
        System.out.println("cloned tree after delete");
        newTree.print();
        assertEquals(3, newTree.getSize());
        assertEquals(9, newTree.getSum());
        System.out.println("\n");
    }
}
