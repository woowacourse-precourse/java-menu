package menu.service;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.dto.MenuDto;
import menu.dto.MenusDto;
import menu.repository.MenuRepository;

public class MenuService {

    private static final int CATEGORY_SIZE = 5;
    private static final int RANDOM_INDEX = 0;

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public MenusDto recommendMenus(List<Coach> coaches) {
        List<Category> categories = Category.generateRandomCategories(CATEGORY_SIZE);
        for (Category category : categories) {
            recommendMenu(coaches, category);
        }
        return getRecommendMenus(coaches, categories);
    }

    private void recommendMenu(List<Coach> coaches, Category category) {
        List<String> menus = menuRepository.findMenuNames(category);
        for (Coach coach : coaches) {
            Menu menu = recommendValidMenu(coach, menus);
            coach.addRecommendMenu(menu);
        }
    }

    private Menu recommendValidMenu(Coach coach, List<String> menus) {
        Menu menu = new Menu(shuffle(menus).get(RANDOM_INDEX));
        while (coach.isInvalidMenu(menu)) {
            menu = new Menu(shuffle(menus).get(RANDOM_INDEX));
        }
        return menu;
    }

    private static MenusDto getRecommendMenus(List<Coach> coaches, List<Category> categories) {
        List<MenuDto> menuDtos = coaches.stream()
                .map(coach -> new MenuDto(coach.getName(), coach.getRecommendMenuNames()))
                .collect(Collectors.toList());
        return new MenusDto(categories, menuDtos);
    }
}
