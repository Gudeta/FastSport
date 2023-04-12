package com.fastModelSport.fastModelSport.service;

import com.fastModelSport.fastModelSport.model.Player;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Util {
    public static int calculateFastStat(Player player) {
        int fastStat = 0;

        // ((Total Points + Rebounds + Assist) - Turnovers)
        fastStat += player.getPts()+ player.getReb() + player.getAst() - player.getTo();

        // If they are over 6 feet they get an additional point for every inch they are over 6 feet.
        int heightInInches = convertHeightToInches(player.getHeight());
        if (heightInInches > 72) {
            fastStat += heightInInches - 72;
        }

        // If their first and last name begins with the same letter they also get an additional 10 points.
        String[] nameParts = player.getName().split(" ");
        if (nameParts[0].charAt(0) == nameParts[1].charAt(0)) {
            fastStat += 10;
        }

        // Last but not least they get the value of their jersey number and their age added to their "FastStat" total as well.
        int age = calculateAge(String.valueOf(player.getBirthdate()));
        fastStat += Integer.parseInt(String.valueOf(player.getNumber())) + age;

        return fastStat;
    }

    private static int convertHeightToInches(String height) {
        String[] heightParts = height.split("'");
        int feet = Integer.parseInt(heightParts[0]);
        int inches = Integer.parseInt(heightParts[1].replace("\"", ""));
        return feet * 12 + inches;
    }

    private static int calculateAge(String birthdate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(birthdate, formatter);
        LocalDate now = LocalDate.now();
        return Period.between(dob, now).getYears();
    }
}
