package menu;


import static org.assertj.core.api.Assertions.assertThat;

import menu.utils.CSVUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CSVUtilsTest {

    @DisplayName("아시안 요리인 팟타이가 포함되어 있는지 테스트")
    @Test
    void caseGetMenuFromCSV(){
        assertThat(CSVUtils.getCsvLine("아시안")).containsAnyOf("팟타이");
    }
}
