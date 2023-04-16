package au.edu.usc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Node<T> {

    T data;
    Node<T> parent;
    List<Node<T>> children;

    public Node(T data) {
        this.data = data; //Adding data to node.
        this.children = new LinkedList<Node<T>>(); //Creating a list to store children nodes.
    }

    public boolean isRoot() { //The node is a root node if it doesn't have a parent.
        return parent == null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void addChild(Node<T> child) {
        child.parent = this; //Set child nodes parent.
        this.children.add(child); //Adding a child to this node.
    }

    @Override
    public String toString() {
        return data != null ? data.toString() : "Data NULL";
    }
}