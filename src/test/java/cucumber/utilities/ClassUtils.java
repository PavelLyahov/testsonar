package cucumber.utilities;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ClassUtils {

    public static List<Field> getNotEmptyFields(Object object) {
        List<Field> list = new ArrayList<>();

        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                if (field.get(object) != null) {
                    list.add(field);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static List<String> getNotEmptyFieldsValues(Object object) {
        List<String> values = new ArrayList<>();
        for (Field field : getNotEmptyFields(object)) {
            try {
                values.add(String.valueOf(field.get(object)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return values;
    }

}
