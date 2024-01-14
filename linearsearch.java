public class linearsearch {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(str.toCharArray)); this can be used to print string in array form
        //for taking an minimum value we can take Integer.MIN_VALUE
        //if we have to find no of digits in a given num the we can use (int)(Math.log10(num)+1)
        //to convert int to string use String a=Integer.toString(i)
        int n=526585564;
        String a=Integer.toString(n);
        System.out.println(a);
        for (int i=0;i<11;i++) {
            System.out.println(fiboformula(i));
        }
    }
    static int fiboformula(int n) {
        return (int)(Math.pow(((1 + Math.sqrt(5)) / 2), n)/Math.sqrt(5));   //this is the formula to find fibonacci number
    }
}
