package org.example.day1;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Day1 day = new Day1();
        List<String> lines = day.parseFileToLines("example.txt");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }

    public List<String> parseFileToLines(String filename) {
        URL url = getClass().getResource(filename);

        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(url.toURI()), StandardCharsets.UTF_8);
        } catch (Exception ex) {
            System.out.println("Filed to read in the file");
            ex.printStackTrace();
        }
        return lines;
    }

    public static Long solveDay1Calories(String input) {
        Long mostCaloriesSoFar = -1L;

        String[] linesArray = input.split("\n");
        List<String> lines = Stream.of(linesArray).collect(Collectors.toList());
        lines.add("");

        Long caloriesForThisElf = 0L;
        for (String line : lines) {
            if (line.equals("")) {
                // System.out.println("Most Calories so far " + mostCaloriesSoFar);
                // System.out.println("Cal for this elf " + caloriesForThisElf);
                if (caloriesForThisElf > mostCaloriesSoFar) {
                    mostCaloriesSoFar = caloriesForThisElf;
                    // System.out.println("Most Calories so far " + mostCaloriesSoFar);
                }
                caloriesForThisElf = 0L;
            } else {
                Long caloriesForThisItem = Long.valueOf(line);
                caloriesForThisElf += caloriesForThisItem;
            }
        }




        return mostCaloriesSoFar;
    }

    public static Long solveDay2Calories(String input) {
        List<Long> caloriesPerElf = new ArrayList<>();

        String[] linesArray = input.split("\n");
        List<String> lines = Stream.of(linesArray).collect(Collectors.toList());
        lines.add("");

        Long caloriesForThisElf = 0L;
        for (String line : lines) {
            if (line.equals("")) {
                caloriesPerElf.add(caloriesForThisElf);
                caloriesForThisElf = 0L;
            } else {
                Long caloriesForThisItem = Long.valueOf(line);
                caloriesForThisElf += caloriesForThisItem;
            }
        }

        for (int i = 0; i < caloriesPerElf.size(); i++) {
            System.out.println(caloriesPerElf.get(i));
        }

        System.out.println("---");
        List<Long> newList = caloriesPerElf.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        Long topThreeElves = newList.get(0) + newList.get(1) + newList.get(2);
        return topThreeElves;
    }
}
