package apache_commons;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Collection;
import java.util.List;

import static org.apache.commons.lang3.builder.ToStringStyle.*;
import static support.PrintSupport.print;
import static support.PrintSupport.printed;

public class ReflectionToStringBuilderDemo {

    public static final Collection<ToStringStyle> TO_STRING_STYLES = List.of(
        DEFAULT_STYLE,
        JSON_STYLE,
        MULTI_LINE_STYLE,
        SHORT_PREFIX_STYLE,
        NO_CLASS_NAME_STYLE,
        NO_FIELD_NAMES_STYLE,
        SIMPLE_STYLE
    );

    public static void main(String[] args) {
        print("objToString", ReflectionToStringBuilderDemo::objToString);
    }

    private static void objToString() {
        var movie = printed("movie", new Movie("Dune", 2021));
        TO_STRING_STYLES.forEach(style -> print(
            String.format("movie %s", style.getClass().getSimpleName()),
            ReflectionToStringBuilder.toString(movie, style)));
    }

    static class Movie {

        String title;
        int year;

        public Movie(String title, int year) {
            this.title = title;
            this.year = year;
        }

        @Override
        public String toString() {
            return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                '}';
        }
    }
}
