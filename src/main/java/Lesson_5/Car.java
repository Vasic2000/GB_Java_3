package Lesson_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private final CyclicBarrier cb;
    private final Semaphore smp;
    private final ReentrantLock r1;
    private AtomicInteger ai;


    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cyclicBarrier, Semaphore smp, ReentrantLock r1, AtomicInteger ai) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cb = cyclicBarrier;
        this.smp = smp;
        this.r1 = r1;
        this.ai = ai;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
// Костыль, все ждут 0,01 сек, чтобы main успел махнуть флажком до старта машинок
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++)
                race.getStages().get(i).go(this, smp);
        try {
            r1.lock();
                    ai.incrementAndGet();
            r1.unlock();
            cb.await();

            if(ai.equals(1)) {
                ai.incrementAndGet();
                System.out.println(this.name + " победитель");
            } else {
                ai.incrementAndGet();
                System.out.println(this.name + " пришёл " + ai + "-м");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

