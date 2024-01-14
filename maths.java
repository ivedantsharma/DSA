public class maths {
    public static void main(String[] args) {
        /*bitwise operators:-
        and operator-> both should be true , number & 1 gives the last digit of number in binary form
        or operator-> any one is true
        xor operator-> exactly one should be true , number ^ 1 gives opposite of number , number^0 gives 0 , 0^number gives number itself
        compliment-> convert 0 to 1 and 1 to zero
        left shift operator -> a << b gives a*(2 ki power b)
        right shift operator -> a >> b gives a/(2 ki power b)
         */
        System.out.println(gcd(20,15));
        System.out.println(lcm(9,10));
        System.out.println(primenum(57));
        rangeofprimenum(40);
        System.out.println(squareroot(55,3));
        System.out.println(fibonacinum(10));
        System.out.println(totaldigit(1258746));
        int a = 67;
        System.out.println(isodd(a));
        int[] arr = {2,3,3,4,2,6,4};
        System.out.println(ans(arr));
        System.out.println(ibit(a));
        int b=6;
        System.out.println(nthmagicnum(b));
        int c=34567;
        int d=10;
        System.out.println(digtsinbase(c,d));
        int e = 16;
        System.out.println(powerof2(e));
        int f = 3;
        int g = 6;
        System.out.println(power(f,g));
        System.out.println(tofindbinary(254789));
        System.out.println(setbits(254789));
        int h = 3;
        int i= 9;
        System.out.println(xorfrom0toa(3));
        System.out.println(xorfrom0toa(9));
        System.out.println(xor(h,i));
    }
    static int gcd(int a,int b) {
        if(a==0) {
            return b;
        }
        return gcd(b%a,a);  //we can use b-a also where b>a but b%a is better approach
    }
    static int lcm(int a,int b) {
        return a*b / gcd(a,b);
    }
    static boolean primenum(int n) {
        if (n<=1) {
            return false;
        }
        int c=2;
        while (c*c<=n) {
            if (n%c==0) {
                return false;
            }
            c++;
        }
        return true;
    }
    static void rangeofprimenum(int n) { //finding all prime num between 0 and given number
        boolean[] primes = new boolean[n+1];
        sieve(n,primes);
    }
    static void sieve(int n,boolean[] primes) { //this method is called sieve of eratosthenes
        for (int i=2;i*i<=n;i++) {
            if (!primes[i]) {
                for (int j = i*2; j <= n; j+=i) {
                    primes[i]=true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!primes[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    static double squareroot(int n,int p) {  // p is here for the precision value till which we want the root
        int start = 0;
        int end = n;
        double root = 0.0;
        while (start <= end) {
            int mid  = start + (end - start) / 2;
            if (mid*mid==n) {
                return mid;
            }
            else if (mid*mid>n) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        double incr = 0.1;
        for (int i = 0; i < p; i++) {
            while (root*root <= n) {
                root += incr;
            }
            root -= incr;
            incr /= 10;
        }
        return (root);
    }
    static int fiboformula(int n) {
        return (int)(Math.pow(((1 + Math.sqrt(5)) / 2), n)/Math.sqrt(5));   //this is the formula to find fibonacci number
    }
    static int fibonacinum(int n) {
        if (n<2) {
            return n;
        }
        else {
            return fibonacinum(n-1) + fibonacinum(n-2);
        }
    }
    static int totaldigit(int n) { //it tells total no of digits in a number
        return (int)(Math.log10(n))+1;
    }
    static boolean isodd(int n) {  // program to check even or odd
        return (n & 1) == 1;
    }
    static int ans(int[] arr) {  // to find element in array which come once whereas all elements come twice using xor
        int unique = 0;
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            unique ^= n;
        }
        return unique;
    }
    static int ibit(int n) {   // find ith bit of a number
        return n & (1<<(n-1));
    }
    static int nthmagicnum(int n) { // find nth magic number (amazon ques)
        int ans = 0;
        int base = 5;
        while (n>0) {
            int last = n & 1;
            n=n >> 1;
            ans = ans + last*base;
            base = base * 5;
        }
        return ans;
    }
    static int digtsinbase(int n,int b) { //to find no of digit in base b form of number
        return  (int)(Math.log(n) / Math.log(b)) + 1;
    }
    static  int noofdigit(int n) {
        return (int)(Math.log10(n)+1);
    }
    static boolean powerof2(int n) {  // check if a number is a power of 2
        return (n & (n-1)) == 0;
    }
    static int power(int base,int power) {  // find a to the power b
        int ans = 1;
        while (power>0) {
            if ((power & 1) == 1) {
                ans = ans * base;
            }
            base *=base;
            power = power >> 1;
        }
        return ans;
    }
    static String tofindbinary(int n) {  // to find binary number of a given number
        return Integer.toBinaryString(n);
    }
    static int setbits(int n) {  // no of 1 in binary form of a number
        int count = 0;
        while (n > 0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }
    static int xorfrom0toa(int a) { // gives xor from 0 to a-> 0^1^2^3........^a=?
        if (a%4==0) {
            return a;
        }
        if (a%4==1) {
            return 1;
        }
        if (a%4==2) {
            return a+1;
        }
        return 0;
    }
    static int xor(int a,int b) { // to find xor in given range
        return xorfrom0toa(b) ^ xorfrom0toa(a);
    }
}