//on basis of time complexity -> bubblesort=insertionsort>selectionsort
import java.util.Arrays;

public class sorting {
    public static void main(String[] args) {
        int[] arr = {57,-8,84,0,63,416};
        int[] nums = {3,5,2,1,4};
//        bubblesort(arr);
//        bubble(arr,arr.length-1,0);
//        selectionsort(arr);
//        System.out.println(Arrays.toString(arr));
//        selection(arr,arr.length,0,0);
//        insertionsort(arr);
        cyclesort(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void bubblesort(int[] arr) {
        boolean swapped;
        for (int i=0;i<arr.length;i++) {
            swapped = false;
            for (int j=1;j<arr.length-i;j++) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {   // !false = true
                break;
            }
        }
    }
    //bubblesort through recursion
    static void bubble(int[] arr,int r,int c) {
        if (r==0) return;
        if (c<r) {
            if (arr[c] > arr[c + 1]) {
                swap(arr, c, c + 1);
            }
            bubble(arr,r,c+1);
        }
        else bubble(arr,r-1,0);
    }
    static void selectionsort(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            int last = arr.length-1-i;
            int maxindex = getmaxindex(arr,0,last);
            swap(arr,maxindex,last);
        }
        //this code can also work for selection sort
//        for (int i = 0; i < arr.length; i++) {
//            int max = arr.length-1-i;
//            for (int j = arr.length-1-i; j >=0 ; j--) {
//                if (arr[j]>arr[max]) max=j;
//            }
//            swap(arr,arr.length-1-i,max);
//        }
    }
    //selectionsort through recursion
    static void selection(int[] arr, int r, int c,int max) {
        if (r==0) return;
        if (c<r) {
            if (arr[c] > arr[max]) {
                selection(arr,r,c+1,c);
            }
            else selection(arr,r,c+1,max);
        }
        else {
            swap(arr,max,r-1);
            selection(arr,r-1,0,0);
        }
    }
    static void insertionsort(int[] arr) {    //works good when array is partially sorted and it takes part in hybrid sorting algorithms
        for (int i=0;i<arr.length-1;i++){
            for (int j=i+1;j>0;j--) {
                if (arr[j]<arr[j-1]) {
                    swap(arr,j,j-1);
                }
                else {
                    break;
                }
            }
        }
    }
    static void cyclesort(int[] arr) { //use when 0 to n no are given and o(n) or o(1) is given in question
        int i=0;
        while (i < arr.length) {
            int correct = arr[i]-1;
            if (arr[i] != arr[correct]) {
                swap(arr,i,correct);
            }
            else {
                i++;
            }
        }
    }
    static int getmaxindex(int[] arr,int start,int end){
        int max = start;
        for (int i=0;i<=end;i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
