package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Japanese extends AbstractCategory{
    //규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼

    public Japanese() {
        super(new ArrayList<>(List.of(
                "규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"
        )));
    }
}
