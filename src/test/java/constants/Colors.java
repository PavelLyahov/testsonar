package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Colors {
    GREEN("#90ed7d");

    private final String colorCode;

    public static Colors parse(String value) {
        return Arrays.stream(values()).filter(item -> item.name().equalsIgnoreCase(value))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
