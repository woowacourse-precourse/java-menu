package menu.domain.utils;

import java.util.List;

public interface pick {

    int pickNumberInRange(int start, int end);

    List<String> shuffle(List<String> strings);
}