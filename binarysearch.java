import java.util.Arrays;
import java.util.Scanner;

public class binarysearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] nums = {2,5,40,52,78,111,321,1450,8452};
        int n = 111;
        int[][] matrix = {{10,20,30,40},{15,25,35,45},{28,29,37,49},{33,34,38,50}};
        int target1 = 37;
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        int target2 = 9;
        System.out.println(binarysearch(nums,n));
        System.out.println(Arrays.toString(twodbinarysearch(matrix,target1)));
        System.out.println(Arrays.toString(search(matrix1,target2)));
    }
    static int binarysearch(int[] nums,int target) {
        int start=0;
        int end = nums.length-1;
        while (start<=end) {
            int mid = start + (end - start)/2;
            if (target<nums[mid]) {
                end = mid - 1;
            }
            else if (target>nums[mid]) {
                start = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    //binary search through recursion
    static int binary(int[] arr,int target,int s,int e){
        int m = (s+e)/2;
        if (arr[m]>target) {
            return binary(arr,target,s,m-1);
        }
        else if (arr[m]<target) {
            return binary(arr,target,m+1,e);
        }
        else {
            return m;
        }
    }

    //opposite method of binary search but with same bigo complexity
    static int oppbinarysearch(int[] nums,int target) {
        int start = 0;
        int end = 1;

        while (target>nums[end]) {
            int newstart = end+1;
            end = end + (end-start+1)*2;
            start = newstart;
        }
        return oppositebinarysearch(nums,target,start,end);
    }
    static int oppositebinarysearch(int[] nums,int target,int start,int end) {
        while (start<=end) {
            int mid = end - (end - start)/2;
            if (target<nums[mid]) {
                end = mid - 1;
            }
            else if (target>nums[mid]) {
                start = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    static int[] twodbinarysearch(int[][] matrix,int target1) {     //this is for non sorted array
        int r = 0;
        int c = matrix.length - 1;
        while (r< matrix.length && c>=0) {
            if (matrix[r][c] == target1) {
                return new int[]{r,c};
            } else if (matrix[r][c] < target1) {
                r++;
            }
            else {
                c--;
            }
        }
        return new int[]{-1,-1};
    }
    static  int[] twodbinarysearch1(int[][] matrix1,int row,int cstart,int cend,int target2) {  //this is for sorted array
        while (cstart<=cend) {
            int mid = cstart + (cend - cstart)/2;
            if (matrix1[row][mid] == target2) {
                return new int[]{row,mid};
            }
            else if (matrix1[row][mid] < target2) {
                cstart = mid + 1;
            }
            else {
                cend = mid -1;
            }
        }
        return new int[]{-1,-1};
    }
    static int[] search(int[][] matrix1,int target2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        if (rows == 1) {
            return twodbinarysearch1(matrix1,0,0,cols-1,target2);
        }
        int rstart = 0;
        int rend = rows - 1;
        int cmid = cols/2;
        while (rstart < (rend-1)) {
            int mid = rstart + (rend - rstart)/2;
            if (matrix1[mid][cmid] == target2) {
                return new int[]{mid,cmid};
            }
            else if (matrix1[mid][cmid] < target2) {
                rstart = mid;
            }
            else {
                rend = mid;
            }
        }
        if (matrix1[rstart][cmid] == target2) {
            return new int[]{rstart,cmid};
        }
        if (matrix1[rstart+1][cmid] < target2) {
            return new int[]{rstart+1,cmid};
        }

        if (target2 <= matrix1[rstart][cmid-1]) {
            return twodbinarysearch1(matrix1,rstart,0,cmid-1,target2);
        }
        if (target2 >= matrix1[rstart][cmid+1] && target2 <= matrix1[rstart][cols-1]) {
            return twodbinarysearch1(matrix1,rstart,cmid+1 ,cols-1,target2);
        }
        if (target2 <= matrix1[rstart+1][cmid-1]) {
            return twodbinarysearch1(matrix1,rstart+1,0,cmid-1,target2);
        }
        else {
            return twodbinarysearch1(matrix1,rstart+1,cmid+1,cols-1,target2);
        }
    }
}
