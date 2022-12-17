package menu.domain;

import menu.util.CategoryRandomGenerator;
import menu.util.MenuRandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class MenuRecommendation {

    public static final String DELIMITER = ",";
    public static final String REGEX = ".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*";
    public static final int COUNT_LIMIT = 2;

    private static People people;
    private List<String> shuffledCategories;

    public MenuRecommendation(String names) {
        String[] split = validate(names);
        List<Person> result = Arrays.stream(split)
                .map(Person::new)
                .collect(Collectors.toList());
        people = new People(result);
    }

    private String[] validate(String names) {
        String[] split = names.split(DELIMITER);
        for (String name : split) {
            if (!name.matches(REGEX)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_FORMAT);
            }
        }
        return split;
    }

    public void addUnavailableMenus(List<String> inputs) {
        people.addUnavailableMenus(inputs);
    }

    public static People getPeople() {
        return people;
    }

    public People getRecommendations(CategoryRandomGenerator categoryRandomGenerator, MenuRandomGenerator menuRandomGenerator) {
        shuffledCategories = calculateShuffledCategories(categoryRandomGenerator);
        people.setShuffledCategories(shuffledCategories, menuRandomGenerator);

        return people;
    }

    private List<String> calculateShuffledCategories(CategoryRandomGenerator generator) {
        List<String> result = new ArrayList<>();
        for (int index = 0; index < Day.values().length; index++) {
            String generated = generator.generate();
            while (!result.isEmpty() && !validateCount(result, generated)) {
                generated = generator.generate();
            }
            result.add(generated);
        }
        return result;
    }

    public List<String> getShuffledCategories() {
        return shuffledCategories;
    }

    private boolean validateCount(List<String> result, String generated) {
        return result.stream()
                .filter(m -> m.equals(generated))
                .count() <= COUNT_LIMIT;
    }

    private static final class ErrorMessage {
        private static final String INVALID_INPUT_FORMAT = "올바른 입력이 아닙니다. 쉽표로 구분하여 입력해주세요";
    }
}
