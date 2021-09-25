package java17;

import java17.SealedClassesDemo.GinBasedCocktail.Gimlet;
import java17.SealedClassesDemo.GinBasedCocktail.Negroni;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static support.PrintSupport.print;

public class SealedClassesDemo {

    public static void main(String[] args) {
        var aperolSpritz = new AperolSpritz();
        var negroni = new Negroni();
        var gimlet = new Gimlet();
        RumBasedCocktail mojito = () -> Map.of("Rum", 60, "Simple syrup", 20, "Lime juice", 20);

        print("Total ingredients", Stream.of(aperolSpritz, negroni, gimlet, mojito)
            .peek(c -> print(c.getClass().getSimpleName(), c.ingredients()))
            .map(Cocktail::ingredients)
            .map(Map::entrySet)
            .flatMap(Set::stream)
            .collect(groupingBy(Map.Entry::getKey, summingInt(Map.Entry::getValue))));
    }

    sealed interface Cocktail permits AperolSpritz, GinBasedCocktail, RumBasedCocktail {

        Map<String, Integer> ingredients();
    }

    static final class AperolSpritz implements Cocktail {

        @Override
        public Map<String, Integer> ingredients() {
            return Map.of("Prosecco", 45, "Aperol", 30, "Tonic", 45);
        }
    }

    static sealed abstract class GinBasedCocktail implements Cocktail permits Negroni, Gimlet {

        static final class Negroni extends GinBasedCocktail {

            @Override
            public Map<String, Integer> ingredients() {
                return Map.of("Gin", 30, "Sweet vermouth", 30, "Campari", 30);
            }
        }

        static final class Gimlet extends GinBasedCocktail {

            @Override
            public Map<String, Integer> ingredients() {
                return Map.of("Gin", 60, "Simple syrup", 20, "Lime juice", 20);
            }
        }
    }

    non-sealed interface RumBasedCocktail extends Cocktail {

    }
}
