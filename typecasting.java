import java.util.Scanner;

public class typecasting {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("enter first number:");
        int num= (int)(58.3581f);
        System.out.println(num);
        int n=257;
        byte b = (byte)(n);//257%256=1(max range of byte is 256)
        System.out.println(b);
        float a = 453.1635f;
        System.out.printf("formatted number is %.2f",a);
        System.out.println();
        System.out.println(Math.PI);
        char ch=input.next().trim().charAt(0); //trim is used for removing extra space//
        System.out.println(ch);
    }
}
