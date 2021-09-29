package support;

import java.util.Map;
import java.util.function.Supplier;

import static java.util.stream.IntStream.range;
import static support.CollectorSupport.countingByGroup;

public final class SampleSupport {

    public static <T> Map<T, Integer> sample(int times, Supplier<T> supplier) {
        return range(0, times)
            .mapToObj(i -> supplier.get())
            .collect(countingByGroup());
    }
}
