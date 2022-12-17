package menu.repository;

public class CoachRepository {
    private static class InstanceHolder {
        private static final CoachRepository INSTANCE = new CoachRepository();
    }

    private CoachRepository(){}

    public static CoachRepository getInstance() {
        return CoachRepository.InstanceHolder.INSTANCE;
    }
}
