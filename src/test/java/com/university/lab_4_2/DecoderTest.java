package com.university.lab_4_2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DecoderTest {

    @Test
    void testDecodeVowelSubstitution() {
        assertEquals("t2st3ng", Decoder.decodeVowelSubstitution("testing"));
    }


    

    @Test
    void testDecodeConsonantSubstitution() {
        assertEquals("vftvjph", Decoder.decodeConsonantSubstitution("testing"));
    }




}
