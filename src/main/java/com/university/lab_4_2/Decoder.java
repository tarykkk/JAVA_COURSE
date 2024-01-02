package com.university.lab_4_2;


public class Decoder {

    public static String decodeVowelSubstitution(String word) {
        return word.replaceAll("a", "1")
                   .replaceAll("e", "2")
                   .replaceAll("i", "3")
                   .replaceAll("o", "4")
                   .replaceAll("u", "5");
    }

    public static String decodeConsonantSubstitution(String word) {
        StringBuilder decodedWord = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (Character.isLetter(currentChar)) {
                char decodedChar = (char) (currentChar + 1);
                if (isVowel(decodedChar)) {
                    decodedChar += 1; // Skip vowels
                }
                decodedWord.append(decodedChar);
            } else {
                decodedWord.append(currentChar);
            }
        }

        return decodedWord.toString();
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
