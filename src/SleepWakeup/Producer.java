package SleepWakeup;

public class Producer extends Thread {
    private String name;

    public Producer (String name) {
        this.name = name;
    }

    public void print () {
        //System.out.println("-------------\n" + this.name + "\nProducts: " + SleepWakeup.Main.getProducts() + "\n-------------");
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < Main.quant; i++) {

            /*
             * ENQUANTO ESTIVER CHEIO DORME
             */
            while (Main.isFull()) {
                try {
                    System.out.println(this.name + " - Sleeping\nProducts:" + Main.products);
                    this.sleep(5000);
                    start = System.currentTimeMillis();
                } catch (InterruptedException e) {

                }
            }

            Main.produce();
            this.print();
            if (Main.products == 1) {
                Main.wakeup(false);
            }

            /*
             * DORME APÓS 5 SEGUNDOS
             */
            long end = System.currentTimeMillis();
            if ((end - start) / 1000F >= 5) {
                System.out.println("Seconds Thread " + this.name  + ": " + (end - start) / 1000F);
                try {
                    this.sleep(5000);
                    start = System.currentTimeMillis();
                } catch (InterruptedException e) {

                }
            }
        }
        Main.producersList.remove(this);
    }
}
