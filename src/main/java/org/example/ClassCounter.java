package org.example;

import java.util.Scanner;

public class ClassCounter {
    public int numberOfLike;
    public int numberOfDislike;

    public void increaseLike(int x){
        numberOfLike+=x;
        System.out.println("Likelar qiymati oshirilid: " + numberOfLike);

    }

    public  void increaseDislike(){
        numberOfDislike++;
        System.out.println("dislike qiymati kamaytrildi: " + numberOfDislike);

    }
}
