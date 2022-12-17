package menu.service;

import menu.domain.Category;

public class RecommendService {

    //     - [] x요일에 추천할 카테고리를 무작위로 정한다.
    //      - [] 만약, 해당 카테고리가 해당 주에 3번 이상 추천된다면 다시 추천할 카테고리를 선정한다.
    //    - 각 코치가 x요일에 먹을 메뉴를 추천한다.
    //      - [] 해당 카테고리에 있는 메뉴를 임의의 순서로 섞어서, 첫 번째 값을 리턴한다.
    //        - [] 해당 메뉴가 해당 코치가 못 먹는 메뉴라면 다시 값을 섞어서 반환환다.
    //        - [] 해당 메뉴가 해당 주에 이미 추천이 됐다면 다시 값을 섞어서 반환환다.

    private final MenuService menuService = new MenuService();
    private final CategoryService categoryService = new CategoryService();


    public void recommend() {
        Category findCategory = categoryService.getRecommendCategory();
        while(!categoryService.isSaveCategoryInfo(findCategory)) {
            findCategory = categoryService.getRecommendCategory();
        }

    }

}
