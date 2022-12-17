package menu.domain;

import menu.dto.WeekMenusDto;

import java.util.List;
import java.util.stream.Collectors;

public class WeekMenus {
    Coach coach;
    List<Menu> menus;

    public WeekMenus(Coach coach, List<Menu> menus) {
        this.coach = coach;
        this.menus = menus;
    }

    public WeekMenusDto toDto() {
        return new WeekMenusDto(coach.getName(), menus.stream().map(Menu::toString).collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return "[" +
                "coach=" + coach +
                ", menus=" + menus +
                ']' + "\n";
    }
}
