package org.example;

public class MathUtils {
    public static double sum(Number... numbers) {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue(); // Приводим каждое число к double и суммируем
        }
        return sum;
    }
}
