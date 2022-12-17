package menu.view;

import menu.domain.RecommendMenuRepository;

public interface Output {
    void printStart();

    void printEnd();

    void printMenu(RecommendMenuRepository recommendMenuRepository);
}
