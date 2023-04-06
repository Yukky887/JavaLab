import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int Cars_Count;
    private static boolean winner;
    private static Lock win = new ReentrantLock();

    static {
        Cars_Count = 0;
    }

    public String getName() {
        return name;
    }

    private Race race;

    public int getSpeed() {
        return speed;
    }
    int j = 0;

    private int speed;

    private String name;
    private int count;
    private CyclicBarrier cb;
    private CountDownLatch cdl;
    public static AtomicInteger ai;
    public int pied;
    static{
        ai = new AtomicInteger(0);
    }
    public static int i = 1;

    public Car(Race race, int speed, CyclicBarrier cb, CountDownLatch cdl){
        this.race = race;
        this.speed = speed;
        Cars_Count++;
        this.name = "Участник: " + Cars_Count;
        this.cb = cb;
        this.cdl = cdl;
    }


    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();
            cb.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            win.lock();
            CheckWinner(this);
            /*CheckPied(this);*/
            Thread.sleep((1000));
            win.unlock();
            cb.await();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private synchronized void CheckWinner(Car c){
        if (ai.get() == 0 & i < 4){

            System.out.println(c.name + " Занял " + i + " место!");
            c.pied = i;
            i++;
        }
    }
}
