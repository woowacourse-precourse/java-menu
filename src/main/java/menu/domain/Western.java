package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Western extends AbstractCategory{
    //라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니

    public Western() {
        super(new ArrayList<>(List.of(
                "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"
        )));
    }
}
