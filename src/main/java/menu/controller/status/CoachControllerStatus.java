package menu.controller.status;

public enum CoachControllerStatus {
    INPUT_COACHES_NAME,
    INPUT_COACHES_NOT_EAT_MENUS_NAME,
    EXIT;

    public boolean isRunnable() {
        return this != EXIT;
    }

    public boolean matches(CoachControllerStatus targetStatus) {
        return this == targetStatus;
    }
}
