package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum AccountItemsStatus {
    CURRENT("Current"),
    PAST("Past");

    private final String accountItemsStatus;

    public static AccountItemsStatus parse(String accountItemsStatus) {
        return Arrays.stream(values()).filter(item -> item.name().equalsIgnoreCase(accountItemsStatus))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public static AccountItemsStatus fromString(String status) {
        for (AccountItemsStatus itemsStatus : AccountItemsStatus.values()) {
            if (itemsStatus.accountItemsStatus.equalsIgnoreCase(status)) {
                return itemsStatus;
            }
        }
        throw new IllegalArgumentException("Wrong state: " + status);
    }
}
