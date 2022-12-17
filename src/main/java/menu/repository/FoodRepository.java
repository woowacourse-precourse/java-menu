package menu.repository;

public class FoodRepository {
    private static class InstanceHolder {
        private static final FoodRepository INSTANCE = new FoodRepository();
    }

    private FoodRepository(){}

    public static FoodRepository getInstance() {
        return FoodRepository.InstanceHolder.INSTANCE;
    }
}
