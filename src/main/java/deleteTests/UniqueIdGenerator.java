package deleteTests;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueIdGenerator {
    private final Set<String> generatedValues;
    private final Random random;

    public UniqueIdGenerator() {
        generatedValues = new HashSet<>();
        random = new Random();
    }

    public String generateUniqueValue() {
        String value;
        do {
            long timestamp = System.currentTimeMillis();
            int randomNum = random.nextInt(1000);
            value = String.format("%d-%03d", timestamp, randomNum);
        } while (generatedValues.contains(value));

        generatedValues.add(value);
        return value;
    }
}




