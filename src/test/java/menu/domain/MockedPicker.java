package menu.domain;

import java.util.List;

public class MockedPicker implements Picker {

    private int count = 1;

    @Override
    public int pickNumberInRange(int startInclusive, int endInclusive) {
        return count++;
    }

    @Override
    public List<String> shuffle(List<String> strings) {
        return List.of(strings.get(0));
    }
}
