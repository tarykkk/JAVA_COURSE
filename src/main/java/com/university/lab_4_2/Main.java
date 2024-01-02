package com.university.lab_4_2;

public class Main {
    public static void main(String[] args) {
        String word = "level";
        String word2 = "ogo";

        if (isPalindrome(word)) {
            System.out.println(word + " є паліндромом.");
        } else {
            System.out.println(word + " не є паліндромом.");
        }
        
        if (isPalindrome(word2)) {
            System.out.println(word2 + " є паліндромом.");
        } else {
            System.out.println(word2 + " не є паліндромом.");
        }
    }

    public static boolean isPalindrome(String word) {
        if(word == null) {
            return false;
        }

        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }
}

