import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class string {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = "vedant sharma";
        String a = new String("vedant sharma");
        System.out.println(name == a);   //it checks weather both values are in same pool in heap memory or not
        System.out.println(name.equals(a));  //checks the value of both refrence variable name and a
        System.out.println(name.charAt(10));

        Integer num = new Integer(60);
        System.out.println(num);
        System.out.println(name.length());
        System.out.println('a'+'b');
        System.out.println("a"+"b");
        System.out.println('a'+3);
        System.out.println((char)('a'+3));
        System.out.println("a"+1);
        System.out.println("vedant"+new ArrayList<>());
        System.out.println("vedant"+new Integer(56));
        System.out.println(name);
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(Arrays.toString(name.split(" ")));
        System.out.println(name.substring(1,5));
        // all this will only work when there is atleast one primitive(string) type operand
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<26;i++) {
            char ch = (char)('a'+i);
            builder.append(ch);
        }
        System.out.println(builder);
        System.out.println(builder.toString());

        String p = "55";
        int d = Integer.parseInt(p);//to convert a string containing a integer into datatype integer
        System.out.println(d);

//        karp-rabin algorithm

    }
}
