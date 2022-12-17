package menu;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuSelectListMaker {
    CoachRepo coachRepo;
    List<String> categories = List.of("일식", "한식", "중식", "아시안", "양식");
    List<String> categoriesForTheWeek;
    public MenuSelectListMaker(CoachRepo coachRepo){
        this.coachRepo = coachRepo;
    }
    public void menuListStringReturn() {
        String returningList = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n" + "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]";
        setCoachMenuTable();

    }

    private void setCoachMenuTable() {
        categoriesForTheWeek = setCategoriesForTheWeek();

    }

    private List<String> setCategoriesForTheWeek() {
        List<String> returningList= new ArrayList<>();
        int i=0;
        while(i!=5){
            String category = categories.get(Randoms.pickNumberInRange(0,4));
            if (!returningList.contains(category) || returningList.isEmpty() || (returningList.contains(category) && Collections.frequency(returningList,category) == 1)){
                returningList.add(category);
                i++;
            }
        }
        return returningList;
    }


}

