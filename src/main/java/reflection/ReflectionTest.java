package reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class ReflectionTest {
    public static void main(String[] args) {
        Expert leshaChurov = new Expert("Alex", "Chu");
        System.out.println(TestExpert.isExpert(leshaChurov));
    }
}

class Expert {
    @Size(min=1, max=12)
    private final String lesha;
    @Size(min=3, max=10)
    private final String churov;

    public Expert (String lesha, String churov) {
        this.lesha = lesha;
        this.churov = churov;
    }
}

class TestExpert {
    public static boolean isExpert(Expert expert) {
        boolean isExpert = false;
        Class clazzExpert = expert.getClass();
        Field leshaField;
        Field churovField;
        String leshaString = null;
        String churovString = null;
        int leshaMin = 0;
        int leshaMax = 0;
        int churovMin = 0;
        int churovMax = 0;
        try {
            leshaField = clazzExpert.getDeclaredField("lesha");
            churovField = clazzExpert.getDeclaredField("churov");
            leshaField.setAccessible(true);
            churovField.setAccessible(true);
            leshaString = (String) leshaField.get(expert);
            churovString = (String) churovField.get(expert);
            leshaMin = leshaField.getAnnotation(Size.class).min();
            leshaMax = leshaField.getAnnotation(Size.class).max();
            churovMin = churovField.getAnnotation(Size.class).min();
            churovMax = churovField.getAnnotation(Size.class).max();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        if (leshaString.length() > leshaMin &&
            leshaString.length() < leshaMax &&
            churovString.length() > churovMin &&
            churovString.length() < churovMax) {
            isExpert = true;
        }
        return isExpert;
    }
}

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Size {
    int min();
    int max();
}



