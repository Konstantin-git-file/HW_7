package org.example;

import lombok.*;

/*
   1.1.1.
   Создайте сущность Точка, расположенную на двумерной плоскости, которая описывается:
   • Координата Х: целое число
   • Координата Y: целое число
   • Может возвращать текстовое представление вида “{X;Y}”
Необходимо создать три точки с разными координатами и вывести на экран их текстовое представление.
    */
@Data
@AllArgsConstructor
//@NoArgsConstructor - удален, чтобы нельзя было создать точку без указания координат (условие из задачи 1.4.1.)
public class Point {
    private int x;
    private int y;

    public String getTextRepresentation() {
        return "{" + x + ";" + y + "}";
    }

    public double distanceTo(Point other) {
        if (other == null) {
            throw new IllegalArgumentException("Другая точка не может быть null.");
        }
        int dx = this.x - other.x;
        int dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public String getDescription() {
        return "Точка в координате {" + x + ";" + y + "}";
    }
}
