package menu.service;

import menu.RandomCategoryNumberGenerator;
import menu.RandomNumberGenerator;
import menu.utils.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RecommendServiceTest {

    RandomNumberGenerator generator = new RandomCategoryNumberGenerator();

    @Test
    void getCategory_메소드를_6번_이상_호출하면_예외() {
        RecommendService recommendService = new RecommendService(generator);
        Assertions.assertThatThrownBy(() -> {
                    for (int i = 0; i < 7; i++) {
                        recommendService.getCategory();
                    }
                }).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(ErrorMessage.CATEGORY_TOO_MANY.getMessage());

    }

}