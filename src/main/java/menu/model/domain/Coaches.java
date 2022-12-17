package menu.model.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Coaches {
    public static final int COACHES_SIZE_MIN = 2;
    public static final int COACHES_SIZE_MAX = 5;

    private final List<Coach> coaches;

    public Coaches(List<String> names) {
        this.coaches = makeCoaches(names);
    }

    public List<Coach> coaches() {
        return coaches;
    }

    public List<String> getNames() {
        return coaches.stream()
                .map(coach -> coach.getName())
                .collect(Collectors.toList());
    }

    private List<Coach> makeCoaches(List<String> names) {
        validateNames(names);
        return IntStream.range(0, names.size())
                .mapToObj(index -> new Coach(names.get(index)))
                .collect(Collectors.toList());
    }

    public void updateDisLikeMenus(List<DislikeMenus> dislikeMenusByCoach) {
        System.out.println(dislikeMenusByCoach);
        IntStream.range(0, coaches.size())
                .forEach(index -> coaches.get(index).updateDislikeMenus(dislikeMenusByCoach.get(index)));
    }

    private void validateNames(List<String> names) {
        validateNameSize(names);
        validateDuplicatedName(names);
    }

    private void validateNameSize(List<String> names) {
        if (names.size() < COACHES_SIZE_MIN || names.size() > COACHES_SIZE_MAX) {
            throw new IllegalArgumentException("식사할 코치의 인원 수는 최소 2, 최대 5여야 합니다.");
        }
    }

    private void validateDuplicatedName(List<String> names) {
        int removeDuplicated = (int) names.stream()
                .distinct()
                .count();
        if (removeDuplicated != names.size()) {
            throw new IllegalArgumentException("중복된 코치 이름을 입력할 수 없습니다.");
        }
    }
}
