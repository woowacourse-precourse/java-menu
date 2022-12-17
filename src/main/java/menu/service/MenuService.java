package menu.service;

import menu.domain.Coach;

import java.util.List;

public class MenuService {
    public MenuService(List<Coach> coaches) {
        this.coaches = coaches;
    }

    private final List<Coach> coaches;

}
