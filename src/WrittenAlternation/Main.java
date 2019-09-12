package WrittenAlternation;

public class Main {
    static boolean isDivide = false; //if true is divide turn
    static double integer = 100000;
    final static int quant = 2000000;

    public static void write (double s) {
        integer = s;
    }

    public static void main (String[] args) {
        Multiply multiply1 = new Multiply("Multiplica Um");
        Multiply multiply2 = new Multiply("Multiplica Dois");
        Multiply multiply3 = new Multiply("Multiplica Três");

        Divide divide1 = new Divide("Divide Um");
        Divide divide2 = new Divide("Divide Dois");

        multiply1.start();
        divide1.start();
        multiply2.start();
        divide2.start();
        multiply3.start();

    }
}
