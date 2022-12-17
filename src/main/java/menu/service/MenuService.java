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
        for (Coach coach : coaches) {
            Menu menu = findMenu(category, coach);
            coach.addRecommendMenu(menu);
        }
    }

    private Menu findMenu(Category category, Coach coach) {
        List<String> menuNames = menuRepository.findMenuNames(category);
        Menu menu = new Menu(shuffle(menuNames).get(0));
        while (coach.isInvalidMenu(menu)) {
            menu = new Menu(shuffle(menuNames).get(0));
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
