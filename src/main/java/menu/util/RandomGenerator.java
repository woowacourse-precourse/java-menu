package menu.util;


import java.util.List;

@FunctionalInterface
public interface RandomGenerator {

    String generate(List<String> list);
}
