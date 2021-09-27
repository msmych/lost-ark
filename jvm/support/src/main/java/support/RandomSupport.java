package support;

import java.util.concurrent.ThreadLocalRandom;

public final class RandomSupport {

    private static final ThreadLocalRandom RND = ThreadLocalRandom.current();

    public static <T extends Enum<T>> T next(Class<T> enumClass) {
        var values = enumClass.getEnumConstants();
        return values[RND.nextInt(values.length)];
    }
}
