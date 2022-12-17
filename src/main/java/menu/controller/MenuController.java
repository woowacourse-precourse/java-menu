package menu.controller;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.ResultConverter;
import menu.domain.repository.CategoryRepository;
import menu.domain.repository.CoachRepository;
import menu.service.CategoryService;
import menu.service.CoachService;
import menu.view.OutputView;
import menu.view.util.constant.CommandMessage;

import java.util.*;

public class MenuController {
    private final CategoryService categoryService = new CategoryService();
    private final CoachService coachService = new CoachService();
    private List<Category> weekCategories ;
    private final OutputView out = new OutputView();
    private final ResultConverter resultConverter = new ResultConverter();


    public void start(){
        out.print(CommandMessage.START.getMessage());
        // 코치 이름 + 못먹는 음식 입력받기 -> 코치 리스트 반환 받아서 저장
        coachService.setCoaches();
        // 각 요일 카테고리 별로 모든 코치 랜덤 음식 세팅
        weekCategories = categoryService.getWeekRandomCategories();
        generateDiet();

        out.print(CommandMessage.EXECUTE_MESSAGE.getMessage());
        out.print(resultConverter.convertToResultBar());
        out.print(resultConverter.convertToWeekResult(weekCategories));
        for(Coach coach : CoachRepository.coaches()){
            out.print(resultConverter.convertToCoachResult(coach.getName(), coach.getRandomFoods()));
        }
        out.printBlankLine();
        out.print(CommandMessage.COMPLETE.getMessage());
    }

    public void generateDiet() {
        for(int i = 0; i < 5; i++){
            saveRamdomFoodsAllCoach(i);
        }
    }

    private void saveRamdomFoodsAllCoach(int dayIndex){
        for(Coach coach : CoachRepository.coaches()){
            saveRandomFoodsToCoach(dayIndex, coach.getName());
        }
    }

    // 코치별로 랜덤 리스트 저장
    private void saveRandomFoodsToCoach(int dayIndex, String coachName){
        Category dayCategory = CategoryRepository.findCategoryByName(weekCategories.get(dayIndex).getName());
        Coach targetCoach = CoachRepository.findCoachByName(coachName);
        String randomFood = makeRandomFood(targetCoach, dayCategory);
        CoachRepository.saveRandomFoodsToCoach(targetCoach.getName(), randomFood);
    }
    private String makeRandomFood(Coach coach,Category dayCategory) {
        String randomFood ;
        do{
            randomFood = dayCategory.getRandomMenu();
        }while(coach.isFoodExclude(randomFood) && !coach.isFoodExist(randomFood));
        return randomFood;
    }
//

//    public String getResult(List<String>)
    public static void main(String[] args) {
        MenuController service = new MenuController();
        service.start();
    }
}

