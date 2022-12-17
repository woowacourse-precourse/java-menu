package menu.service;

import java.util.List;
import menu.service.dto.CoachNameDto;
import menu.service.dto.MenuDto;
import menu.service.dto.RecommendResultDto;

public interface Menu {

    void validateCoachNames(CoachNameDto coachNameDto);

    void validateMenus(MenuDto menuDto);

    RecommendResultDto recommend(List<String> names, List<List<String>> menus);
}