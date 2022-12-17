package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Couch;
import menu.domain.Day;
import menu.domain.Menu;
import menu.dto.CouchHateMenusRequest;
import menu.dto.CouchMenu;
import menu.dto.CouchNamesRequest;
import menu.dto.RecommendMenu;
import menu.dto.RecommendMenusResponse;
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

    public RecommendMenusResponse createRecommendMenus() {
        List<Couch> couches = couchRepository.findAll();
        List<RecommendMenu> recommendMenus = new ArrayList<>();
        for (Day day : Day.values()) {
            String category = pickRandomCategory();
            RecommendMenu recommendMenu = new RecommendMenu(category);
            for (Couch couch : couches) {
                String menu = pickRandomMenu(category);
                recommendMenu.addCouchMenu(new CouchMenu(couch.getName(), menu));
            }
            recommendMenus.add(recommendMenu);
        }
        return RecommendMenusResponse.of(recommendMenus);
    }

    private String pickRandomCategory() {
        List<String> categories = Arrays.stream(Category.values())
                .map(Category::getName)
                .collect(Collectors.toList());
        return categories.get(Randoms.pickNumberInRange(0, 4));
    }

    private String pickRandomMenu(String category) {
        List<String> menus = menuRepository.findByCategory(Category.of(category))
                .stream()
                .map(Menu::getName)
                .collect(Collectors.toList());
        return Randoms.shuffle(menus).get(0);
    }
}
