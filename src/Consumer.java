public class Consumer extends Thread {
    private String name;

    public Consumer (String name) {
        this.name = name;
    }

    public void print () {
        //System.out.println("-------------\n" + this.name + "\nProducts: " + Main.getProducts() + "\n-------------");
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < Main.quant; i++) {

            /*
             * ENQUANTO ESTIVER VAZIO DORME
             */
            while (Main.isEmpty()) {
                try {
                    System.out.println(this.name + " - Sleeping\nProducts:" + Main.products);
                    this.sleep(5000);
                    start  = System.currentTimeMillis();
                } catch (InterruptedException e) {

                }
            }

            Main.consume();
            this.print();
            if (Main.products == Main.max - 1) {
                Main.wakeup(true);
            }

            /*
             * DORME APÓS 5 SEGUNDOS
             */
            long end = System.currentTimeMillis();
            if ((end - start) / 1000F >= 5) {
                try {
                    this.sleep(5000);
                    start = System.currentTimeMillis();
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
