package SleepWakeup;

import java.util.ArrayList;

public class Main {
    static final int quant = 2000000;
    static final int max = 500000;
    static int products = 0;
    static ArrayList<Thread> consumersList = new ArrayList<>();
    static ArrayList<Thread> producersList = new ArrayList<>();

    public static boolean isFull () {
        return (products == max);
    }

    public static boolean isEmpty () {
        return (products == 0);
    }

    public static void wakeup (boolean isWakeProducer) {
        if (isWakeProducer) {
            if (!producersList.isEmpty()) {
                producersList.get(0).interrupt();
            }
        } else {
            if (!consumersList.isEmpty()) {
                consumersList.get(0).interrupt();
            }
        }
    }

    public static void produce () {
        products++;
    }

    public static void consume () {
        products--;
    }

    public static void main (String[] args) {
        Producer prod1 = new Producer("Produz Um");
        producersList.add(prod1);

        Consumer cons1 = new Consumer("Consome Um");
        consumersList.add(cons1);

        prod1.start();
        cons1.start();
    }
}
