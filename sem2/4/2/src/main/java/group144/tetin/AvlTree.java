package group144.tetin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class AvlTree<T extends Comparable<T>> implements Collection<T> {
    private int size = 0;
    private Node root = null;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return !isEmpty() && root.contains((T) o);
    }

    @Override
    public Object[] toArray() {
        ArrayList<T> elements = new ArrayList<>();
        root.addAll(elements, root);

        return elements.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] array) {
        ArrayList<T1> arrayList = new ArrayList<>();
        for (T temp : this) {
            arrayList.add((T1) temp);
        }

        return arrayList.toArray(array);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        boolean result = true;

        for (Object object : collection) {
            result = result && contains(object);
        }

        return result;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        for (T i : collection) {
            add(i);
        }
        return !collection.isEmpty();
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean result = false;
        for (Object i : collection) {
            result = remove(i) || result;
        }
        return result;
    }

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

    @Override
    public void clear() {
        root = null;
        size = 0;

    }

    @Override
    public Iterator<T> iterator() {
        return new AvlTreeIterator();
    }

    private class AvlTreeIterator implements Iterator<T> {
        ArrayList<T> elements;

        AvlTreeIterator() {
            elements = new ArrayList<>();
            root.addAll(elements, root);

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

    @Override
    public String toString() {
        return isEmpty() ? "null" : root.toString();
    }

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

        private Node rotateLeftThenRight(Node n) {
            n.left = rotateLeft(n.left);
            return rotateRight(n);
        }

        private Node rotateRightThenLeft(Node n) {
            n.right = rotateRight(n.right);
            return rotateLeft(n);
        }

        private int height(Node n) {
            if (n == null)
                return -1;
            return n.height;
        }

        private void setBalance(Node... nodes) {
            for (Node n : nodes) {
                reheight(n);
                n.balance = height(n.right) - height(n.left);
            }
        }

        private void reheight(Node node) {
            if (node != null) {
                node.height = 1 + Math.max(height(node.left), height(node.right));
            }
        }

        public String toString() {
            String result = "(" + value.toString() + " ";
            result += left != null ? left.toString() : "null";
            result += " ";
            result += right != null ? right.toString() : "null";
            result += ")";
            return result;
        }

        private void addAll(ArrayList<T> elements, Node current) {
            if (current == null) {
                return;
            }

            current.addAll(elements, current.left);
            elements.add(current.value);
            current.addAll(elements, current.right);
        }
    }
}