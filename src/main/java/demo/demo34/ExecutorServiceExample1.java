package demo.demo34;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Task 1: Calculate the sum of integers from 1 to a given number
        executor.submit(() -> {
            int number = 100;
            int sum = 0;
            for (int i = 1; i <= number; i++) {
                sum += i;
            }
            System.out.print(Thread.currentThread().getName());
            System.out.print(" Sum of integers from 1 to " + number + ": " + sum+" \n");
        });

        // Task 2: Find the factorial of a given number
        executor.submit(() -> {
            int number = 5;
            int factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            System.out.println("Factorial of " + number + ": " + factorial);
        });

        // Task 3: Sort an array of integers in ascending order
        executor.submit(() -> {
            int[] array = { 5, 2, 8, 1, 9, 3 };
            Arrays.sort(array);
            System.out.println("Sorted array: " + Arrays.toString(array));
        });

        // Task 4: Convert a string to uppercase
        executor.submit(() -> {
            String text = "hello world";
            String uppercase = text.toUpperCase();
            System.out.println("Uppercase string: " + uppercase);
        });

        // Task 5: Generate a random number between a given range
        executor.submit(() -> {
            int min = 1;
            int max = 10;
            Random random = new Random();
            int randomNumber = random.nextInt(max - min + 1) + min;
            System.out.println("Random number between " + min + " and " + max + ": " + randomNumber);
        });

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}