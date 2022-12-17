package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.utils.Constants;

public class ResultList {
    public static final String MAP_PREFIX = "[ ";
    public static final String MAP_DELIMITER = " | ";
    public static final String MAP_SUFFIX = " ]";

    private final List<String> results;

    public ResultList(List<String> results) {
        this.results = results;
    }

    public void append(String result) {
        this.results.add(result);
    }

    @Override
    public String toString() {
        return results.stream()
            .collect(Collectors
                .joining(MAP_DELIMITER, MAP_PREFIX, MAP_SUFFIX));
    }

}
