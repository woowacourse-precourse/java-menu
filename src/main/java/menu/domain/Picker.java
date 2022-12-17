package menu.domain;

import java.util.List;

public interface Picker {

    int pickNumberInRange(int startInclusive, int endInclusive);

    List<String> shuffle(List<String> strings);
}
