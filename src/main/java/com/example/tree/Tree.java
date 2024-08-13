package com.example.tree;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Tree<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> root;

    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        Node(T value) {
            this.value = value;
        }
    }

    public void add(T value) {
        root = addRecursive(root, value);
    }

    private Node<T> addRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.value) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    @Override
    public Iterator<T> iterator() {
        return new TreeIterator();
    }

    private class TreeIterator implements Iterator<T> {
        private Node<T> next;
        private final java.util.Stack<Node<T>> stack = new java.util.Stack<>();

        TreeIterator() {
            next = root;
        }

        @Override
        public boolean hasNext() {
            return next != null || !stack.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            while (next != null) {
                stack.push(next);
                next = next.left;
            }

            next = stack.pop();
            T value = next.value;
            next = next.right;

            return value;
        }
    }
}