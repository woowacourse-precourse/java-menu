package menu;


import camp.nextstep.edu.missionutils.Randoms;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuSelectListMaker {
    CoachRepo coachRepo;
    List<String> categoriesForTheWeek;
    List<String> categories = List.of("일식", "한식", "중식", "아시안", "양식");
    public MenuSelectListMaker(CoachRepo coachRepo){
        this.coachRepo = coachRepo;
    }
    public String menuListStringReturn() {
        String returningList = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n";
        setCoachMenuTable();
        returningList += getCoachMenuTableString();
        return returningList;
    }

    private String getCoachMenuTableString() {
        String returningString = "";
        returningString += categoriesString() + "\n";
        returningString += coachEatingMenuString() ;
        return returningString;
    }

    private String coachEatingMenuString() {
        String returningString="";
        for (Coach coach : coachRepo.coachList){
            returningString += "[ " + coach.name + " ";
            returningString += coachMenuString(coach);
            returningString += "]\n";
        }
        return returningString;
    }

    private String coachMenuString(Coach coach) {
        String returningString ="";
        for (String menu : coach.eatingMenuList){
            returningString += "| " + menu+ " ";
        }
        return returningString;
    }

    private String categoriesString() {
        String returningString = "[ 카테고리 ";
        for (int i=0; i<5; i++){
            returningString += "| "+ categoriesForTheWeek.get(i)+ " ";
        }
        returningString+= "] ";
        return returningString;

    }

    private void setCoachMenuTable() {
        categoriesForTheWeek = setCategoriesForTheWeek();
        for (String category : categoriesForTheWeek){
            setCoachMenu(category);
        }
    }

    private void setCoachMenu(String category) {
        MenuTable menuTable = new MenuTable();
        for (Coach coach : coachRepo.coachList){
            addAvailableMenu(menuTable,category, coach);
        }
    }

    private void addAvailableMenu(MenuTable menuTable ,String category, Coach coach) {
        while (true){
            String selectedMenu = Randoms.shuffle(menuTable.menuMap.get(category)).get(0);
            if (coach.cannotEatMenuList.contains(selectedMenu) == false && coach.eatingMenuList.contains(selectedMenu) == false){
                coach.eatingMenuList.add(selectedMenu);
                break;
            }
        }
    }

    private List<String> setCategoriesForTheWeek() {
        List<String> returningList= new ArrayList<>();
        int i=0;
        while(i!=5){
            String category = categories.get(Randoms.pickNumberInRange(1,5)-1);
            if (!returningList.contains(category) || returningList.isEmpty() || (returningList.contains(category) && Collections.frequency(returningList,category) == 1)){
                returningList.add(category);
                i++;
            }
        }
        return returningList;
    }
}

