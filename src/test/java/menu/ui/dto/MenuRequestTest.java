package menu.ui.dto;

import menu.common.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuRequestTest {

    @Test
    public void 못_먹는_음식은_두개를_넘길_수_없다() {
        String avoidMenu = "김치찌개, 우동, 스시";

        Assertions.assertThatThrownBy(() -> MenuRequest.from(avoidMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.AVOID_MENU_OVER_MAX_SIZE);
    }

    @Test
    public void 못_먹는_음식은_중복_해서_입력_할_수_없다() {
        String avoidMenu = "김치찌개, 김치찌개";

        Assertions.assertThatThrownBy(() -> MenuRequest.from(avoidMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.MENU_NAME_DUPLICATED);
    }


}