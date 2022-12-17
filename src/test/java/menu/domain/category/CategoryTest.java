package menu.domain.category;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    
    @DisplayName("예외 처리 : 존재하는 카테고리가 아닐 시")
    @ParameterizedTest(name = "{displayName} : categoryNumber => {0}")
    @ValueSource(ints = {0, 6})
    void findByCategoryNumberException(int categoryNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Category.findByCategoryNumber(categoryNumber))
                .withMessageStartingWith("[ERROR]");
    }
}