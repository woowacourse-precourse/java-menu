package menu.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class CategorySelector {


    public List<Category> selectCategories() {
        List<Category> categories = getRandom();
        while (validateRandomCategory(categories)) {
            categories = getRandom();
        }
        return categories;
    }


    private List<Category> getRandom() {
        return Stream.generate(() -> pickNumberInRange(1, 5))
                .map(value -> Category.from(value))
                .limit(Category.values().length)
                .collect(toUnmodifiableList());
    }

    private boolean validateRandomCategory(List<Category> categories) {
        return categories.stream()
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream()
                .anyMatch(entry -> entry.getValue() > 2);
    }


}
