package com.rutkowski.agent_ai.Tools;

import java.nio.charset.StandardCharsets;

public class StringTrimmer {

    public static String trimToMaxBytes(String input, int maxBytes) {
        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);

        if (bytes.length <= maxBytes) {
            return input;
        }

        // Szukamy najdłuższego poprawnego UTF-8 przed maxBytes
        int endIndex = maxBytes;
        while (endIndex > 0 && (bytes[endIndex] & 0b11000000) == 0b10000000) {
            endIndex--; // pomijamy bajty, które są częścią wielobajtowych znaków
        }

        return new String(bytes, 0, endIndex, StandardCharsets.UTF_8);
    }

}
