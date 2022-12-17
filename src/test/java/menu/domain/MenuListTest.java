package menu.domain;

import menu.generator.CategoryGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class MenuListTest {

    @DisplayName("카테고리를 주었을때 정상적으로 해당 카테고리 메뉴를 가져오는지 확인")
    @Test
    void getFiled() {
        List<String> menuList = MenuList.getFiled(Category.JAPAN);
        Assertions.assertThat(menuList).isEqualTo(MenuList.JAPAN.getMenus());
    }

    @DisplayName("메뉴의 이름이 주어졌을때 존재하는 메뉴인지 아닌지 파악하는 기능")
    @Test
    void find() {
        String menu = "스시";
        Assertions.assertThat(MenuList.find(menu)).isTrue();
    }
}