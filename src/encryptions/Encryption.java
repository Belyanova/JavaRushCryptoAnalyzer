package encryptions;

import handlers.FileHandler;

import static alphabets.RussianAlphabet.ALPHABET;
import static handlers.AlphabetHandler.findIndexInAlphabet;

public class Encryption {
    private static StringBuilder encryptedText = new StringBuilder();
    private static String encryption(int key, String text){
        if(key > 0 && key < text.length() - 1){
            for (int i = 0; i < text.length(); i++) {
                char currentChar = text.charAt(i);
                boolean isUpperCase = Character.isUpperCase(currentChar);

                int indexInAlphabet = findIndexInAlphabet(Character.toLowerCase(currentChar));
                if (indexInAlphabet != -1) {
                    int encryptedIndex = (indexInAlphabet + key) % ALPHABET.length;
                    char encryptedChar = ALPHABET[encryptedIndex];
                    encryptedChar = isUpperCase ? Character.toUpperCase(encryptedChar) : encryptedChar;
                    encryptedText.append(encryptedChar);
                }
            }
            return encryptedText.toString();
        } else {
            return "Key invalid";
        }
    }

    public static void writeEncryptionResultToFile(int key, String pathToSourceFile, String pathToFileToWrite){
        String textFromFile = FileHandler.readFile(pathToSourceFile);
        System.out.println("Текст из файла для шифрования: " + textFromFile);
        String encryptionResult = encryption(key, textFromFile);
        System.out.println("Результат шифрования : " + encryptionResult);
        FileHandler.writeFile(pathToFileToWrite, encryptionResult);
    }
}
