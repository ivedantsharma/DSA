import java.util.Arrays;
import java.util.Scanner;

public class function {
    //shadowing -> static int x;   now x can be used anywhere in the whole program
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        System.out.println(Arrays.toString(arr));
        /*
        block cope->{  anything that is initialized outside the
                       block can be used inside the block but
                       the vice versa in not true
                     }
        */
    }
    /*
    variable length arguments-> static void fun(int ...v);
                                static void multiple(int a,int b,int ...v);
    function overloading -> two function with same name can exist
                            but with different argument or with same
                            argument but no of arguments should differ
                        eg:-    static void fun(int n);
                                static void fun(int n,int a);
                                static void fun(String s);
    */
}