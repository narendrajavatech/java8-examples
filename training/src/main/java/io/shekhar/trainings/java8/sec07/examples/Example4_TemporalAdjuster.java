package io.shekhar.trainings.java8.sec07.examples;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by shekhargulati on 19/09/15.
 */
public class Example4_TemporalAdjuster {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today.with(TemporalAdjusters.firstDayOfNextMonth()));

        TemporalAdjuster nextWorkingDayAdjuster = TemporalAdjusters.ofDateAdjuster(localDate -> {
            DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.FRIDAY) {
                return localDate.plusDays(3);
            } else if (dayOfWeek == DayOfWeek.SATURDAY) {
                return localDate.plusDays(2);
            }
            return localDate.plusDays(1);
        });

        LocalDate nextWorkingDay = today.with(nextWorkingDayAdjuster);

        System.out.println(nextWorkingDay);
    }
}
