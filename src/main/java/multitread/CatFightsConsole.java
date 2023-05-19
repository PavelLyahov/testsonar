package multitread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CatFightsConsole {
    public static void main(String[] args){
        System.out.println("Cat Fights Console");
        List<Cat> catThreads = new ArrayList<>();
        int life = 9;
        Collections.addAll(catThreads,
                new Cat("Tom", life, "Thread Tom"),
                new Cat("Cleocatra", life, "Thread Cleocatra"),
                new Cat("Dupli", life, "Thread Dupli"),
                new Cat("Toodles", life, "Thread Toodles"));

        for(Cat cat : catThreads)
            cat.getThread().start();

        for(Cat cat : catThreads){
            try{
                cat.getThread().join();
            }catch (InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(String.format("Кот-победитель: %s!!!", Cat.cats.get(0)));

    }
}
