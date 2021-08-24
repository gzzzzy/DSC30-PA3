package DSC30.PA3;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BSTTest {
    @Test
    public void constructorTest() {
        BST b = new BST();
        assertEquals(0, b.nElems);
        int[] arr = { 12, 5, 18, 2, 9, 15, 19, 13, 17 };
        for (int i : arr) {
            b.add(i);
        }
        assertEquals(arr.length, b.nElems);
        /*
         * System.out.println(b.leafCount(b.getRoot())); b.removeNode(12); //
         * System.out.println(b.nodeLocator(12).equals(b.getRoot()));
         * System.out.println(b.leafCount(b.getRoot())); b.inOrderTraverse(b.getRoot());
         */
    }

    @Test
    public void methodTest() {
        BST b = new BST();
        assertEquals(true,b.isEmpty());
        assertEquals(0, b.leafCount(b.getRoot()));
        int[] arr = { 12, 5, 18, 2, 9, 15, 19, 13, 17 };
        for (int i : arr) {
            b.add(i);
        }
        assertEquals(false, b.isEmpty());
        assertEquals(5, b.leafCount(b.getRoot()));
        assertEquals(9, b.getPrNode(b.getRoot()).getKey());
        assertEquals(2, b.treeMinimum(b.getRoot()).getKey());
        assertEquals(19, b.treeMaximum(b.getRoot()).getKey());
        b.removeNode(12);
        assertEquals(9, b.getRoot().getKey());
        assertEquals(4, b.leafCount(b.getRoot()));
        assertEquals(3, b.leafCount(b.getRoot().getChild(false)));
        b.removeNode(19);
        assertEquals(2, b.leafCount(b.getRoot().getChild(false)));
        assertEquals(2, b.treeMinimum(b.getRoot()).getKey());
        assertEquals(18, b.treeMaximum(b.getRoot()).getKey());
    }
}
