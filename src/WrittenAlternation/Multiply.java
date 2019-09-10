package WrittenAlternation;

public class Multiply extends Thread {
    String name;

    public Multiply(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= Main.quant; i++) {
            long start = System.currentTimeMillis();
            while (Main.isDivide == false) {
                double result = Main.integer * i;
                Main.write(result);
                System.out.println(Math.round(Main.integer / i) + " * " + i + " = " + Math.round(result));
                long end = System.currentTimeMillis();
                if ((end - start) / 1000F >= 5) {
                    Main.isDivide = true;

                }
            }
        }
    }
}
