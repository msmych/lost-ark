package support;

import java.util.Map;
import java.util.function.Supplier;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.IntStream.range;

public final class SampleSupport {

    public static <T> Map<T, Integer> sample(Supplier<T> supplier, int times) {
        return range(0, times)
            .mapToObj(i -> supplier.get())
            .collect(groupingBy(i -> i, summingInt(i -> 1)));
    }
}
