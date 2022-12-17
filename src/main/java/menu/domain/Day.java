package menu.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum Day {
    MON("월요일", 1),
    TUESDAY("화요일", 2),
    WED("수요일", 3),
    THURSDAY("목요일", 4),
    FRI("금요일", 5);

    private final String name;
    private final int seq;
    private Category category = null;

    Day(String name, int seq) {
        this.name = name;
        this.seq = seq;
    }

    public static List<Day> inOrder() {
        return Arrays.stream(values())
                .sorted(Comparator.comparingInt(day -> day.seq))
                .collect(Collectors.toUnmodifiableList());
    }

    public static boolean isAvailableCategory(Category target) {
        return inOrder().stream()
                .filter(day -> Objects.equals(day.getCategory(), target))
                .count() < 2;
    }

    public static List<List<String>> getCategories() {
        return List.of(getDays(), getCategoryByDay());
    }

    private static List<String> getDays() {
        List<String> days = inOrder().stream()
                .map(day -> day.getName())
                .collect(Collectors.toList());
        days.add(0, "구분");
        return days;
    }

    private static List<String> getCategoryByDay() {
        List<String> categories = inOrder().stream()
                .map(day -> day.getCategory())
                .map(Category::getName)
                .collect(Collectors.toList());
        categories.add(0, "카테고리");
        return categories;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }
}
