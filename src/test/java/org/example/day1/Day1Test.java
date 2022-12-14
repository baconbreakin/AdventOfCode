package org.example.day1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {

    @Test
    @DisplayName("Solving the example Prompt - Day 1 Part 1 - some change")
    void part1_examplePrompt() {
        List<String> lines = Day1.parseFileToLines("day1/example.txt");
        Long result = Day1.solvePart1Calories(lines);
        assertEquals(24_000L, result);
    }

    @Test
    void part1_secondTestForAccuracy() {
        List<String> lines = new ArrayList<>();
        lines.add("1000");lines.add("2000");lines.add("3000");lines.add("");
        lines.add("4000");lines.add("");
        lines.add("5000");lines.add("6000");lines.add("");
        lines.add("10000");

        Long result = Day1.solvePart1Calories(lines);
        assertEquals(11_000L, result);
    }

    /**
     * This test ensures we are accounting for the last elf
     */
    @Test
    void part1_edgeCase() {
        List<String> lines = new ArrayList<>();
        lines.add("1000");
        lines.add("2000");
        lines.add("3000");
        lines.add("");
        lines.add("990000");

        Long result = Day1.solvePart1Calories(lines);
        assertEquals(990_000L, result);
    }

    @Test
    @DisplayName("Solving the example Prompt - Day 1 Part 2")
    void part2_examplePrompt() {
        List<String> lines = Day1.parseFileToLines("day1/example.txt");
        Long result = Day1.solvePart2Calories(lines);
        assertEquals(45_000L, result);
    }
}
