import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class arraytutorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] rnos = new int[5];
        int[] rnos2 = {4, 5, 8, 2, 7};
        int[] rnos3;
        rnos3 = new int[5];


        String[] a = new String[4];
        System.out.println(a[0]);


        for (int i = 0; i < rnos2.length ; i++) {
            System.out.print(rnos2[i]+" ");
        }

        for (int num : rnos2) {   //for each loop -> its just
            //an enhanced version of for loop
            System.out.print(num + " ");
        }

        System.out.println(Arrays.toString(rnos2));
//        tostring method to print array
//        in java arrays are mutable means they can be changed if
//        paased in function


        //2-d Array
        int[][] arr = new int[3][];
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr3;
        for (int row = 0; row < arr2.length; row++) {
            for (int col = 0; col < arr2[row].length; col++) {
                System.out.print(arr2[row][col] + " ");
            }
            System.out.println();
        }

        for (int[] ints : arr2) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }       //this is enhanced for loop known as for each loop

        for (int row = 0; row < arr2.length; row++) {
            System.out.println(Arrays.toString(arr2[row]));
        }

        for (int[] ints : arr2) {
            System.out.println(Arrays.toString(ints));
        }

        //ARRAYLIST FROM NOW
        ArrayList<Integer> sc = new ArrayList<>(10);
        sc.add(5);
        sc.add(8);
        sc.add(5);
        sc.add(8);
        sc.add(5);
        sc.add(8);
        sc.add(54);
        sc.add(88);
        sc.add(8);
        sc.add(45);
        System.out.println(sc);
        for (int i = 0; i < 10; i++) {
            System.out.println(sc.get(i));
        }

        //ARRAYLIST OF 2D ARRAY
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {     //initialisation
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < 3; i++) {     //adding elements
            for (int j = 0; j < 3; j++) {
                list.get(i).add(input.nextInt());
            }
        }
        System.out.println(list);   // printing 2d array
    }
}
