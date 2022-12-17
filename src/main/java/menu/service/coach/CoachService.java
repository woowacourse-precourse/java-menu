package menu.service.coach;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.coach.entity.Coach;
import menu.domain.coach.repository.CoachRepository;
import menu.domain.menu.entity.Menu;
import menu.domain.menu.repository.MenuRepository;

public class CoachService {

    private static final String NAME_SEPARATOR = ",";
    private static final int MIN_COACHES_COUNT = 2;
    private static final int MAX_COACHES_COUNT = 5;

    private static final String COACHES_NAME_EXCEPTION_MESSAGE = "중복된 코치 이름이 존재합니다.";
    private static final String COACHES_COUNT_EXCEPTION_MESSAGE = "코치는 최소 %d명, 최대 %d명만 가능합니다.";
    private static final String NOT_FOUND_COACH = "해당 이름을 가진 코치를 찾을 수 없습니다.";
    private static final String NOT_FOUND_MENU = "해당 이름을 가진 메뉴를 찾을 수 없습니다.";

    private final CoachRepository coachRepository;
    private final MenuRepository menuRepository;

    public CoachService(CoachRepository coachRepository, MenuRepository menuRepository) {
        this.coachRepository = coachRepository;
        this.menuRepository = menuRepository;
    }

    public void addCoaches(String coachesName) {
        String[] names = coachesName.split(NAME_SEPARATOR);
        validateCoachesCount(names);

        List<Coach> coaches = Arrays.stream(names)
                .distinct().map(Coach::new).collect(Collectors.toList());

        validateDuplicateCoaches(names, coaches);
        coachRepository.saveAll(coaches);
    }

    private void validateCoachesCount(final String[] names) {
        int coachesCount = names.length;

        if (coachesCount < MIN_COACHES_COUNT || coachesCount > MAX_COACHES_COUNT) {
            throw new IllegalArgumentException(
                    String.format(COACHES_COUNT_EXCEPTION_MESSAGE, MIN_COACHES_COUNT, MAX_COACHES_COUNT));
        }
    }

    private void validateDuplicateCoaches(final String[] names, final List<Coach> coaches) {
        if (names.length != coaches.size()) {
            throw new IllegalArgumentException(COACHES_NAME_EXCEPTION_MESSAGE);
        }
    }

    public List<String> findCoachesNameAll() {
        return coachRepository.findAll().stream().map(Coach::getName).collect(Collectors.toUnmodifiableList());
    }

    public void addNotEatMenuByCoachName(String coachName, String notEatMenusName) {
        if (notEatMenusName.isBlank()) {
            return;
        }
        Coach coach = coachRepository.findByName(coachName)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_COACH));

        coach.addAllInedibleMenus(findAllByNotEatMenusName(notEatMenusName));
    }

    private List<Menu> findAllByNotEatMenusName(String notEatMenus) {
        String[] menuNames = notEatMenus.split(NAME_SEPARATOR);

        return Arrays.stream(menuNames)
                .map(menuName -> menuRepository.findByName(menuName)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MENU)))
                .collect(Collectors.toUnmodifiableList());
    }
}
