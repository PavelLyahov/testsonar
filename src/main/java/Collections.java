import java.awt.*;
import java.util.List;

public class Collections {
    private static final int TAP_MIDDLE_SPIN_BUTTON_Y_OFFSET = 0;
    private static final int TAP_PORTRAIT_MIDDLE_SPIN_BUTTON_X_OFFSET = 0;
    int TAP_PORTRAIT_MIDDLE_SPIN_BUTTON_Y_OFFSET = 0;
    int EXTRA_TAP_FEATURE_X_OFFSET = 0;
    int EXTRA_TAP_FEATURE_Y_OFFSET = 0;
    int TAP_SPIN_BUTTON_X_OFFSET = 0;
    int TAP_SPIN_BUTTON_Y_OFFSET = 0;
    int EXTRA_TAP_SPIN_BUTTON_X_OFFSET = 0;
    int TAP_MIDDLE_SPIN_BUTTON_X_OFFSET = 0;




    public void waiting() {
        if (isFeatureContinueAndRestartViewIsNotPresent()) {
            tapByCoordinatesOffset(EXTRA_TAP_FEATURE_X_OFFSET, EXTRA_TAP_FEATURE_Y_OFFSET);
            if (isFeatureContinueAndRestartViewIsNotPresent()) {
                tapByCoordinatesOffset(TAP_SPIN_BUTTON_X_OFFSET, TAP_SPIN_BUTTON_Y_OFFSET);
                if (isFeatureContinueAndRestartViewIsNotPresent()) {
                    tapByCoordinatesOffset(EXTRA_TAP_SPIN_BUTTON_X_OFFSET, TAP_SPIN_BUTTON_Y_OFFSET);
                    if (isFeatureContinueAndRestartViewIsNotPresent()) {
                        tapByCoordinatesOffset(TAP_MIDDLE_SPIN_BUTTON_X_OFFSET, TAP_MIDDLE_SPIN_BUTTON_Y_OFFSET);
                        if (isFeatureContinueAndRestartViewIsNotPresent()) {
                            tapByCoordinatesOffset(TAP_PORTRAIT_MIDDLE_SPIN_BUTTON_X_OFFSET, TAP_PORTRAIT_MIDDLE_SPIN_BUTTON_Y_OFFSET);
                            if (isFeatureContinueAndRestartViewIsNotPresent())
                                tapScreenByRectangle();
                        }
                    }
                }
            }
        }
    }

    public void waitingw() {

        List<Point> points =List.of(new Point(EXTRA_TAP_FEATURE_X_OFFSET, EXTRA_TAP_FEATURE_Y_OFFSET),
                new Point(TAP_SPIN_BUTTON_X_OFFSET, TAP_SPIN_BUTTON_Y_OFFSET),
                new Point(EXTRA_TAP_SPIN_BUTTON_X_OFFSET, TAP_SPIN_BUTTON_Y_OFFSET),
                new Point(TAP_MIDDLE_SPIN_BUTTON_X_OFFSET, TAP_MIDDLE_SPIN_BUTTON_Y_OFFSET),
                new Point(TAP_PORTRAIT_MIDDLE_SPIN_BUTTON_X_OFFSET, TAP_PORTRAIT_MIDDLE_SPIN_BUTTON_Y_OFFSET));

        points.forEach(point -> {
            if(isFeatureContinueAndRestartViewIsNotPresent()) {
                tapByCoordinatesOffset(point.x, point.y);
            }
        });
        for (Point point: points) {
            if(isFeatureContinueAndRestartViewIsNotPresent()) {
                tapByCoordinatesOffset(point.x, point.y);
            }
        }

        List.of(new Point(EXTRA_TAP_FEATURE_X_OFFSET, EXTRA_TAP_FEATURE_Y_OFFSET),
                new Point(TAP_SPIN_BUTTON_X_OFFSET, TAP_SPIN_BUTTON_Y_OFFSET),
                new Point(EXTRA_TAP_SPIN_BUTTON_X_OFFSET, TAP_SPIN_BUTTON_Y_OFFSET),
                new Point(TAP_MIDDLE_SPIN_BUTTON_X_OFFSET, TAP_MIDDLE_SPIN_BUTTON_Y_OFFSET),
                new Point(TAP_PORTRAIT_MIDDLE_SPIN_BUTTON_X_OFFSET, TAP_PORTRAIT_MIDDLE_SPIN_BUTTON_Y_OFFSET))
            .forEach(point -> {
            if(isFeatureContinueAndRestartViewIsNotPresent()) {
                tapByCoordinatesOffset(point.x, point.y);
            }
        });


        if (isFeatureContinueAndRestartViewIsNotPresent()) {
            tapByCoordinatesOffset(EXTRA_TAP_FEATURE_X_OFFSET, EXTRA_TAP_FEATURE_Y_OFFSET);
            if (isFeatureContinueAndRestartViewIsNotPresent()) {
                tapByCoordinatesOffset(TAP_SPIN_BUTTON_X_OFFSET, TAP_SPIN_BUTTON_Y_OFFSET);
                if (isFeatureContinueAndRestartViewIsNotPresent()) {
                    tapByCoordinatesOffset(EXTRA_TAP_SPIN_BUTTON_X_OFFSET, TAP_SPIN_BUTTON_Y_OFFSET);
                    if (isFeatureContinueAndRestartViewIsNotPresent()) {
                        tapByCoordinatesOffset(TAP_MIDDLE_SPIN_BUTTON_X_OFFSET, TAP_MIDDLE_SPIN_BUTTON_Y_OFFSET);
                        if (isFeatureContinueAndRestartViewIsNotPresent()) {
                            tapByCoordinatesOffset(TAP_PORTRAIT_MIDDLE_SPIN_BUTTON_X_OFFSET, TAP_PORTRAIT_MIDDLE_SPIN_BUTTON_Y_OFFSET);
                            if (isFeatureContinueAndRestartViewIsNotPresent())
                                tapScreenByRectangle();
                        }
                    }
                }
            }
        }
    }

    public  boolean isFeatureContinueAndRestartViewIsNotPresent(){
        return true;
    }

    public void tapByCoordinatesOffset(int x, int y) {    }

    public void  tapScreenByRectangle(){}
}