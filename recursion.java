import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class recursion {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String s = "baccdah";
        String a = "abc";
        int[] arr = {1,2,2};
        System.out.println(permutationcount("",a));

    }
    static String ans(String up) {  // removing a character from string and returning the string
        if (up.isEmpty()) return "";
        char ch = up.charAt(0);
        if (ch == 'a') return ans(up.substring(1));
        else return ch + ans(up.substring(1));
    }
    static String ans1(String up) { // removing a word from string and returning the string
        if (up.isEmpty()) return "";

        if (up.startsWith("apple")) return ans1(up.substring(5));
        else return ans1(up.substring(1));
    }

    static void subseq(String p,String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseq(p+ch,up.substring(1));
        subseq(p,up.substring(1));
    }

    static ArrayList<String> subseq1(String p,String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subseq1(p+ch,up.substring(1));
        ArrayList<String> right = subseq1(p,up.substring(1));
        left.addAll(right);
        return left;
    }
    static void subseqascii(String p,String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseqascii(p+ch,up.substring(1));
        subseqascii(p,up.substring(1));
        subseqascii(p + (ch+0),up.substring(1));
    }

    static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());
        for (int j = 0; j < arr.length; j++) {
            int num = arr[j];
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    }
    static List<List<Integer>> subsetduplicate(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());
        int start=0;
        int end=0;
        for (int i = 0; i < arr.length; i++) {
            start=0;
            if (i>0 && arr[i]==arr[i-1]) start=end+1;
            end = outer.size()-1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
    static void permutation(String p,String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            permutation(f+ch+s,up.substring(1));
        }
    }
    static ArrayList<String> permutation1(String p,String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            ans.addAll(permutation1(f+ch+s,up.substring(1)));
        }
        return ans;
    }
    static int permutationcount(String p,String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            count = count + permutationcount(f+ch+s,up.substring(1));
        }

        return count;
    }
}
