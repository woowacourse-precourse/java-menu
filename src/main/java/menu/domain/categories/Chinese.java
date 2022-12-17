package menu.domain.categories;

import java.util.ArrayList;
import java.util.List;

public class Chinese extends AbstractCategory{
    //깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채

    public Chinese() {
        super(new ArrayList<>(List.of(
                "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"
        )));
    }
}
