package menu.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Randoms.shuffle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.dto.MenuDto;
import menu.dto.MenusDto;
import menu.repository.MenuRepository;

public class MenuService {

    private static final int CATEGORY_INDEX_LOWER_BOUND = 1;
    private static final int CATEGORY_INDEX_UPPER_BOUND = 5;
    private static final int INVALID_CATEGORY_SIZE = 2;

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public MenusDto recommendMenus(List<Coach> coaches) {
        List<Category> categories = generateCategory();
        for (Category category : categories) {
            for (Coach coach : coaches) {
                putMenu(category, coach);
            }
        }
        List<MenuDto> menuDtos = coaches.stream()
                .map(coach -> new MenuDto(coach.getName(), coach.getEatMenu()))
                .collect(Collectors.toList());
        return new MenusDto(categories, menuDtos);
    }

    private List<Category> generateCategory() {
        List<Category> categories = new ArrayList<>();
        for (int i = CATEGORY_INDEX_LOWER_BOUND; i <= CATEGORY_INDEX_UPPER_BOUND; i++) {
            Category category = getValidCategory(categories);
            categories.add(category);
        }
        return categories;
    }

    private Category getValidCategory(List<Category> categories) {
        Category category = Category.of(pickNumberInRange(CATEGORY_INDEX_LOWER_BOUND, CATEGORY_INDEX_UPPER_BOUND));
        if (getCount(categories, category) >= INVALID_CATEGORY_SIZE) {
            return getValidCategory(categories);
        }
        return category;
    }

    private static long getCount(List<Category> categories, Category input) {
        return categories.stream()
                .filter(category -> category.equals(input))
                .count();
    }

    private void putMenu(Category category, Coach coach) {
        List<String> menuNames = menuRepository.findMenuNames(category);
        String name = shuffle(menuNames).get(0);
        Menu menu = new Menu(name);
        while (coach.isInvalidMenu(menu)) {
            name = shuffle(menuNames).get(0);
            menu = new Menu(name);
        }
        coach.addEatMenu(menu);
    }
}
