package com.university.lab_4_2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DecoderTest {

    @Test
    void testDecodeVowelSubstitution() {
        assertEquals("t2st3ng", DecoderTest.decodeVowelSubstitution("testing"));
    }


    private static Object decodeVowelSubstitution(String string) {
        return null;
    }


    @Test
    void testDecodeConsonantSubstitution() {
        assertEquals("uftujoh", DecoderTest.decodeConsonantSubstitution("testing"));
    }


    private static Object decodeConsonantSubstitution(String string) {
        return null;
    }


}
