package menu.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CouchNamesRequest {
    private List<String> couchNames;

    private CouchNamesRequest(List<String> couchNames) {
        this.couchNames = couchNames;
    }

    public static CouchNamesRequest of(String input) {
        String[] names = input.split(",");
        validate(names);
        return new CouchNamesRequest(Arrays.asList(names));
    }

    private static void validate(String[] names) {
        if (names.length < 2 || names.length > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 2명에서 5명 이하여야 합니다.");
        }
        for (String name : names) {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException("[ERROR] 코치의 이름은 2글자에서 4글자 사이어야 합니다.");
            }
        }
        long notDuplicateCount = Arrays.stream(names)
                .distinct()
                .count();
        if (notDuplicateCount != names.length) {
            throw new IllegalArgumentException("[ERROR] 중복된 코치의 이름이 있으면 안됩니다.");
        }
    }

    public List<String> getCouchNames() {
        return couchNames;
    }
}
