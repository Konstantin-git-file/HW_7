package org.example;

public class BirdMarket {
    public static void makeBirdsSing(Bird... birds) {
        for (Bird bird : birds) {
            bird.sing();
        }
    }
}
