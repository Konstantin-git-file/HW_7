package org.example;

import lombok.Data;

import java.util.Arrays;
import java.util.function.Predicate;

@Data
public class Student {
    private String name;
    private int[] grades;
    private Predicate<Integer> gradeValidator;

    // без правила проверки (все оценки допустимы)
    public Student(String name, int... grades) {
        this(name, grade -> true, grades); // По умолчанию все оценки допустимы
    }

    // с правилом проверки оценок
    public Student(String name, Predicate<Integer> gradeValidator, int... grades) {
        this.name = name;
        this.gradeValidator = gradeValidator;
        setGrades(grades);
    }

    public void setGrades(int[] grades) {
        if (grades != null) {
            for (int grade : grades) {
                if (!gradeValidator.test(grade)) {
                    throw new IllegalArgumentException("Некорректная оценка: " + grade);
                }
            }
        }
        this.grades = grades != null ? Arrays.copyOf(grades, grades.length) : null;
    }

    public int[] getGrades() {
        return grades != null ? Arrays.copyOf(grades, grades.length) : null;
    }

    public void addGrade(int grade) {
        if (!gradeValidator.test(grade)) {
            throw new IllegalArgumentException("Некорректная оценка: " + grade);
        }
        if (grades == null) {
            grades = new int[]{grade};
        } else {
            grades = Arrays.copyOf(grades, grades.length + 1);
            grades[grades.length - 1] = grade;
        }
    }

    public double getAverageGrade() {
        if (grades == null || grades.length == 0) {
            return 0.0; // Если оценок нет, возвращаем 0
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public boolean isExcellentStudent() {
        if (grades == null || grades.length == 0) {
            return false; // Если оценок нет, студент не отличник
        }
        for (int grade : grades) {
            if (grade != 5) {
                return false;
            }
        }
        return true; // Все оценки равны 5
    }

    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }
}