

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SortsTest {
    @Test
    public void mergeSortTest() {
        int[] arr1={1,2,3,4,5};
        int[] arr2={2,4,5,1,3};
        int[] arr3={5,4,3,2,1};
        Sorts s=new Sorts();
        s.MergeSort(arr1, 0, arr1.length);
        assertArrayEquals(arr1, arr1);
        s.MergeSort(arr2, 0, arr2.length);
        assertArrayEquals(arr1, arr2);
        s.MergeSort(arr3, 0, arr3.length);
        assertArrayEquals(arr1, arr3);
    }

    @Test
    public void insertionSortTest() {
        int[] arr1={1,2,3,4,5};
        int[] arr2={2,4,5,1,3};
        int[] arr3={5,4,3,2,1};
        Sorts s=new Sorts();
        s.InsertionSort(arr1, 0, arr1.length);
        assertArrayEquals(arr1, arr1);
        s.InsertionSort(arr2, 0, arr2.length);
        assertArrayEquals(arr1, arr2);
        s.InsertionSort(arr3, 0, arr3.length);
        assertArrayEquals(arr1, arr3);
    }

    @Test
    public void timSortTest() {
        int[] arr1={1,2,3,4,5};
        int[] arr2={2,4,5,1,3};
        int[] arr3={5,4,3,2,1};
        Sorts s=new Sorts();
        int run_size=2;
        s.TimSort(arr1, 0, arr1.length,run_size);
        assertArrayEquals(arr1, arr1);
        s.TimSort(arr2, 0, arr2.length,run_size);
        assertArrayEquals(arr1, arr2);
        s.TimSort(arr3, 0, arr3.length,run_size);
        assertArrayEquals(arr1, arr3);
    }
}
