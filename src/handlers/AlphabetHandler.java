package handlers;

import static alphabets.RussianAlphabet.ALPHABET;

public class AlphabetHandler {

    public static int findIndexInAlphabet(char c) {
        for (int i = 0; i < ALPHABET.length; i++) {
            if (ALPHABET[i] == c) {
                return i;
            }
        }
        return -1;
    }
}
