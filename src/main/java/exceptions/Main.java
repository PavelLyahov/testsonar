package exceptions;

public class Main {

    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        switch (a) {
            case 0: {
                b = 0;
            }
            case 1: {
                b = 1;
            }
            default: {
                b = 10;
            }
        }
        System.out.println(b);
    }
}
