package io.bloomish.api.util;

import java.util.Objects;

public final class StringUtils {
    private StringUtils() {
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isNotBlank(String string) {
        return !isBlank(string);
    }

    public static boolean isBlank(String string) {
        return string == null || string.isBlank();
    }

    public static boolean isUpperCase(String string) {
        return string.toUpperCase().equals(string);
    }

    public static boolean isLowerCase(String string) {
        return string.toLowerCase().equals(string);
    }

    public static boolean isEqualIgnoreCase(String left, String right) {
        return Objects.equals(left, right) || (left != null && left.equalsIgnoreCase(right));
    }
}
