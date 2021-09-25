package apache_commons;

import org.apache.commons.lang3.ArrayUtils;

import static support.PrintSupport.print;
import static support.PrintSupport.printed;

public class ArrayUtilsDemo {

    public static void main(String[] args) {
        print("uniteArrayWithSingleElement", ArrayUtilsDemo::uniteArrayWithSingleElement);
    }

    private static void uniteArrayWithSingleElement() {
        var arr = printed("array", new int[]{1, 2, 3});
        var el = printed("element", 4);
        print("union", ArrayUtils.add(arr, el));
    }
}
