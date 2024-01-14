//time complexity for merge sort is nlognbase2
import java.util.Arrays;
import java.util.Scanner;

public class mergesort {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int[] arr = {5,4,3,2,1};
        mergesortinplace(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(mergesort(arr)));
    }
    static int[] mergesort(int[] arr) {
        if (arr.length==1) return arr;
        int mid = arr.length/2;
        int[] left = mergesort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergesort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }
    static int[] merge(int[] first,int[] second) {
        int[] mix = new int[first.length + second.length];
        int i=0,j=0,k=0;
        while (i< first.length && j< second.length) {
            if (first[i]<second[j]) {
                mix[k] = second[i];
                i++;
            }
            else {
                mix[k]=second[j];
                j++;
            }
            k++;
        }
        while (i<first.length) {
            mix[k]=first[i];
            i++;
            k++;
        }
        while (j<second.length) {
            mix[k]=first[j];
            j++;
            k++;
        }
        return mix;
    }
    static void mergesortinplace(int[] arr,int s,int e) {
        if (e-s==1) return;
        int mid = (s+e)/2;
        mergesortinplace(arr,s,mid);
        mergesortinplace(arr,mid,e);
        mergeinplace(arr,s,mid,e);
    }
    static void mergeinplace(int[] arr,int s,int m,int e) {
        int[] mix = new int[e-s];
        int i=s,j=m,k=0;
        while (i< m && j<e) {
            if (arr[i]<arr[j]) {
                mix[k] = arr[i];
                i++;
            }
            else {
                mix[k]=arr[j];
                j++;
            }
            k++;
        }
        while (i<m) {
            mix[k]=arr[i];
            i++;
            k++;
        }
        while (j<e) {
            mix[k]=arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < mix.length; l++) {
            arr[s+l]=mix[l];
        }
    }
}
