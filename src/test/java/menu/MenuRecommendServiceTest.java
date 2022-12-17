package menu;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.Weekend;
import menu.repository.MenuRepository;
import menu.repository.WeekendRepository;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuRecommendServiceTest {

    private static final List<Weekend> weekend = WeekendRepository.weekends();
    private static final List<Menu> menus = MenuRepository.menus();

    @Test
    void 요일별_카테고리_생성_실패_테스트(){
        for (Weekend day : weekend) {
            Category dayOfTheCategory = Category.findByCommand(1);
            day.createCategory(dayOfTheCategory);
        }
        assertThat(WeekendRepository.checkDuplication(weekend)).isTrue();
    }
    @Test
    void 요일별_카테고리_생성_성공_테스트(){
        for (int i = 0; i < weekend.size() ; i++) {
            Weekend day = weekend.get(i);
            Category dayOfTheCategory = Category.findByCommand(i+1);
            day.createCategory(dayOfTheCategory);
            System.out.println("dayOfTheCategory = " + dayOfTheCategory);
        }
        assertThat(WeekendRepository.checkDuplication(weekend)).isFalse();
    }


    @Test
    void 못먹는음식_제거_테스트(){
        Coach coach = new Coach("kim",List.of("김밥","김치찌개"));
        List<Menu> menus =MenuRepository.findMenuByCategory(Category.KOREAN_FOOD);
        System.out.println("menus = " + menus);
        List<Menu> canNotEat = coach.getCanNotEatMenu();
        System.out.println("canNotEat = " + canNotEat);
        System.out.println(menus.containsAll(canNotEat));
        for (int i = 0; i <canNotEat.size() ; i++) {
            menus.remove(canNotEat.get(i));
        }
        System.out.println("menus = " + menus);
        List<Menu> menus2 =MenuRepository.findMenuByCategory(Category.KOREAN_FOOD);
    }
}
