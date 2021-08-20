package DSC30.PA3;
/*
 * NAME: Zhiyu Gao
 * PID: A17245309
 */

public class Sorts {

    public void InsertionSort(int[] arr, int start, int end) {
        int key, i, j;
        for (i = start + 1; i < end; ++i) {
            key = arr[i];
            j = i - 1;
            while (j >= start && arr[j] > key) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = key;
        }
    }
    public static int counts=0;
    public void MergeSort(int[] arr, int start, int end) {
        counts++;
        if (end - start == 1)
            return;
        int mid = start + (end - start) / 2;
        MergeSort(arr, start, mid);
        MergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int left, int middle, int right) {
        int[] left_arr = new int[middle - left + 1], right_arr = new int[right - middle + 1];
        int i, j;
        for (i = 0; i < middle - left; ++i){
            left_arr[i]=arr[left+i];
        }
        for (j = 0; j < right-middle; ++j){
            right_arr[j]=arr[middle+j];
        }
        left_arr[middle - left] = Integer.MAX_VALUE;
        right_arr[right - middle] = Integer.MAX_VALUE;
        i=j=0;
        while (i != left_arr.length - 1 || j != right_arr.length - 1) {
            if (left_arr[i] < right_arr[j]) {
                arr[left + i + j] = left_arr[i++];
            } else {
                arr[left + i + j] = right_arr[j++];
            }
        }
    }

    public void TimSort(int[] arr, int start, int end, int param) {
        int i=0;
        while(i<end-start){
            if(i+param<=end){
                InsertionSort(arr, i, i+param);
            } else {
                InsertionSort(arr, i, end);
            }
            i+=param;
        }
        i=param;
        while(i<end-start){
            if(i+param<=end){
                merge(arr, start, i, i+param);
            } else {
                merge(arr, start, i, end);
            }
            i+=param;
        }
    }

}
