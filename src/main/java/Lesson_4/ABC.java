package Lesson_4;

public class ABC {
    public static String start = "A";

    public static void main(String[] args) {
        ABC abc = new ABC();
        ABC_Thread t1 = new ABC_Thread("A");
        ABC_Thread t2 = new ABC_Thread("B");
        ABC_Thread t3 = new ABC_Thread("C");

        t1.start();
        t2.start();
        t3.start();
    }

    public static class ABC_Thread extends Thread {
        String newLetter;

        public ABC_Thread(String newLetter) {
            this.newLetter = newLetter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (start) {
                    while (!newLetter.equals(start)) {
                        try {
                            System.out.println(newLetter);
                            start = newLetter;
                            start.wait();
                            Thread.sleep(250);
                            start.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("End_" + newLetter);
                    }
                }
            }
        }
    }
}


