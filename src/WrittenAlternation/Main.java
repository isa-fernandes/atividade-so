package WrittenAlternation;

import java.util.ArrayList;

public class Main {
    static boolean isDivide; //if true is divide turn
    static ArrayList<Multiply> multiplyList = new ArrayList<>();
    static ArrayList<Divide> divideList = new ArrayList<>();
    static double integer = 100000;
    final static int quant = 15;//2000000;

    public static void write (double s) {
        integer = s;
    }

    public static void main (String[] args) {
        Multiply multiply1 = new Multiply("Multiplica Um");
        multiplyList.add(multiply1);

        Divide divide1 = new Divide("Divide Um");
        divideList.add(divide1);

        divide1.start();

    }
}
