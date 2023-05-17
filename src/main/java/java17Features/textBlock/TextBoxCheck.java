package java17Features.textBlock;

public class TextBoxCheck {
    public static void main(String[] args) {
        String text = """
                public class Hello {
                    public static void main(String[] args) {
                         System.out.println("Very very looooong \
                         looooooooooooooooooooooooooong \
                         loooooooooooong string");
                    }
                }""";
        System.out.println(text);
    }
}
