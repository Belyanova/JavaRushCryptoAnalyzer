package decryptions;

import alphabets.RussianAlphabet;
import handlers.FileHandler;

import java.util.HashMap;
import java.util.Map;

import static handlers.AlphabetHandler.findIndexInAlphabet;

public class DecryptionStatisticalAnalysis {

    public static String decryptionStatisticalAnalysis(String representativeText, String encryptedText) {
        Map<Character, Double> representativeFrequency = calculateLetterFrequency(representativeText);
        Map<Character, Double> encryptedFrequency = calculateLetterFrequency(encryptedText);
        int optimalKey = findOptimalShift(representativeFrequency, encryptedFrequency);
        return decryptCaesarCipherWithShift(encryptedText, optimalKey);
    }

    private static Map<Character, Double> calculateLetterFrequency(String representativeText) {
        Map<Character, Integer> letterCount = new HashMap<>();
        int totalLetters = 0;
        for (char c : representativeText.toCharArray()) {
            if (Character.isLetter(c)) {
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
                totalLetters++;
            }
        }
        Map<Character, Double> frequency = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : letterCount.entrySet()) {
            char letter = entry.getKey();
            int count = entry.getValue();
            double percentage = (totalLetters > 0) ? (count / (double) totalLetters) * 100 : 0;
            frequency.put(letter, percentage);
        }
        return frequency;
    }

    private static int findOptimalShift(Map<Character, Double> representativeFrequency, Map<Character, Double> encryptedFrequency) {
        double minDeviation = Double.MAX_VALUE;
        int optimalShift = 0;
        for (int key = 0; key < RussianAlphabet.ALPHABET.length; key++) {
            double deviation = calculateDeviation(representativeFrequency, encryptedFrequency, key);
            if (deviation < minDeviation) {
                minDeviation = deviation;
                optimalShift = key;
            }
        }
        return optimalShift;
    }

    private static double calculateDeviation(Map<Character, Double> representativeFrequency, Map<Character, Double> encryptedFrequency, int key) {
        double deviation = 0;
        for (char letter : representativeFrequency.keySet()) {
            char shiftedLetter = (char) ((letter - 'а' + key) % RussianAlphabet.ALPHABET.length + 'а');
            double representativeFreq = representativeFrequency.getOrDefault(letter, 0.0);
            double encryptedFreq = encryptedFrequency.getOrDefault(shiftedLetter, 0.0);
            deviation += Math.pow(representativeFreq - encryptedFreq, 2);
        }
        return deviation;
    }

    private static String decryptCaesarCipherWithShift(String encryptedText, int key) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char currentChar = encryptedText.charAt(i);
            int indexInAlphabet = findIndexInAlphabet(Character.toLowerCase(currentChar));
            if (indexInAlphabet != -1) {
                int decryptedIndex = (indexInAlphabet - key + RussianAlphabet.ALPHABET.length) % RussianAlphabet.ALPHABET.length;
                char decryptedChar = (Character.isUpperCase(currentChar)) ?
                        Character.toUpperCase(RussianAlphabet.ALPHABET[decryptedIndex]) :
                        RussianAlphabet.ALPHABET[decryptedIndex];
                decryptedText.append(decryptedChar);
            } else {
                decryptedText.append(currentChar);
            }
        }
        return decryptedText.toString();
    }

    public static void writeDecryptionStatisticalAnalysis(String representativeText, String pathToSourceFile, String pathToFileToWrite) {
        String textFromFile = FileHandler.readFile(pathToSourceFile);
        System.out.println("Текст из файла для расшифровки: " + textFromFile);
        String decryptionResult = decryptionStatisticalAnalysis(representativeText, textFromFile);
        System.out.println("Результат расшифровки по методу статического анализа: " + decryptionResult);
        FileHandler.writeFile(pathToFileToWrite, decryptionResult);
    }
}
