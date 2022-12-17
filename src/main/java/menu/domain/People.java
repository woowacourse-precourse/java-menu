package menu.domain;

import java.util.Iterator;
import java.util.List;

public class People implements Iterable<Person> {
    private final List<Person> people;

    public People(List<Person> people) {
        this.people = people;
    }

    public int getCount() {
        return people.size();
    }

    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }

    public void addUnavailableMeneus(List<String> inputs) {
        for (int index = 0; index < inputs.size(); index++) {
            people.get(index).adUnavailableMenus(inputs.get(index));
        }
    }
}
