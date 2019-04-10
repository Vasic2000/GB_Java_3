package Lesson_4;

public class A_B_C_Threads extends Thread {
    public static String str = new String("A");

    public static void main(String[] args) {
        A_B_C_Threads abc = new A_B_C_Threads();

        A_Thread Aa = new A_Thread();
        B_Thread Bd = new B_Thread();
        C_Thread Cc = new C_Thread();

        Aa.start();
        Bd.start();
        Cc.start();
        System.out.println("Start");
        while(str == "") {}
        System.out.println(str);
        }
}

class A_Thread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized(this) {
                try {
                    A_B_C_Threads.str = "A";
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notify();
            }
        }
    }
}


class B_Thread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized(this) {
                try {
                    A_B_C_Threads.str = "B";
                    wait(250);
                    System.out.println(A_B_C_Threads.str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notify();
            }
        }
    }
}

class C_Thread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized(this) {
                try {
                    A_B_C_Threads.str = "C";
                    wait(250);
                    System.out.println(A_B_C_Threads.str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notify();
            }
        }
    }
}



