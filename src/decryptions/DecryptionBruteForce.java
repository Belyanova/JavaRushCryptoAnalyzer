package decryptions;

import handlers.FileHandler;

import static alphabets.RussianWords.RUSSIANWORDS;
import static alphabets.RussianAlphabet.ALPHABET;
import static handlers.AlphabetHandler.findIndexInAlphabet;

public class DecryptionBruteForce {

//реализация метода
    public static String decryptionBruteForce(String textForDecryption){
        return textForDecryption;
    }

    public static void writeDecryptionBruteForceResultToFile(String pathToSourceFile, String pathToFileToWrite){
        String textFromFile = FileHandler.readFile(pathToSourceFile);
        System.out.println("Текст из файла для расшифровки: " + textFromFile);
        String decryptionResult = decryptionBruteForce(textFromFile);
        System.out.println("Результат расшифровки Brute Force : " + decryptionResult);
        FileHandler.writeFile(pathToFileToWrite, decryptionResult);
    }

}
