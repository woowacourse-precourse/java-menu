package menu.service;

public class CategoryService {
    private static class InstanceHolder {
        private static final CategoryService INSTANCE = new CategoryService();
    }

    private CategoryService(){}

    public static CategoryService getInstance() {
        return CategoryService.InstanceHolder.INSTANCE;
    }
}
