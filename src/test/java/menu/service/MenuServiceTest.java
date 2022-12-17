package menu.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MenuServiceTest {

    @ValueSource(strings = {"하나,두울,세엣", "하나하나,두두두울"})
    @ParameterizedTest
    void 코치_이름_제대로_입력(String input) throws Exception{
        //given
        MenuService menuService = new MenuService();

        //when
        menuService.getCoachesName(input);

        //then
    }

    @ValueSource(strings = {"하나,두울,세엣,네엣,다섯,여섯", "나,두두두울"})
    @ParameterizedTest
    void 잘못된_코치_이름입력(String input) throws Exception{
        //given
        MenuService menuService = new MenuService();

        //when

        //then
        Assertions.assertThatThrownBy(() -> menuService.getCoachesName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 기피_음식_입력받기() throws Exception{
        //given
        MenuService menuService = new MenuService();
        menuService.getCoachesName("하나,두울");

        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("음식1,음식2");
        inputs.add("");

        //when
        menuService.getAvoidance(inputs);

        //then
    }

    @Test
    void 잘못된_기피_음식() throws Exception{
        //given
        MenuService menuService = new MenuService();
        menuService.getCoachesName("하나,두울");

        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("음식1,음식2,음식3");
        inputs.add("음식1,음식2,음식3");

        //when

        //then
        Assertions.assertThatThrownBy(() -> menuService.getAvoidance(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }
}