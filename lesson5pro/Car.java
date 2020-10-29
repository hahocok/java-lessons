package learning;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private final Race race;
    private final int speed;
    private final String name;
    private static final AtomicInteger ai = new AtomicInteger(0);

    private final CyclicBarrier cbCars;
    private final CountDownLatch cdlRace;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cbCars, CountDownLatch cdlRace) {
        this.race = race;
        this.speed = speed;
        this.cbCars = cbCars;
        this.cdlRace = cdlRace;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cbCars.await();
            cbCars.await();

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this, cdlRace);
            }

            if (ai.incrementAndGet() == 1) {
                System.out.println(name + " " + "- WIN!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
