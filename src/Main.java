import decryptions.DecryptionUsingKey;
import encryptions.Encryption;
import handlers.FileHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleRunner.consoleRunner();
        //String textFromFile = FileHandler.readFile(ConsoleRunner.pathToSourceFile);
        //System.out.println("Текст из файла для шифрования: " + textFromFile);
        //String encryptionResult = Encryption.encryption(ConsoleRunner.key, textFromFile);
        //System.out.println("Результат шифрования : " + encryptionResult);
        //FileHandler.writeFile(ConsoleRunner.pathToFileToWrite, encryptionResult);
        //String decryptionUsingKeyResult = DecryptionUsingKey.decryptionUsingKey(ConsoleRunner.key,encryptionResult);
        //System.out.println("Результат расшифровки : " + decryptionUsingKeyResult);
    }
}