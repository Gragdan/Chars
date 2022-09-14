import java.util.*;

public class Main {
    static String original = new String("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
            "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
            "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
            "esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt " +
            "in culpa qui officia deserunt mollit anim id est laborum.");
    static String text = original.toLowerCase();

    public static void main(String[] args) {
        int maxValue = -1;
        int minValue = Integer.MAX_VALUE;
        char keyMax = '\0';
        char keyMin = '\0';
        Map<Character, Integer> textMap = new HashMap<>();
        Set<Character> textSet = new HashSet<>();

        for (int i = 0; i < text.length(); i++) {
            char myChar = text.charAt(i);

            if (Character.isLetter(myChar)) {
                if (!textMap.containsKey(myChar)) {
                    textMap.put(myChar, 1);
                } else {
                    int value = textMap.get(myChar);
                    textMap.put(myChar, value + 1);
                }
            }

        }
        ArrayList<Character> keys = new ArrayList<>(textMap.keySet());
        for (int i = 0; i < textMap.size(); i++) {
            char key = keys.get(i);
            int val = textMap.get(key);
            if (maxValue < val) {
                maxValue = val;
                keyMax = keys.get(i);
            }
            if (minValue > val) {
                minValue = val;
                keyMin = keys.get(i);
            }
        }
        // System.out.println(textMap.values());
        System.out.println("Чаще всего встречается буква - " + keyMax + " количество повторов - " + maxValue);
        System.out.println("Самая редкая буква - " + keyMin + " количество повторов - " + minValue);

    }
}
