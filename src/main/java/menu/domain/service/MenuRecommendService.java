package menu.domain.service;

import menu.domain.dto.CoachRequestDto;
import menu.domain.model.Coach;
import menu.domain.model.Menu;
import menu.domain.repository.CoachRepository;
import menu.domain.repository.MenuRepository;

import java.util.List;

public class MenuRecommendService {

    public void createCoach(List<CoachRequestDto> requestDtos) {
        for (CoachRequestDto requestDto : requestDtos) {
            String name = requestDto.getName();
            List<String> canNotEatFoodsName = requestDto.getCanNotEatFoods();
            List<Menu> canNotEatFoods = MenuRepository.findByNames(canNotEatFoodsName);

            CoachRepository.save(new Coach(name, canNotEatFoods));
        }
    }
}
