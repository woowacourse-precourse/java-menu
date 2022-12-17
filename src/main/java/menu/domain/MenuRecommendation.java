package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRecommendation {

    private static People people;

    public MenuRecommendation(String input) {
        String[] split = validate(input);
        List<Person> result = Arrays.stream(split)
                .map(Person::new)
                .collect(Collectors.toList());
        people = new People(result);
    }

    private String[] validate(String input) {
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) != ',' || Character.isAlphabetic(input.charAt(index))) {
                throw new IllegalArgumentException("올바른 입력이 아닙니다. 쉽표로 구분하여 입력해주세요");
            }
        }
        return input.split(",");
    }
    public static People getPeople() {
        return people;
    }

    public void addUnavailableMenus(List<String> inputs) {
        people.addUnavailableMeneus(inputs);
    }
}
