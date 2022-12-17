package menu;


import static org.assertj.core.api.Assertions.assertThat;

import menu.utils.CSVUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CSVUtilsTest {

    @DisplayName("다음칸이 이동할 수 있는 칸인 경우 true 반환")
    @Test
    void caseGetMenuFromCSV(){
        assertThat(CSVUtils.getCsvLine("아시안")).containsAnyOf("팟타이");
    }
}
