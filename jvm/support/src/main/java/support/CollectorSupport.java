package support;

import java.util.Map;
import java.util.stream.Collector;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class CollectorSupport {

    public static <T> Collector<T, ?, Map<T, Integer>> countingByGroup() {
        return groupingBy(i -> i, countingInt());
    }

    public static <T> Collector<T, ?, Integer> countingInt() {
        return summingInt(i -> 1);
    }
}
