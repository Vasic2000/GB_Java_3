package Lesson_5.HELP2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Lena {


    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Semaphore sem = new Semaphore(CARS_COUNT/2); // 1 разрешение
        final Race1 race1 = new Race1(new Road1(60), new Tunnel1(sem), new Road1(40));
        final Car1[] cars1 = new Car1[CARS_COUNT];
        final ReentrantLock r1 = new ReentrantLock();
        for (int i = 0; i < cars1.length; i++) {
            cars1[i] = new Car1(r1, race1, 20 + (int) (Math.random() * 10));
        }

        final CountDownLatch cdl = new CountDownLatch(CARS_COUNT + 1);
        for (int i = 0; i < cars1.length; i++) {
            final int w = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //  r1.lock();
                    try {
                        new Thread(cars1[w]).start();
                        Thread.sleep(1000);
                        //    System.out.println(cars[w].getName() + " готов");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(cars1[w].getName() + " готов");
                    cdl.countDown();
                    // r1.unlock();
                }
            }).start();
        }
        try {

            cdl.await();
            System.out.println("START!");
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //  System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }


}

class Car1 implements Runnable{

    private static AtomicInteger at = new AtomicInteger(0);
    private int myCounter;

    final ReentrantLock r1;
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race1 race1;
    private int speed;
    private String name;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car1(ReentrantLock r1, Race1 race1, int speed) {
        this.r1 = r1;
        this.race1 = race1;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            r1.lock();
            Thread.sleep(500 + (int) (Math.random() * 800));
            //  System.out.println(this.getName() + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //  System.out.println(this.getName() + " готов");
        r1.unlock();

        for (int i = 0; i < race1.getStage1s().size(); i++) {
            race1.getStage1s().get(i).go(Car1.this);
        }

    }
}

abstract class Stage1 {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car1 c);
}

class Road1 extends Stage1 {
//    private static AtomicInteger at = new AtomicInteger(0);
//     private int myCounter;
    public Road1(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car1 c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            //   myCounter = at.incrementAndGet();
            //  System.out.println(c.getName() + " Counter " + myCounter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Tunnel1 extends Stage1 {
    Semaphore sem;

    public Tunnel1(Semaphore sem) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.sem = sem;
    }


    @Override
    public void go(Car1 c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                sem.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(c.getName() + " закончил этап: " + description);
            sem.release();

//            finally {

//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Race1 {
    private ArrayList<Stage1> stage1s;

    public ArrayList<Stage1> getStage1s() {
        return stage1s; }

    public Race1(Stage1... stage1s) {
        this.stage1s = new ArrayList<Stage1>(Arrays.asList(stage1s));
    }



}
