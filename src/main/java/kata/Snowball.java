package kata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum Snowball {
    ARCTIC_FOX("Arctic Fox"),
    B("Ice Skates"),
    MERRY_GO_ROUND("Merry-go-round"),
    D("Mittens"),
    E("Santa's Sack"),
    F("Town tree"),
    G("Teddy"),
    H("Crackers"),
    J("Master Driver 1000"),
    ADVENT_CALENDAR("Advent Calender");

    String name;
}
