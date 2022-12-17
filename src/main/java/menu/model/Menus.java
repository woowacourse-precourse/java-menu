package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menus {

    private List<String> japMenus;
    private List<String> korMenus;
    private List<String> chiMenus;
    private List<String> asiMenus;
    private List<String> freMenus;

    public Menus(){
        japMenus = new ArrayList<>(Arrays.asList("규동","우동", "미소시루","스시","가츠동", "오니기리","하이라이스","라멘","오코노미야끼"));
        korMenus = new ArrayList<>(Arrays.asList("김밥","김치찌개","쌈밥","된장찌개","비빔밥","칼국수","불고기","떡볶이","제육볶음"));
        chiMenus = new ArrayList<>(Arrays.asList("깐풍기","볶음면","동파육","짜장면","짬뽕","마파두부","탕수육","토마토 달걀볶음","고추잡채"));
        asiMenus = new ArrayList<>(Arrays.asList("팟타이","카오 팟","나시고랭","파인애플 볶음밥","쌀국수","똠양꿍","반미","월남쌈","분짜"));
        freMenus = new ArrayList<>(Arrays.asList("라자냐","그라탱","뇨끼","끼슈","프렌치 토스트","바게트","스파게티","피자","파니니"));
    }

    public String getMenu(int number){
        if(number == 1 )
            return Randoms.shuffle(japMenus).get(0);
        if(number == 2 )
            return Randoms.shuffle(korMenus).get(0);
        if(number == 3 )
            return Randoms.shuffle(chiMenus).get(0);
        if(number == 4 )
            return Randoms.shuffle(asiMenus).get(0);
        if(number == 5 )
            return Randoms.shuffle(freMenus).get(0);
        return null;
    }

}
