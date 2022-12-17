package menu.domain;

import menu.util.MenuRandomGenerator;

import java.util.Iterator;
import java.util.List;

public class People implements Iterable<Person> {
    public static final int MIN = 2;
    public static final int MAX = 5;

    private final List<Person> people;

    public People(List<Person> people) {
        this.people = validate(people);
    }

    private List<Person> validate(List<Person> people) {
        if (people.size() < MIN || people.size() > MAX) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_COUNT);
        }
        return people;
    }

    public void addUnavailableMenus(List<String> menus) {
        int index = 0;
        for (Person person : people) {
            person.addUnavailableMenus(menus.get(index++));
        }
    }

    public void setShuffledCategories(List<String> shuffledCategory, MenuRandomGenerator menuRandomGenerator) {
        for (String category : shuffledCategory) {
            for (Person person : people) {
                person.recommendMenu(category, menuRandomGenerator);
            }
        }
    }

    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }

    private static final class ErrorMessage {
        private static final String INVALID_COACH_COUNT = String.format("코치는 최소 %d명, 최대 %d명까지 식사를 함께 합니다.", MIN, MAX);
    }
}
