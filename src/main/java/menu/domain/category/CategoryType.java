package menu.domain.category;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CategoryType {
    JAPANESE(1,"일식"),
    KOREAN(2,"한식"),
    CHINESE(3, "중식"),
    ASIAN(4,"아시안"),
    WESTERN(5,"양식");

    private final int index;
    private final String korean;

    CategoryType(int index, String korean){
        this.index = index;
        this.korean = korean;
    }

    private static final Map<String, CategoryType> categoryTypeByKorean =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(CategoryType::getKorean, Function.identity())));

    public String getKorean() {
        return korean;
    }

    public int getIndex(){
        return index;
    }

    public static int getIndexByKorean(String korean){
        return categoryTypeByKorean.get(korean)
                .index;
    }
}
