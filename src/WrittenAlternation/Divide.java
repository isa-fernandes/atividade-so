package WrittenAlternation;

public class Divide extends Thread {
    String name;
    public Divide(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        boolean wasWhile = false;
        long start = System.currentTimeMillis();
        for (int i = 1; i <= Main.quant; i++) {
            while (!Main.isDivide) {
                System.out.print("");
                wasWhile = true;
            }
            if (wasWhile) {
                System.out.println(this.name);
                start = System.currentTimeMillis();
                wasWhile = false;
            }
            double result = Main.integer / i;
            Main.write(result);
            System.out.print("");
            //System.out.println(Math.round(Main.integer * i) + " / " + i + " = " + Math.round(result));
            long end = System.currentTimeMillis();
            if ((end - start) / 1000F >= 5) {
                System.out.println("5 seconds");
                Main.isDivide = false;
            }
        }
        Main.isDivide = false;
    }
}
