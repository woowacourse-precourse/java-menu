package menu.domain.menu;

public class MenuRecommendService {
    private final MenuRepository menuRepository;

    public MenuRecommendService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
}
