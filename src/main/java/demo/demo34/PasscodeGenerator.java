package demo.demo34;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PasscodeGenerator {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Generate 10 passcodes
        int numPasscodes = 10;
        executor.submit(() -> {
            generateAndCheckPasscodes(numPasscodes);
        });

        executor.shutdown();
    }

    public static void generateAndCheckPasscodes(int numPasscodes) {
        Random random = new Random();
        String correctPasscode = "code123";

        for (int i = 0; i < numPasscodes; i++) {
            String passcode = generateRandomPasscode();
            secureFunction(passcode, correctPasscode);
        }
    }

    public static String generateRandomPasscode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length = 8;
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static void secureFunction(String passcode, String correctPasscode) {
        if (passcode.equals(correctPasscode)) {
            System.out.println("Welcome!");
        }else {
            System.out.println("Xato!");
        }
    }
}