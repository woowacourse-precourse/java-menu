package menu.domain.category;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryRepositoryTest {
    CategoryRepository categoryRepository = CategoryRepository.getInstance();

    static Stream<Arguments> getData(){
        Category korean = new Category( "한식");
        Category western = new Category( "양식");
        return Stream.of(
               Arguments.of(List.of(korean, western)
        ));
    }

    @Test
    @DisplayName("저장 및 findById 로직")
    void 테스트(){
        Category category = new Category("나");
        categoryRepository.save(1, category);
        Category byId = categoryRepository.findById(1);
        assertThat(byId).isEqualTo(category);
    }

    @ParameterizedTest(name = "{0}의 카테고리을 save한 후, findAll 한 결과는 {0}과 일치")
    @MethodSource("getData")
    @DisplayName("find All 로직")
    void find_all(List<Category> categories){
        int sequence = 1;
        for (Category category : categories) {
            categoryRepository.save(sequence++, category);
        }

        List<Category> result = categoryRepository.findAll();
        assertThat(result).isEqualTo(categories);
    }


}