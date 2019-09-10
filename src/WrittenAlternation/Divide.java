package WrittenAlternation;

public class Divide extends Thread {
    String name;
    public Divide(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= Main.quant; i++) {
            long start = System.currentTimeMillis();
            while (Main.isDivide == true) {
                double result = Main.integer / i;
                Main.write(result);
                System.out.println(Math.round(Main.integer * i) + " / " + i + " = " + Math.round(result));
                long end = System.currentTimeMillis();
                if ((end - start) / 1000F >= 5) {
                    Main.isDivide = false;

                }
            }
        }
    }
}
