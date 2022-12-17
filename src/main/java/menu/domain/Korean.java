package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Korean extends AbstractCategory{
    //김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음

    public Korean() {
        super(new ArrayList<>(List.of(
                "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"
        )));
    }
}
