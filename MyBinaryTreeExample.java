package PA8_C00293259;

//Alexander Mayer
//C00293259
//CMPS 261
//Program Description: Code to test the functions of the binary search tree.
//Certificate of Authenticity:
//I certify that the code in the method functions
//including method function main of this project are
//entirely my own work.


public class MyBinaryTreeExample {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        MyBinaryTree<Integer> mbt = new MyBinaryTree();

        mbt.insert(4);
        mbt.insert(20);
        mbt.insert(1);
        mbt.insert(9);
        mbt.insert(3);
        mbt.insert(3);
        mbt.insert(7);
        mbt.insert(2);
        mbt.insert(-1);
        mbt.insert(19);
        mbt.insert(-5);
        mbt.insert(-2);
        mbt.insert(22);
        mbt.insert(15);
        mbt.insert(11);
        mbt.insert(0);

        mbt.inorder();
        mbt.preorder();
        mbt.postorder();
        mbt.breadthFirstTraversal();
        System.out.println();

        System.out.println("\nIterator Example:");
        java.util.Iterator it = mbt.iterator();
        while (it.hasNext()) {
            System.out.printf("%3s", it.next());
        }
        System.out.println();
        System.out.println("\nLeaves Example:");
        mbt.leavesNode(mbt.getRoot());
        System.out.println();

        System.out.println("\nDeleting Examples:\n");
        mbt.delete(4);
        mbt.preorder();
        mbt.delete(-5);
        mbt.preorder();
        mbt.delete(11);
        mbt.preorder();
        mbt.delete(3);
        mbt.preorder();
        mbt.delete(19);
        mbt.preorder();
        mbt.delete(20);
        mbt.preorder();
        mbt.delete(15);
        mbt.preorder();
        mbt.delete(1);
        mbt.preorder();
        mbt.delete(0);
        mbt.preorder();
        mbt.delete(-1);
        mbt.preorder();
        mbt.delete(1);
        mbt.preorder();
        mbt.delete(-2);
        mbt.preorder();
        mbt.delete(9);
        mbt.preorder();
        mbt.delete(7);
        mbt.preorder();
        mbt.delete(22);
        mbt.preorder();
        mbt.delete(2);
        mbt.preorder();

        System.out.println("\nExample of 'search' function:\n");
        mbt.insert(2);
        mbt.preorder();
        System.out.println();
        System.out.println("Searching for a value of '2' ...");
        System.out.println(mbt.search(2));
        mbt.delete(2);
        System.out.println();
        mbt.preorder();
        System.out.println();
        System.out.println("Searching for a value of '2' ...");
        System.out.println(mbt.search(2));
        System.out.println();
        System.out.println("Searching for a value of '53' ...");
        System.out.println(mbt.search(53));

        System.out.println("\nExample of 'removeDeletedNodes' function:\n");
        System.out.println("Removing all deleted nodes...");
        System.out.println();
        mbt = mbt.removeDeletedNodes(mbt.getRoot());
        System.out.println("Searching for a value of '2'");
        System.out.println(mbt.search(2));

    }

}
