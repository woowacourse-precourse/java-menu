package menu.service;

import menu.domain.Coach;

import java.util.List;

public interface RecommendMenuService {

    void recommend(List<Coach> coaches, List<String> categories);
}
