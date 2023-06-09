import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainApp {
    public static final int Cars_Count = 7;
    public static final int HalfCarsCount = Cars_Count / 2;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        CyclicBarrier cb = new CyclicBarrier(8);
        CountDownLatch cdl = new CountDownLatch(Cars_Count);
        Race race = new Race(new Road(60), new Tunnel(2), new Road(40));
        Car[] cars = new Car[Cars_Count];
        for (int i = 0; i < cars.length; i++){
            cars[i] = new Car(race, 20 + (int)(Math.random() * 10), cb, cdl);
        }
        for (int i = 0; i < cars.length; i++){
            new Thread(cars[i]).start();
        }
        try{
            cb.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            cb.await();
            cb.await();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        for (int i = 1; i<=3; i++) {
//            System.out.println(cars[i].getName()+" "+cars[i].pied);
            for(int j = 0; j<7; j++){
                if( i == cars[j].pied){
                    System.out.println(i+" место "+ cars[j].getName());
                }
            }
        }
    }
}
