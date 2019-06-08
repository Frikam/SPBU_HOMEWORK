package group144.tetin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/** A class that represent avl tree with collection interface */
public class AvlTree<T extends Comparable<T>> implements Collection<T> {
    private int size = 0;
    private Node root = null;

    /** A method that return size of avl tree */
    @Override
    public int size() {
        return size;
    }

    /** A method that checks avl tree is empty or no */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** A method that check object in avl tree or no */
    @Override
    public boolean contains(Object o) {
        return !isEmpty() && root.contains((T) o);
    }

    /** A method that turns a avl tree into an array */
    @Override
    public Object[] toArray() {
        return toArray(new Object[size]);
    }


    /** A method that turns a avl tree into an array */
    @Override
    public <T1> T1[] toArray(T1[] array) {
        ArrayList<T1> arrayList = new ArrayList<>();
        for (T temp : this) {
            arrayList.add((T1) temp);
        }

        return arrayList.toArray(array);
    }

    /** A method that checks all elements from the collection are contained in the avl tree or no */
    @Override
    public boolean containsAll(Collection<?> collection) {
        boolean result = true;

        for (Object object : collection) {
            result = result && contains(object);
        }

        return result;
    }

    /** A method that adds all elements from collection in avl tree */
    @Override
    public boolean addAll(Collection<? extends T> collection) {
        for (T i : collection) {
            add(i);
        }
        return !collection.isEmpty();
    }

    /** A method that deletes all elements from collection from avl tree */
    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean result = false;
        for (Object i : collection) {
            result = remove(i) || result;
        }
        return result;
    }

    /** A method that deletes elements which doesn't contain in a collection from avl tree */
    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean result = false;
        for (Object i : this) {
            if (!collection.contains(i)) {
                remove(i);
                result = true;
            }
        }
        return result;
    }

    /** A method that removes all elements from avl tree */
    @Override
    public void clear() {
        root = null;
        size = 0;

    }

    /** A method that return avl tree iterator */
    @Override
    public Iterator<T> iterator() {
        return new AvlTreeIterator();
    }

    private class AvlTreeIterator implements Iterator<T> {
        ArrayList<T> elements;

        AvlTreeIterator() {
            elements = new ArrayList<>();
            root.treeToArray(elements);
        }
        @Override
        public boolean hasNext() {
            return !elements.isEmpty();
        }

        @Override
        public T next() {
            if (isEmpty()) {
                return null;
            }

            return elements.remove(0);
        }
    }

    /** A method that add element in avl tree */
    @Override
    public boolean add(T value) {
        if (root == null) {
            root = new Node(value, null);
        }
        else {
            root.add(value);
        }
        size++;
        return true;
    }

    /** A method that remove element from avl tree */
    @Override
    public boolean remove(Object delValue) {
        if (root == null)
            return false;

        Node child = root;
        while (child != null) {
            Node node = child;
            child = ((T) delValue).compareTo(node.value) >= 0 ? node.right : node.left;
            if (delValue == node.value) {
                node.removeNode(node);
                size--;
                return true;
            }
        }
        return false;
    }

    /** A method that return avl tree in string */
    @Override
    public String toString() {
        return isEmpty() ? "null" : root.toString();
    }

    /** A class that represent avl tree node */
    private class Node {
        private T value;
        private int balance;
        private int height;
        private Node left;
        private Node right;
        private Node parent;

        Node(T value, Node parent) {
            this.value = value;
            this.parent = parent;
        }

        /** A method that adds element in avl tree */
        public void add(T value) {
            if (root == null) {
                root = new Node(value, null);
            }

            Node n = root;
            while (true) {

                Node parent = n;

                boolean goLeft = n.value.compareTo(value) > 0;
                n = goLeft ? n.left : n.right;

                if (n == null) {
                    if (goLeft) {
                        parent.left = new Node(value, parent);
                    } else {
                        parent.right = new Node(value, parent);
                    }
                    rebalance(parent);
                    break;
                }
            }
        }

        /** A method that checks if the value is in the tree */
        public boolean contains(T value) {
            if (value.equals(this.value)) {
                return true;
            }

            if (value.compareTo(this.value) < 0) {
                return (left != null) && left.contains(value);
            } else {
                return (right != null) && right.contains(value);
            }
        }

        /** A method that removes element from avl tree */
        private void removeNode(Node node) {
            if (node.left == null && node.right == null) {
                if (node.parent == null) {
                    root = null;
                } else {
                    Node parent = node.parent;
                    if (parent.left == node) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                    rebalance(parent);
                }
                return;
            }

            if (node.left != null) {
                Node child = node.left;
                while (child.right != null) child = child.right;
                node.value = child.value;
                child.removeNode(child);
            } else {
                Node child = node.right;
                while (child.left != null) child = child.left;
                node.value = child.value;
                child.removeNode(child);
            }
        }

        /** A method that */
        private void rebalance(Node n) {
            setBalance(n);

            if (n.balance == -2) {
                if (height(n.left.left) >= height(n.left.right))
                    n = rotateRight(n);
                else
                    n = rotateLeftThenRight(n);

            } else if (n.balance == 2) {
                if (height(n.right.right) >= height(n.right.left))
                    n = rotateLeft(n);
                else
                    n = rotateRightThenLeft(n);
            }

            if (n.parent != null) {
                rebalance(n.parent);
            } else {
                root = n;
            }
        }

        /** A method that make left rotate of node */
        private Node rotateLeft(Node a) {

            Node b = a.right;
            b.parent = a.parent;

            a.right = b.left;

            if (a.right != null)
                a.right.parent = a;

            b.left = a;
            a.parent = b;

            if (b.parent != null) {
                if (b.parent.right == a) {
                    b.parent.right = b;
                } else {
                    b.parent.left = b;
                }
            }

            setBalance(a, b);

            return b;
        }

        /** A method that make right rotate of node */
        private Node rotateRight(Node a) {

            Node b = a.left;
            b.parent = a.parent;

            a.left = b.right;

            if (a.left != null)
                a.left.parent = a;

            b.right = a;
            a.parent = b;

            if (b.parent != null) {
                if (b.parent.right == a) {
                    b.parent.right = b;
                } else {
                    b.parent.left = b;
                }
            }

            setBalance(a, b);

            return b;
        }

        /** A method that make left rotate and then right rotate of node */
        private Node rotateLeftThenRight(Node n) {
            n.left = rotateLeft(n.left);
            return rotateRight(n);
        }

        /** A method that make right rotate and then left rotate of node */
        private Node rotateRightThenLeft(Node n) {
            n.right = rotateRight(n.right);
            return rotateLeft(n);
        }

        /** A method that return height of node */
        private int height(Node n) {
            if (n == null) {
                return -1;
            }
            return n.height;
        }

        /** A method that set the balance of nodes */
        private void setBalance(Node... nodes) {
            for (Node n : nodes) {
                reheight(n);
                n.balance = height(n.right) - height(n.left);
            }
        }

        /** A method that updates a height of the element */
        private void reheight(Node node) {
            if (node != null) {
                node.height = 1 + Math.max(height(node.left), height(node.right));
            }
        }

        /** A method that converts node to string */
        public String toString() {
            String result = "(" + value.toString() + " ";
            result += left != null ? left.toString() : "null";
            result += " ";
            result += right != null ? right.toString() : "null";
            result += ")";
            return result;
        }

        /** A method that adds elements from tree to array list */
        public void treeToArray(ArrayList<T> list) {
            if (left != null) {
                left.treeToArray(list);
            }
            list.add(this.value);
            if (right != null) {
                right.treeToArray(list);
            }
        }
    }
}