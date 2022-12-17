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

    public void createRecommendCouchMenu(List<String> recommendsCategory) {
        List<Couch> couches = couchRepository.findAll();
        for (String category : recommendsCategory) {
            for (Couch couch : couches) {
                String recommendMenu = getRecommendMenu(couch, category);
                couch.addRecommendMenu(recommendMenu);
            }
        }
    }

    private String getRecommendMenu(Couch couch, String category) {
        while (true) {
            String menu = pickRandomMenu(category);
            if (couch.alreadyRecommend(menu)) {
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
            String category = categories.get(Randoms.pickNumberInRange(1, 5) - 1);
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
