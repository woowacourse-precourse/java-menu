package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.CategoryMaker;
import menu.domain.Coach;
import menu.repository.CoachRepository;
import menu.repository.MenuRecommendRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecommendService {
    static final CoachRepository coachRepository = CoachRepository.getInstance();
    static final MenuRecommendRepository menuRecommendRepository = MenuRecommendRepository.getInstance();

    private static  CategoryMaker categoryMaker;

    public RecommendService() {
        categoryMaker = new CategoryMaker();
    }

    public Map<Coach, List<String>> makeMenuForAllCoach(){
        List<Coach> coachs = coachRepository.getCoachs();
        Map<Coach, List<String>> recommendation = menuRecommendRepository.getRecommendation();
        for(Coach coach : coachs){
            List<String> randomMenu = makeRandomMenu(coach);
            recommendation.put(coach,randomMenu);
        }
        return recommendation;
    }


    public List<String> makeRandomMenu(Coach coach){
        List<String> categoriesName = categoryMaker.getCategoriesName();
        List<String> recommendationMenus = new ArrayList<>();
        for(String categoryName:categoriesName){
            List<String> menus = Category.findMenyByCategoryName(categoryName);
            String menu = Randoms.shuffle(menus).get(0);
            while(coach.isUnableMenu(menu)){
                menu = Randoms.shuffle(menus).get(0);
            }
            recommendationMenus.add(menu);
        }

        return recommendationMenus;


    }



    public List<String> makeCategory(){
        categoryMaker.makeRandomCategories();
        return categoryMaker.getCategoriesName();

    }

    public List<Coach> saveCoachs(List<Coach> coaches){
        for (Coach coach:coaches) {
            coachRepository.saveCoach(coach);
        }
        return coachRepository.getCoachs();
    }


}
