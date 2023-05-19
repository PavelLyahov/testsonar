package generic;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<? extends Box<Integer>> list = new ArrayList<>();
        Parent parent = new Parent();
        Child child = (Child) parent;
        child.foo();
        String str = "bla bla";
    }
}
