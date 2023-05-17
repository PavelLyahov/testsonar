package annotations;

public class Main {
    /**
     * @param args
     * bla bla bla
     * @author Pavel
     */
    public static void main(String[] args) {
        User user = new User();
        try {
            String nameAnnotation = User.class.getDeclaredField("name").getAnnotation(Name.class).name();
            System.out.println(nameAnnotation);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
