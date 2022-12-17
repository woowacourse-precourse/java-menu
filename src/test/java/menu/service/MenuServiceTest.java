package menu.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuServiceTest {

    @ValueSource(strings = {"하나,두울,세엣", "하나하나,두두두울"})
    @ParameterizedTest
    void 코치_이름_제대로_입력(String input) throws Exception{
        //given
        MenuService menuService = new MenuService();

        //when
        menuService.setCoachesName(input);

        //then
    }

    @ValueSource(strings = {"하나,두울,세엣,네엣,다섯,여섯", "나,두두두울"})
    @ParameterizedTest
    void 잘못된_코치_이름입력(String input) throws Exception{
        //given
        MenuService menuService = new MenuService();

        //when

        //then
        assertThatThrownBy(() -> menuService.setCoachesName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 기피_음식_입력받기() throws Exception{
        //given
        MenuService menuService = new MenuService();
        menuService.setCoachesName("하나,두울");

        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("비빔밥");
        inputs.add("");

        //when
        for(String input:inputs)
            menuService.validateAvoidanceInput(input);
        menuService.setAvoidance(inputs);

        //then
    }

    @ValueSource(strings = {"음식1", "비빔밥,음식2", "비빔밥,비빔밥"})
    @ParameterizedTest
    void 잘못된_기피_음식(String input) throws Exception{
        //given
        MenuService menuService = new MenuService();
        menuService.setCoachesName("하나,두울");

        //when

        //then
        assertThatThrownBy(() -> menuService.validateAvoidanceInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 카테고리_정하기_테스트() throws Exception{
        //given
        MenuService menuService = new MenuService();

        //when
        menuService.setCategories();

        //then
        assertThat(menuService.getCategories().stream().distinct().count()).isGreaterThan(2);
    }

    @Test
    void 메뉴_정하기_테스트() throws Exception{
        //given
        MenuService menuService = new MenuService();
        menuService.setCoachesName("하나,두울");
        menuService.setCategories();

        //when
        menuService.setMenus();

        //then
        assertThat(menuService.getCoaches()).allMatch(o -> o.getRecommended().stream().distinct().count() == 5);
    }
}