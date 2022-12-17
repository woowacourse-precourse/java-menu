package menu.repository;

public class CategoryRepository {
    private static class InstanceHolder {
        private static final CategoryRepository INSTANCE = new CategoryRepository();
    }

    private CategoryRepository(){}

    public static CategoryRepository getInstance() {
        return CategoryRepository.InstanceHolder.INSTANCE;
    }
}
