package PA8_C00293259;
//Alexander Mayer
//C00293259
//CMPS 261
//Program Description: Binary search tree and necessary accompanying functions functions
//Certificate of Authenticity:
//I certify that the code in the method functions
//including method function main of this project are
//entirely my own work.


/**
 *
 * @param <E>
 */
public class MyBinaryTree<E extends Comparable<E>> {

    private Node<E> root = null;

    /**
     *
     * @param <E>
     */
    public class Node<E> {

        public boolean isDeleted = false;
        public E e = null;
        public Node<E> left = null;
        public Node<E> right = null;
    }

    /**
     *
     * @return
     */
    public Node<E> getRoot() {
        return this.root;
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean isDeleted(Node<E> e) {
        return e.isDeleted;
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean insert(E e) {
        // if empty tree, insert a new node as the root node
        // and assign the elementy to it
        if (root == null) {
            root = new Node();
            root.e = e;
            return true;
        }

        // otherwise, binary search until a null child pointer
        // is found
        Node<E> parent = null;
        Node<E> child = root;
        while (child != null) {
            if (e.compareTo(child.e) < 0) {
                parent = child;
                child = child.left;
            } else if (e.compareTo(child.e) > 0) {
                parent = child;
                child = child.right;
            } else {
                if (child.isDeleted) {
                    child.isDeleted = false;
                    child.e = e;
                    return true;
                }
                return false;
            }
        }

        // if e < parent.e create a new node, link it to
        // the binary tree and assign the element to it
        if (e.compareTo(parent.e) < 0) {
            parent.left = new Node();
            parent.left.e = e;
        } else {
            parent.right = new Node();
            parent.right.e = e;
        }
        return true;
    }


    public void inorder() {
        System.out.print("inorder:   ");
        inorder(root);
        System.out.println();
    }

    /**
     *
     * @param current
     */
    private void inorder(Node<E> current) {
        if (current != null) {
            inorder(current.left);
            if (!isDeleted(current)) {
                System.out.printf("%3s", current.e);
            }
            inorder(current.right);
        }
    }

    public void preorder() {
        System.out.print("preorder:  ");
        preorder(root);
        System.out.println();
    }

    /**
     *
     * @param current
     */
    private void preorder(Node<E> current) {
        if (current != null) {
            if (!isDeleted(current)) {
                System.out.printf("%3s", current.e);
            }
            preorder(current.left);
            preorder(current.right);
        }
    }

    public void postorder() {
        System.out.print("postorder: ");
        postorder(root);
        System.out.println();
    }

    /**
     *
     * @param current
     */
    private void postorder(Node<E> current) {
        if (current != null) {
            postorder(current.left);
            postorder(current.right);
            if (!isDeleted(current)) {
                System.out.printf("%3s", current.e);
            }
        }
    }


    public void breadthFirstTraversal() {
        int h = getHeight(root);
        int i;
        System.out.print("bft:         ");
        for (i = 1; i <= h; i++) {
            printLevel(root, i);
        }

    }

    /**
     *
     * @param root
     * @return
     */
    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            if (leftHeight > rightHeight) {
                return (leftHeight + 1);
            } else return (rightHeight + 1);
        }
    }

    /**
     *
     * @param root
     * @param level
     */
    public void printLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.e + " ");
        } else if (level > 1) {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }

    /**
     *
     * @param data
     * @return
     */
    public String search(E data) {
        Node<E> current = root;
        String result = "";
        while (current != null) {
            if (data.compareTo(current.e) < 0) {
                current = current.left;
            } else if (data.compareTo(current.e) > 0) {
                current = current.right;
            } else {
                if (current.isDeleted == false) {
                    return result += "Node found with queried data that has not been deleted.";
                } else {
                    return result += "Matching data found in deleted node.";
                }
            }
        }
        return result += "No matching, undeleted node found.";
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean delete(E e) {
        boolean found = false;
        Node<E> current = root;

        while (current != null) {
            if (e.compareTo(current.e) < 0) {
                current = current.left;
            } else if (e.compareTo(current.e) > 0) {
                current = current.right;
            } else {
                found = true;
                current.isDeleted = true;
                break;
            }
        }
        return found;
    }

    /**
     *
     * @param current
     * @return
     */
    public MyBinaryTree removeDeletedNodes(Node<E> current) {
        MyBinaryTree temp = new MyBinaryTree();

        if (current != null) {
            temp.insert(current.e);
            preorder(current.left);
            preorder(current.right);
        }
        return temp;
    }

    /**
     *
     * @param current
     */
    public void leavesNode(Node<E> current) {
        if (current != null) {
            if (current.left == null && current.right == null) {
                System.out.printf("%3s", current.e);
            }
            preorder(current.left);
            preorder(current.right);
        }
    }

    /**
     *
     * @return
     */
    // an iterator allows elements to be modified, but can mess with
    // the order if element not written with immutable key; it is better
    // to use delete to remove and delete/insert to remove or replace a
    // node

    public java.util.Iterator<E> iterator() {
        return new PreorderIterator();
    }


    private class PreorderIterator implements java.util.Iterator<E> {

        private java.util.LinkedList<E> ll = new java.util.LinkedList();
        private java.util.Iterator<E> pit = null;

        // create a LinkedList object that uses a linked list of nodes that
        // contain references to the elements of the nodes of the binary tree
        // in preorder
        public PreorderIterator() {
            buildListInPreorder(root);
            pit = ll.iterator();
        }

        private void buildListInPreorder(Node<E> current) {
            if (current != null) {
                ll.add(current.e);
                buildListInPreorder(current.left);
                buildListInPreorder(current.right);
            }
        }

        // check to see if their is another node in the LinkedList
        @Override
        public boolean hasNext() {
            return pit.hasNext();
        }

        // reference the next node in the LinkedList and return a
        // reference to the element in the node of the binary tree
        @Override
        public E next() {
            return pit.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("NO!");
        }
    }
}
