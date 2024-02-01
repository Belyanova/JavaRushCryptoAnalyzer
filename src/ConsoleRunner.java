import java.util.Scanner;

import static decryptions.DecryptionUsingKey.writeDecryptionUsingKeyResultToFile;
import static encryptions.Encryption.writeEncryptionResultToFile;

public class ConsoleRunner {
    public static String pathToFileToWrite = null;
    public static String pathToSourceFile = null;
    public static int key = 0;

    public static void consoleRunner() {
        Scanner scanner = new Scanner(System.in);
        try {
            int method = selectMethod(scanner);
            switch (method) {
                case 1:
                    selectFilesForEncryption(scanner);
                    writeEncryptionResultToFile(key, pathToSourceFile, pathToFileToWrite);
                    break;
                case 2:
                    selectFilesForDecryptionUsingKey(scanner);
                    writeDecryptionUsingKeyResultToFile(key, pathToSourceFile, pathToFileToWrite);
                    break;
                default:
                    System.err.println("Некорректный выбор метода.");
                    break;
            }
        } finally {
            scanner.close();
        }
    }

    protected static int selectMethod(Scanner scanner) {
        int method = 0;
        try {
            System.out.println("Программа может работать в двух режимах: Шифрование / Расшифровка");
            System.out.println("Чтобы выбрать режим Шифрование, введите 1 ");
            System.out.println("Чтобы выбрать режим Расшифровка, введите 2 ");
            System.out.println("Чтобы выбрать режим Расшифровка по ключу, введите 3 ");
            System.out.println("Чтобы выбрать режим Brute Force, введите 4 ");
            System.out.println("Чтобы выбрать режим Статистический анализ, введите 5 ");
            method = scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка ввода: " + e.getMessage());
        }
        return method;
    }

    protected static void selectFilesForEncryption(Scanner scanner) {
        try {
            System.out.println("Введите путь к файлу с оригинальным текстом: ");
            scanner.nextLine();
            pathToSourceFile = scanner.nextLine();
            System.out.println("Введите значение ключа: ");
            key = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введите путь к файлу для записи зашифрованного текста: ");
            pathToFileToWrite = scanner.nextLine();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка ввода: " + e.getMessage());
        }
    }

    protected static void selectFilesForDecryptionUsingKey(Scanner scanner) {
        try {
            System.out.println("Введите путь к файлу с зашифрованным текстом: ");
            scanner.nextLine();
            pathToSourceFile = scanner.nextLine();
            System.out.println("Введите значение ключа: ");
            key = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введите путь к файлу для записи расшифрованного текста: ");
            pathToFileToWrite = scanner.nextLine();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка ввода: " + e.getMessage());
        }
    }
}
