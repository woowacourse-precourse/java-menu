package menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputDriverTest {

    @DisplayName("이름 목록 테스트")
    @Test
    void 구분자_테스트() {
        assertThatThrownBy(() -> new InputDriver()
                .checkIfValidStringForMenuList(",토미,제임스,포코"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void 이름_중복_테스트() {
        assertThatThrownBy(() -> new InputDriver()
                .checkIfValidStringForMenuList("토미,토미,제임스,포코"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_글자_수_테스트() {
        assertThatThrownBy(() -> new InputDriver()
                .checkIfValidStringForMenuList("토미,제임스,포코로미자"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 코치_수_테스트() {
        assertThatThrownBy(() -> new InputDriver()
                .checkIfValidStringForMenuList("토미,제임스,포미자,수냉,보리차"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 메뉴_개수_테스트(){
        assertThatThrownBy(() -> new InputDriver()
                .checkIfValidStringForMenuList("우동,뇨끼,그라탕,스파게티"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}