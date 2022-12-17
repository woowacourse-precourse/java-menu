package menu.service;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.dto.NoEatsDto;
import menu.repository.MenuRepository;

import java.util.stream.Collectors;

public class MenuService {
    private Coaches coaches;

    public void registerCoaches(NoEatsDto noEatsDto) {
        coaches = noEatsDto.getNoEats().stream()
                .map(noEatDto -> new Coach(noEatDto.getCoachName(),
                        MenuRepository.findMenus(noEatDto.getNoEat())))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Coaches::new));
    }
}
