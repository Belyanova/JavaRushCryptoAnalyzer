package decryptions;

import handlers.FileHandler;
import alphabets.RussianAlphabet;
import alphabets.RussianWords;

import static handlers.AlphabetHandler.findIndexInAlphabet;

public class DecryptionBruteForce {
    private static String decryptionUsingKey(int key, String encryptedText) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char currentChar = encryptedText.charAt(i);
            boolean isUpperCase = Character.isUpperCase(currentChar);

            int indexInAlphabet = findIndexInAlphabet(Character.toLowerCase(currentChar));
            if (indexInAlphabet != -1) {
                int decryptedIndex = (indexInAlphabet - key + RussianAlphabet.ALPHABET.length) % RussianAlphabet.ALPHABET.length;
                char decryptedChar = RussianAlphabet.ALPHABET[decryptedIndex];
                decryptedChar = isUpperCase ? Character.toUpperCase(decryptedChar) : decryptedChar;
                decryptedText.append(decryptedChar);
            } else {
                decryptedText.append(currentChar);
            }
        }
        return decryptedText.toString();
    }

    private static int bruteForceKeyFinder(String encryptedText) {
        int threshold = 5;

        for (int key = 1; key < RussianAlphabet.ALPHABET.length; key++) { // Key can't be 0
            String decryptedText = decryptionUsingKey(key, encryptedText);
            int foundWords = 0;
            for (String word : RussianWords.RUSSIANWORDS) {
                if (decryptedText.contains(word)) {
                    foundWords++;
                }
            }

            if (foundWords >= threshold) {
                return key;
            }
        }
        return -1;
    }

    public static void writeDecryptionBruteForceResultToFile(String pathToEncryptedFile, String pathToFileToWrite) {
        String encryptedText = FileHandler.readFile(pathToEncryptedFile);
        System.out.println("Зашифрованный текст из файла: " + encryptedText);

        int key = bruteForceKeyFinder(encryptedText);
        if (key != -1) {
            String decryptionResult = decryptionUsingKey(key, encryptedText);
            System.out.println("Результат расшифровки: " + decryptionResult);
            FileHandler.writeFile(pathToFileToWrite, decryptionResult);
        } else {
            System.err.println("Не удалось найти ключ.");
        }
    }
}