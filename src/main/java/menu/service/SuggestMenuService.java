package menu.service;

import menu.Category;
import menu.Coach;
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
        List<Category> dailyCategoryList = Category.getCategoryOfWeekList();
        SuggestMenuResultDto resultDto = new SuggestMenuResultDto(dailyCategoryList);

        List<Coach> coachList = coachRepository.findAll();
        for (Coach coach : coachList) {
            List<String> weeklyMenuList = coach.getWeeklyMenuList(new ArrayList<>(dailyCategoryList));
            resultDto.addCoachMenuList(coach.getName(), weeklyMenuList);
        }
        return resultDto;
    }
}
