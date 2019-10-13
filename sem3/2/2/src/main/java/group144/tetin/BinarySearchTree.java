package group144.tetin;


import java.util.ArrayList;
import java.util.Iterator;

/** A class that represent binary search tree with iterator */
public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {
    private TreeNode root = null;
    private int size = 0;

    /** A method that returns size of tree */
    public int size() {
        return size;
    }

    /** A method that checks tree is empty or no */
    public boolean isEmpty() {
        return size == 0;
    }

    /** A method that add element in tree */
    public void add(T value) {
        size++;
        if (root == null) {
            root = new TreeNode(value, null);
        } else {
            root.addNode(value);
        }
    }

    /** A method that delete element from tree */
    public boolean delete(T value) {
        if (contains(value)) {
            if (size == 1) {
                root = null;
            } else {
                root.deleteNode(value);
            }
            size--;
            return true;
        }
        return false;
    }

    /** A method that checks element in tree or no */
    public boolean contains(T value) {
        return !isEmpty() && root.containsNode(value);
    }

    /** A method that turn tree to string */
    public String toString() {
        return !isEmpty() ? root.toString() : "null";
    }

    /** A method that return avl tree iterator */
    @Override
    public Iterator<T> iterator() {
        return new treeIterator();
    }

    public class treeIterator implements Iterator<T> {
        ArrayList<T> elements;

        treeIterator() {
            elements = new ArrayList<>();
            root.treeToArray(elements);
        }

        @Override
        public boolean hasNext() {
            return !elements.isEmpty();
        }

        @Override
        public T next() {
            if (elements.isEmpty()) {
                return null;
            }

            if (!root.containsNode(elements.get(0))) {
                elements.remove(0);
                return next();
            }

            return elements.remove(0);
        }

        @Override
        public void remove() {
            root.deleteNode(next());
        }
    }


    private class TreeNode {
        private T value;
        private TreeNode parent;
        private TreeNode leftChild = null;
        private TreeNode rightChild = null;

        TreeNode(T value, TreeNode parent) {
            this.value = value;
            this.parent = parent;
        }

        private void addNode(T value) {
            if (value.compareTo(this.value) < 0) {
                if (leftChild != null) {
                    leftChild.addNode(value);
                } else {
                    leftChild = new TreeNode(value, this);
                }
            } else if (value.compareTo(this.value) > 0) {
                if (rightChild != null) {
                    rightChild.addNode(value);
                } else {
                    rightChild = new TreeNode(value, this);
                }
            } else {
                size--;
            }
        }

        private void deleteNode(T value) {
            if (this.value.equals(value)) {
                if (leftChild == null && rightChild == null) {
                    if (this.parent.leftChild .value.equals(this.value)) {
                        this.parent.leftChild = null;
                    } else {
                        this.parent.rightChild = null;
                    }
                } else if (rightChild == null) {
                    this.value = this.leftChild .value;
                    rightChild = this.leftChild .rightChild;
                    leftChild = this.leftChild .leftChild ;
                } else if (leftChild == null) {
                    this.value = this.rightChild.value;
                    leftChild = this.rightChild.leftChild ;
                    rightChild = this.rightChild.rightChild;
                } else {
                    TreeNode newNode = this.leftChild ;

                    while (newNode.rightChild != null) {
                        newNode = newNode.rightChild;
                    }

                    this.value = newNode.value;
                    newNode.deleteNode(newNode.value);
                }
            }

            if (value.compareTo(this.value) < 0) {
                if (leftChild != null) {
                    leftChild.deleteNode(value);
                }
                return;
            }
            if (rightChild != null){
                 rightChild.deleteNode(value);
            }
        }
        
        

        public String toString() {
            StringBuilder result = new StringBuilder("(" + value.toString() + " ");
            result.append(leftChild != null ? leftChild .toString() : "null");
            result.append(" ");
            result.append(rightChild != null ? rightChild.toString() : "null");
            result.append(")");
            return result.toString();
        }

        private boolean containsNode(T value) {
            if (this.value.equals(value)) {
                return true;
            }

            if (value.compareTo(this.value) < 0) {
                return leftChild != null && leftChild.containsNode(value);
            }
            return rightChild != null && rightChild.containsNode(value);
        }

        public void treeToArray(ArrayList<T> list) {
            if (leftChild != null) {
                leftChild.treeToArray(list);
            }
            list.add(this.value);
            if (rightChild != null) {
                rightChild.treeToArray(list);
            }
        }
    }
}


