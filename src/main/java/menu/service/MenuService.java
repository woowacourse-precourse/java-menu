package menu.service;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Couch;
import menu.domain.Menu;
import menu.dto.CouchHateMenusRequest;
import menu.dto.CouchNamesRequest;
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
        return null;
    }
}
