package multitread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

class Cat implements Runnable{
    private Random random = new Random();

    public static final List<Cat> cats = new CopyOnWriteArrayList<>();// Статический контейнер всех созданных «кототредов»
    private String name;
    private volatile int life;
    private Thread thread;

    public Cat(String name, int life, String threadName) {
        this.name = name;
        this.life = life;
        Cat.cats.add(this);
        thread = new Thread(this, threadName);
        System.out.println(String.format("Кот %s создан. HP: %d", this.name, this.life));
    }

    public static synchronized void attack(Cat thisCat, Cat enemyCat) {
        if (thisCat.getLife() <= 0) { return; }
        if (enemyCat.getLife() > 0) {
            enemyCat.decrementLife();
            System.out.println(String.format("Кот %s атаковал кота %s. Жизни %<s: %d", thisCat.getName(), enemyCat.getName(), enemyCat.getLife()));

            if (enemyCat.getLife() <= 0) {
                Cat.cats.remove(enemyCat);

                System.out.println(String.format("Кот %s покидает бой.", enemyCat.getName()));
                System.out.println(String.format("Оставшиеся коты: %s", Cat.cats));
                System.out.println(String.format("%s завершает свою работу.", enemyCat.getThread().getName()));

                enemyCat.getThread().interrupt();// interrupt() — прервать работу треда
            }
        }
    }

    @Override
    public void run() {
        System.out.printf("Кот %s идёт в бой.%n", name);

        while (Cat.cats.size() > 1){
            Cat.attack(this, getRandomEnemyCat(this));
        }
    }

    private Cat getRandomEnemyCat(Cat deleteThisCat) {
        List<Cat> copyCats = new ArrayList<>(Cat.cats);
        copyCats.remove(deleteThisCat);
        return copyCats.get(random.nextInt(copyCats.size()));
    }

    public synchronized void decrementLife() { life--; }

    @Override
    public String toString() { return name; }
    public String getName() { return name; }
    public int getLife() { return life; }
    public Thread getThread() { return thread; }
}

