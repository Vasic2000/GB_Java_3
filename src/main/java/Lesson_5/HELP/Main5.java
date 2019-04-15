package Lesson_5.HELP;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main5 {
    public static void main(String[] args) {
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(1);
//            }
//        });
//
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(2);
//            }
//        });
//
//
//        Thread t3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(3);
//            }
//        });
//
//        t1.setPriority(1);
//        t2.setPriority(5);
//        t3.setPriority(10);
//
//        t1.start();
//        t2.start();
//        t3.start();

//        ExecutorService pool = Executors.newFixedThreadPool(4, new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                return new Thread(r);
//            }
//        });

//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                System.out.println(1);
//            }
//        });
//
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                System.out.println(2);
//            }
//        });
//
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                System.out.println(3);
//            }
//        });
//
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                System.out.println(4);
//            }
//        });
//
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                System.out.println(5);
//            }
//        });
//
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                System.out.println(6);
//            }
//        });
//
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                System.out.println(7);
//            }
//        });
//
//        pool.shutdown();

//        ScheduledExecutorService serv = Executors.newScheduledThreadPool(5, new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                return null;
//            }
//        });
//        serv.scheduleAtFixedRate(10);
//        serv.scheduleWithFixedDelay()
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, 22);
//        calendar.set(Calendar.MINUTE, 15);
//        calendar.set(Calendar.SECOND, 0);
//
//        Date time = calendar.getTime();
//        Timer timer = new Timer();
//
//        timer.schedule(new RemindTask(), time);


        // ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(10);

//        try {
//            abq.offer("asd", 50, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //    abq.put("asd");

//        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>();
//
//        Map<String, String> hm = Collections.synchronizedMap(new HashMap<String, String>());


//        final Semaphore smp = new Semaphore(3);
//
//        ExecutorService serv = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 10; i++) {
//            serv.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        smp.acquire();
//                        System.out.println(1);
//                        Thread.sleep(3000);
//                        smp.release();
//                      //  System.out.println(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            });
//        }
//        serv.shutdown();


//        final CountDownLatch cdl = new CountDownLatch(5);
//
//
//        for (int i = 0; i < 5; i++) {
//            final int w = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                   // System.out.println(w);
//                    try {
//                        int timer = (int)(Math.random() * 1000);
//                        System.out.println(timer);
//                        Thread.sleep(timer);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                  //  System.out.println(w);
//                    cdl.countDown();
//                }
//            }).start();
//        }
//
//        try {
//            cdl.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("START!");


//        final CyclicBarrier cb = new CyclicBarrier(5);
//
//        for (int i = 0; i < 8; i++) {
//            final int w = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
////                    System.out.println(w);
//                    int timer = 0;
//                    try {
//                        timer = (int) (Math.random() * 1000);
//                        System.out.println(w + " подготовка " + timer + " мс");
//                        Thread.sleep(timer);
//                        System.out.println(w + " готов " + timer + " мс потратил!");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    //  System.out.println(w);
//                    try {
//                        cb.await();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } catch (BrokenBarrierException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("END");
//                }
//            }).start();
//        }

//        final ReentrantLock r1 = new ReentrantLock();
//
//        ReentrantReadWriteLock r2 = new ReentrantReadWriteLock();
//
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                r1.lock();
//                System.out.println(1);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(2);
//                r1.unlock();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                r1.lock();
//                System.out.println(3);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(4);
//                r1.unlock();
//            }
//        }).start();

//        AtomicInteger ai = new AtomicInteger(100);
//
//        ai.compareAndSet(100,150);
//
//        System.out.println(ai);





//    }
//    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
//
//    static class Read implements Runnable {
//
//        @Override
//        public void run() {
//            for (int i = 0; i < 10; i++) {
//                if (lock.isWriteLocked()) {
//                    System.out.println("take lock from write");
//                }
//                lock.readLock().lock();
//                System.out.println("work");
//                lock.readLock().unlock();
//            }
//        }
//    }
//}

//class RemindTask extends TimerTask {
//    @Override
//    public void run() {
//        System.out.println("UP");
    }
}
