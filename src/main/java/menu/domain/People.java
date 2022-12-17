package menu.domain;

import menu.util.StandardRandomGenerator;

import java.util.Iterator;
import java.util.List;

public class People implements Iterable<Person> {
    private final List<Person> people;

    public People(List<Person> people) {
        this.people = validatePeopleSize(people);
    }

    private List<Person> validatePeopleSize(List<Person> people) {
        if (people.size() < 2 || people.size() > 5) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명까지 식사를 함께 합니다.");
        }
        return people;
    }

    public void addUnavailableMeneus(List<String> inputs) {
        for (int index = 0; index < inputs.size(); index++) {
            people.get(index).addUnavailableMenus(inputs.get(index));
        }
    }

    public void setShuffledCategory(List<String> shuffledCategory, StandardRandomGenerator generator) {
        for (int index = 0; index < shuffledCategory.size(); index++) {
            people.get(index).recommendMenu(shuffledCategory.get(index), generator);
        }
    }

    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }
}
