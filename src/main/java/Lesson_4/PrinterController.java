package Lesson_4;

public class PrinterController {

    public static final int THREADS_NUMBER = 3;

    public static void main(String[] args) {
        Printer[] printers = new Printer[THREADS_NUMBER];
        printers[0] = new Printer("A");
        printers[0].start();

        printers[1] = new Printer("B");
        printers[1].start();

        printers[2] = new Printer("C");
        printers[2].start();

    }
}


class Printer extends Thread {
    static Object monitor = new Object();

    static Integer counter = 0;

    static String newLetter = "A";

    private String letter ;


    public Printer(String letter) {
        this.letter = letter;
    }

    @Override
    public void run() {
        int portionsNumber = 5;
        for (int i = 0; i < portionsNumber; i++) {
            synchronized (monitor) {
                while (!letter.equals(newLetter)){
                    try {
                        monitor.wait();
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                printLine();
                monitor.notifyAll();
            }
        }
    }

    private void printLine() {
        System.out.print(letter);
        counter = (counter + 1) % PrinterController.THREADS_NUMBER;
        if (counter == 0){
            newLetter = "A";
        }
        if (counter == 1){
            newLetter = "B";
        }
        if (counter == 2){
            newLetter = "C";
        }
    }
}
