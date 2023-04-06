import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore smp = new Semaphore(MainApp.HalfCarsCount);

    public Tunnel(int CarLimit) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.smp = new Semaphore(CarLimit);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                smp.acquire();
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
