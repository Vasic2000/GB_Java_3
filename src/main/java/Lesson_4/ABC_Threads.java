package Lesson_4;

public class ABC_Threads extends Thread {
    public static Object monitor = new Object();

    public static void main(String[] args) {
        final ABC_Threads e1 = new ABC_Threads();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("A");
                    synchronized (monitor) {
                        try {
                            monitor.wait(200);
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        monitor.notify();
                    }
                }
                System.out.println("End_A");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("B");
                    synchronized (monitor) {
                        try {
                            monitor.wait(200);
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        monitor.notify();
                    }
                }
                System.out.println("End_B");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("C");
                    synchronized (monitor) {
                        try {
                            monitor.wait(200);
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        monitor.notify();
                    }
                }
                System.out.println("End_C");
            }
        }).start();
    }
}
