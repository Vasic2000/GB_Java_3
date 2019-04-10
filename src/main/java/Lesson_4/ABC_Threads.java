package Lesson_4;

public class ABC_Threads extends Thread {
    public static String[] monitor = new String[]{"A", "B", "C"};

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (monitor[0]) {
                        try {
                            System.out.println(monitor[0]);
                            monitor[0].wait();
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        monitor[1].notify();
                    }
                }
                System.out.println("End_A");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (monitor[1]) {
                        try {
                            System.out.println(monitor[1]);
                            monitor[1].wait();
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        monitor[2].notify();
                    }
                }
                System.out.println("End_B");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (monitor[2]) {
                        try {
                            System.out.println(monitor[2]);
                            monitor[2].wait();
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        monitor[0].notify();
                    }
                }
                System.out.println("End_C");
            }
        }).start();
    }
}
