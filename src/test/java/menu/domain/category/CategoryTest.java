package menu.domain.category;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CategoryTest {
    Category category = new Category("양식");

    @ParameterizedTest(name ="카테고리를 {0}번 선택시(updateRecommendationCount()시) 총 카운트 수가 {1}을 넘는지 여부는 {2}" )
    @CsvSource({"2,1,true", "1,2,false","5,5,true"})
    @DisplayName("카테고리 recommendationCount 검증 로직")
    void 카테고리_카운트_검증(int turnCnt, int limit, boolean expected){
        for(int turn = 0 ; turn < turnCnt; turn++){
            category.updateRecommendedCount();
        }
        boolean result = category.isAlreadyRecommendedOver(limit);
        assertThat(result).isEqualTo(expected);
    }


}