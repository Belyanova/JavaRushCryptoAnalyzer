import java.util.Scanner;

import static decryptions.DecryptionStatisticalAnalysis.writeDecryptionStatisticalAnalysis;
import static decryptions.DecryptionUsingKey.writeDecryptionUsingKeyResultToFile;
import static decryptions.DecryptionBruteForce.writeDecryptionBruteForceResultToFile;
import static encryptions.Encryption.writeEncryptionResultToFile;

public class ConsoleRunner {
    public static void consoleRunner() {
        try (Scanner scanner = new Scanner(System.in)) {
            int method = selectMethod(scanner);
            switch (method) {
                case 1:
                    int keyForEncryption = selectKey(scanner);
                    String pathToSourceFileForEncryption = selectPathToSourceFile(scanner);
                    String pathToFileToWriteForEncryption = selectPathToFileToWrite(scanner);
                    writeEncryptionResultToFile(keyForEncryption, pathToSourceFileForEncryption,
                            pathToFileToWriteForEncryption);
                    break;
                case 2:
                    int keyForDecryption = selectKey(scanner);
                    String pathToSourceFileForDecryptionUsingKey = selectPathToSourceFile(scanner);
                    String pathToFileToWriteForDecryptionUsingKey = selectPathToFileToWrite(scanner);
                    writeDecryptionUsingKeyResultToFile(keyForDecryption, pathToSourceFileForDecryptionUsingKey,
                            pathToFileToWriteForDecryptionUsingKey);
                    break;
                case 3:
                    String pathToSourceFileForDecryptionBruteForce = selectPathToSourceFile(scanner);
                    String pathToFileToWriteForDecryptionBruteForce = selectPathToFileToWrite(scanner);
                    writeDecryptionBruteForceResultToFile(pathToSourceFileForDecryptionBruteForce,
                            pathToFileToWriteForDecryptionBruteForce);
                    break;
                case 4:
                    String representativeText = selectRepresentativeText(scanner);
                    String pathToSourceFileForDecryptionStatisticalAnalysis = selectPathToSourceFile(scanner);
                    String pathToFileToWriteForDecryptionStatisticalAnalysis = selectPathToFileToWrite(scanner);
                    writeDecryptionStatisticalAnalysis(representativeText, pathToSourceFileForDecryptionStatisticalAnalysis,
                            pathToFileToWriteForDecryptionStatisticalAnalysis);
                    break;
                default:
                    System.err.println("Некорректный выбор метода.");
                    break;
            }
        }
    }

    private static int selectMethod(Scanner scanner) {
        int method = 0;
        try {
            System.out.println("Программа может работать в двух режимах: Шифрование / Расшифровка");
            System.out.println("Чтобы выбрать режим Шифрование, введите 1 ");
            System.out.println("Чтобы выбрать режим Расшифровка по ключу, введите 2 ");
            System.out.println("Чтобы выбрать режим Расшифровка Brute Force, введите 3 ");
            System.out.println("Чтобы выбрать режим Расшифровка Статистический анализ, введите 4 ");
            method = scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка ввода: " + e.getMessage());
        }
        return method;
    }

    private static int selectKey(Scanner scanner){
        try {
            System.out.println("Введите значение ключа: ");
            int key = scanner.nextInt();
            return key;
        } catch (Exception e) {
            throw new RuntimeException("Ошибка ввода ключа: " + e.getMessage());
        }
    }

    private static String selectPathToSourceFile(Scanner scanner){
        try {
            System.out.println("Введите путь к файлу c текстом: ");
            scanner.nextLine();
            String pathToSourceFile = scanner.nextLine();
            return pathToSourceFile;
        } catch (Exception e) {
            throw new RuntimeException("Ошибка ввода пути к файлу: " + e.getMessage());
        }
    }

    private static String selectPathToFileToWrite(Scanner scanner){
        try {
            System.out.println("Введите путь к файлу для записи текста: ");
            String pathToFileToWrite = scanner.nextLine();
            return pathToFileToWrite;
        } catch (Exception e) {
            throw new RuntimeException("Ошибка ввода пути к файлу: " + e.getMessage());
        }
    }

    private static String selectRepresentativeText(Scanner scanner){
        try {
            System.out.println("Введите пример репрезентативного текста: ");
            String representativeText = scanner.nextLine();
            return representativeText;
        } catch (Exception e) {
            throw new RuntimeException("Ошибка ввода пути к файлу: " + e.getMessage());
        }
    }
}
