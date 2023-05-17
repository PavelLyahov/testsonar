package kata;

import java.util.Arrays;
import java.util.List;

public class TotalPoints {
    public static int points(String[] games) {
        int points = 0;
        int win = 3;
        int drow = 1;
        int loss = 0;
        String splitter = ":";

        for (String game: games) {
            List<Integer> score = Arrays.stream(game.split(splitter)).map(Integer::parseInt).toList();

            if(score.get(0) > score.get(1)) {
                points += win;
            } else if(score.get(0) == score.get(1)) {
                points += drow;
            } else if(score.get(0) < score.get(1)) {
                points += loss;
            }
        }
        return points;
    }
}
