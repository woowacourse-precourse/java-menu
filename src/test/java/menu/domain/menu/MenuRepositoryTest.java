package menu.domain.menu;

import menu.domain.category.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class MenuRepositoryTest {
    MenuRepository menuRepository = MenuRepository.getInstance();

    static Stream<Arguments> getData(){
        Category korean = new Category( "한식");
        Category western = new Category( "양식");
        return Stream.of(
                Arguments.of(korean, List.of("볶음밥","비빔밥","잡채","국")),
                Arguments.of(western, List.of("피자","햄버거","파스타"))
        );
    }

    @ParameterizedTest(name = "{0} 카테고리에 속하는 음식 리스트가 {1}일 때, {0} 카테고리를 키로 찾은 음식 리스트는 {1}")
    @MethodSource("getData")
    @DisplayName("findAllByCategory() 로직 검증")
    void find_all_by_category(Category category, List<String> menus){
        for (String menu : menus) {
            menuRepository.save(category, menu);
        }

        List<String> result = menuRepository.findAllByCategory(category);
        Assertions.assertThat(result).isEqualTo(menus);
    }
}