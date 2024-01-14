//quick sort is lil better then merge sort due to better space complexity but both merge and quick have equal time complexity
import java.util.Arrays;
import java.util.Scanner;

public class quicksort {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int[] arr = {5,3,8,0,50,4,2,1};
        quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    static void quicksort(int[] nums,int low,int high) {
        if (low>=high) return;

        int s = low;
        int e = high;
        int m = s + (e-s)/2;
        int pivot = nums[m];

        while (s<=e) {
            while (nums[s]<pivot) s++;
            while (nums[e]>pivot) e--;
            if (s<=e) {
                int temp = nums[s];
                nums[s]=nums[e];
                nums[e]=temp;
                s++;
                e--;
            }
        }
        quicksort(nums,low,e);
        quicksort(nums,s,high);
    }
}
