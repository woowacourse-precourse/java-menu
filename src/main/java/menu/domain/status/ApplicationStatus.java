package menu.domain.status;

public enum ApplicationStatus {
    INITIALIZE_MENUS,
    RECEIVE_COACH_DATA,
    GIVE_RECOMMENDATION,
    APPLICATION_EXIT;

    public boolean playable() {
        return this != APPLICATION_EXIT;
    }
}