package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Couch;
import menu.domain.Menu;
import menu.dto.CouchHateMenusRequest;
import menu.dto.CouchNamesRequest;
import menu.dto.RecommendCouchMenu;
import menu.repository.CouchRepository;
import menu.repository.MenuRepository;

public class MenuService {
    private final MenuRepository menuRepository;
    private final CouchRepository couchRepository;

    public MenuService(MenuRepository menuRepository, CouchRepository couchRepository) {
        this.menuRepository = menuRepository;
        this.couchRepository = couchRepository;
    }

    public void saveCouches(CouchNamesRequest request) {
        List<Couch> couches = request.getCouchNames().stream()
                .map(Couch::new)
                .collect(Collectors.toList());
        couchRepository.saveAll(couches);
    }

    public List<Couch> getAllCouches() {
        return couchRepository.findAll();
    }

    public void addHateMenusForCouch(Couch couch, CouchHateMenusRequest request) {
        List<String> hateMenuNames = request.getHateMenus();
        for (String hateMenuName : hateMenuNames) {
            Menu hateMenu = menuRepository.findByName(hateMenuName);
            couch.addHateMenu(hateMenu);
        }
    }

    public RecommendCouchMenu createRecommendCouchMenu(List<String> recommendsCategory, Couch couch) {
        List<String> recommendMenus = new ArrayList<>();
        for (String category : recommendsCategory) {
            String recommendMenu = getRecommendMenu(couch, category, recommendMenus);
            recommendMenus.add(recommendMenu);
        }
        return new RecommendCouchMenu(couch.getName(), recommendMenus);
    }

    private String getRecommendMenu(Couch couch, String category, List<String> recommendMenus) {
        while (true) {
            String menu = pickRandomMenu(category);
            if (recommendMenus.contains(menu)) {
                continue;
            }
            if (!couch.isHateMenu(menu)) {
                return menu;
            }
        }
    }

    public List<String> createRecommendCategories() {
        List<String> categories = Arrays.stream(Category.values())
                .map(Category::getName)
                .collect(Collectors.toList());
        List<String> recommendsCategory = new ArrayList<>();
        while (recommendsCategory.size() != 5) {
            String category = categories.get(Randoms.pickNumberInRange(1, 5));
            addCategory(recommendsCategory, category);
        }
        return recommendsCategory;
    }

    private void addCategory(List<String> recommendsCategory, String newCategory) {
        long duplicateCount = recommendsCategory.stream()
                .filter(category -> category.equals(newCategory))
                .count();
        if (duplicateCount >= 2) {
            return;
        }
        recommendsCategory.add(newCategory);
    }


    private String pickRandomMenu(String category) {
        List<String> menus = menuRepository.findByCategory(Category.of(category))
                .stream()
                .map(Menu::getName)
                .collect(Collectors.toList());
        return Randoms.shuffle(menus).get(0);
    }
}
