package menu.service;

import menu.entity.Category;
import menu.entity.Coach;
import menu.dto.SuggestMenuResultDto;
import menu.repository.CoachRepository;

import java.util.ArrayList;
import java.util.List;

public class SuggestMenuService {

    private final CoachRepository coachRepository;

    private static final SuggestMenuService instance = new SuggestMenuService();

    private SuggestMenuService() {
        coachRepository = CoachRepository.getInstance();
    }

    public static SuggestMenuService getInstance() {
        return instance;
    }

    public SuggestMenuResultDto suggest() {
        List<Category> weeklyCategoryList = Category.getCategoryOfWeekList();
        SuggestMenuResultDto resultDto = new SuggestMenuResultDto(weeklyCategoryList);

        List<Coach> coachList = coachRepository.findAll();
        findResultOfCoaches(weeklyCategoryList, resultDto, coachList);
        return resultDto;
    }

    private void findResultOfCoaches(List<Category> weeklyCategoryList, SuggestMenuResultDto resultDto, List<Coach> coachList) {
        for (Coach coach : coachList) {
            List<String> weeklyMenuList = coach.getWeeklyMenuList(weeklyCategoryList);

            resultDto.addResult(coach.getName(), weeklyMenuList);
        }
    }
}
