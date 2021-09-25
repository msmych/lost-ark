package support;

import java.util.Arrays;

public final class PrintSupport {

    public static <T> T printed(String name, T value) {
        print(name, value);
        return value;
    }

    public static <T> T[] printed(String name, T[] value) {
        print(name, Arrays.toString(value));
        return value;
    }

    public static int[] printed(String name, int[] value) {
        print(name, Arrays.toString(value));
        return value;
    }

    public static void print(String name, int[] value) {
        print(name, Arrays.toString(value));
    }

    public static <T> void print(String name, Runnable process) {
        print("Start execution", name);
        process.run();
        print("End execution", name);
        System.out.println();
    }

    public static <T> void print(String name, T value) {
        System.out.printf("%s: %s%n", name, value);
    }
}
