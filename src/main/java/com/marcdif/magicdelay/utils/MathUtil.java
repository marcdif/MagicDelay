package com.marcdif.magicdelay.utils;

public class MathUtil {

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }
    }

    public static int getCoordinate(String s, int currentCoordinate) {
        if (s.startsWith("~")) {
            if (s.length() == 1) {
                return currentCoordinate;
            }
            if (isInt(s.substring(1))) {
                return Integer.parseInt(s.substring(1)) + currentCoordinate;
            } else {
                throw new IllegalArgumentException(s + " isn't a relative coordinate!");
            }
        }
        if (isInt(s)) {
            return Integer.parseInt(s);
        }
        throw new IllegalArgumentException(s + " isn't a coordinate!");
    }
}
