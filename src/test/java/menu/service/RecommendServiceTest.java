package menu.service;

import menu.utils.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RecommendServiceTest {


    @Test
    void getCategory_메소드를_6번_이상_호출하면_예외() {
        RecommendService recommendService = new RecommendService();
        Assertions.assertThatThrownBy(() -> {
                    for (int i = 0; i < 7; i++) {
                        recommendService.getCategory();
                    }
                }).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(ErrorMessage.TOO_MANY_CATEGORIES.getMessage());

    }

}