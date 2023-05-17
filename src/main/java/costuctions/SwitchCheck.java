package costuctions;

public class SwitchCheck {
    public static void main(String[] args) {
        int a = 0;
        switch (a) {
            case 0 ->                {
                System.out.println(1);
                break;
            }
            case 1 ->                System.out.println(2);
            case 2 ->
                System.out.println(3);
        }
    }
}
