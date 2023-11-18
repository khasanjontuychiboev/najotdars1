package demo.demo34;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CodeGenerator {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Generate codes from a-b
        char startCharA = 'a';
        char endCharA = 'b';
        executor.submit(() -> {
            generateCodes(startCharA, endCharA);
        });

        // Generate codes from A-B
        char startCharB = 'A';
        char endCharB = 'B';
        executor.submit(() -> {
            generateCodes(startCharB, endCharB);
        });

        // Generate codes from 0-9
        char startCharC = '0';
        char endCharC = '9';
        executor.submit(() -> {
            generateCodes(startCharC, endCharC);
        });

        executor.shutdown();
    }

    public static void generateCodes(char startChar, char endChar) {
        for (char c = startChar; c <= endChar; c++) {
            System.out.println("Generated code: " + c);
        }
    }
}