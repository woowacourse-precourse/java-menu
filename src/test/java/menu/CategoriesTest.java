package menu;

import menu.domain.Categories;

import static org.assertj.core.api.Assertions.assertThat;

import menu.utils.CSVUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CategoriesTest {
    @DisplayName("파일로 부터 메뉴를 잘 인스턴스화 했는지 테스트 ")
    @Test
    void caseCorrectCategoryByCode(){
        assertThat(CSVUtils.getCsvLine("일식").contains(Categories.get(1).getRandomMenu()));
    }
}
