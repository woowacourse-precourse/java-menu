package menu.domain.menu.service;

import java.util.List;
import menu.domain.menu.dto.MenuRecommendResponse;
import menu.domain.menu.model.Coach;

public interface MenuRecommendService {

    List<MenuRecommendResponse> menuRecommend(List<Coach> coaches);
}
