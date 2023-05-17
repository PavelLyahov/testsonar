package stringTrainingTasks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class BackspaceInString {
    public static String cleanString(String str) {
        //"abc#d##c"), "ac"

        // a#b 0 1 2
        char backspace = '#';
        StringBuilder stringBuilder = new StringBuilder();
        byte[] letters = str.getBytes();

        for (int stringIndex = 0, builderIndex = 0; stringIndex < str.length(); stringIndex++) {
            char currentLetter = (char) letters[stringIndex];
            if (currentLetter != backspace) {
                stringBuilder.append(currentLetter);
                builderIndex++;
            } else {
                if( builderIndex > 0) {
                    stringBuilder.deleteCharAt(--builderIndex);
                }
            }
        }
        return stringBuilder.toString();
    }

    public String cleanString2(String s) {
        Deque<Character> characterDeque = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                characterDeque.pollLast();
            } else {
                characterDeque.offerLast(ch);
            }
        }
        return characterDeque.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
