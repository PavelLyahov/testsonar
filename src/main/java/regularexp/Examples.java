package regularexp;

public class Examples {
    public static void main(String[] args) {
        String ADDITIONAL = "---";
        System.out.println(String.format("%s%s%s", ADDITIONAL, removeParentheses("The tea(tea) in Nepal is(( is) very hot"), ADDITIONAL));
        System.out.println("---" + purify("BiitCh estiIng    aIIIa2   5 I 7") + "---");

    }

    public static String removeParentheses(final String str) {
        return str.replaceAll("\\(.*?\\)", "").replaceAll("\\[.*?\\]", "");
    }

    /**
    replace 1 letter befor and after i and I
     replace many spaces to one
     */
    public static String purify(String s) {
        return s.trim().replaceAll("\\S?(i+|I+)\\S?", "").replaceAll("\s+", " ");
    }
}
