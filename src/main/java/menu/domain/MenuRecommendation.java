package menu.domain;

import menu.domain.menu.Category;
import menu.util.StandardRandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRecommendation {

    private static People people;
    private List<String> shuffledCategory;

    public MenuRecommendation(String input) {
        String[] split = validate(input);
        List<Person> result = Arrays.stream(split)
                .map(Person::new)
                .collect(Collectors.toList());
        people = new People(result);
    }

    private String[] validate(String input) {
        String[] split = input.split(",");
        for (String s : split) {
            if (!s.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
                throw new IllegalArgumentException("올바른 입력이 아닙니다. 쉽표로 구분하여 입력해주세요");
            }
        }
        return split;
    }
    public static People getPeople() {
        return people;
    }

    public void addUnavailableMenus(List<String> inputs) {
        people.addUnavailableMeneus(inputs);
    }

    public People getRecommendations(StandardRandomGenerator generator) {
        List<String> menus = Arrays.stream(Category.values()).map(Category::getTitle)
                .collect(Collectors.toList());

        shuffledCategory = calculateShuffledCategory(generator, menus);
        people.setShuffledCategory(shuffledCategory, generator);

        return people;
    }

    public List<String> getShuffledCategory() {
        return shuffledCategory;
    }

    private List<String> calculateShuffledCategory(StandardRandomGenerator generator, List<String> menus) {
        List<String> shuffledCategory = Arrays.stream(Day.values())
                .map(m -> generator.generate(menus))
                .collect(Collectors.toList());

        List<String> result = new ArrayList<>();
        for (Day value : Day.values()) {
            String generated = generator.generate(menus);
            while (!result.isEmpty() && !validateCount(result, generated)) {
                generated = generator.generate(menus);
            }
            result.add(generated);
        }
        return shuffledCategory;
    }

    private boolean validateCount(List<String> result, String generated) {
        return result.stream().filter(m -> m.equals(generated)).count() <= 2;
    }
}
