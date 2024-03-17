package handlers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {
    public static String readFile(String filePath) {
        StringBuilder text = new StringBuilder();
        if (!Files.exists(Paths.get(filePath))) {
            throw new RuntimeException("Файл не существует: " + filePath);
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + filePath + e.getMessage());
        }
        return text.toString();
    }

    public static void writeFile(String filePath, String text) {
        if (!Files.exists(Paths.get(filePath))) {
            throw new RuntimeException("Файл не существует: " + filePath);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
