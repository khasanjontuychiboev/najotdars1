package demo.demo34;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void secureFucntion(String s){
        if ("parol123".equals(s)){
            System.out.println("xush kelibsiz!");
        }
        else {
            System.out.println("Ruxsat yo'q!");
        }
    }
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);


        executor.shutdown();
    }
}