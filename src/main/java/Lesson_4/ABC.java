package Lesson_4;

public class ABC {

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
                synchronized (newLetter) {
                    try {
                        System.out.println(newLetter);
                        newLetter.wait();
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    newLetter.notify();
                    System.out.println("End_" + newLetter);
                }
            }
        }
    }
}


