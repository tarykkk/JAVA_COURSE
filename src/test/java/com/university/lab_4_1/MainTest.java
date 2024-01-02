package com.university.lab_4_1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MainTest {
    @Test

void isPalindrome() {
    assertFalse(Main.isPalindrome(null));
    assertTrue(Main.isPalindrome("radar"));
    assertFalse(Main.isPalindrome("banana"));
    assertTrue(Main.isPalindrome("hannah"));
    assertTrue(Main.isPalindrome("pup"));
    assertTrue(Main.isPalindrome("nan"));
    assertFalse(Main.isPalindrome("lollipop"));
    assertTrue(Main.isPalindrome("eye"));
    assertTrue(Main.isPalindrome("6543456"));
    assertTrue(Main.isPalindrome("step on no pets"));
    assertFalse(Main.isPalindrome("A man a plan a canal Panama"));
}
}
