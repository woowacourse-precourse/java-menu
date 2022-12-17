package menu.domain.utils;

import java.util.List;

public interface Picker {

    int pickNumberInRange(int start, int end);

    List<String> shuffle(List<String> strings);
}