package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Coaches {

    private static final String ERROR_DIVIDE = "[ERROR] 이름을 ','로 분류해주세요";
    private static final String ERROR_LENGTH = "[ERROR] 코치는 최소 2명 이상 최대 5명 이하여야 합니다.";
    private static final String ERROR_NAME_LENGTH = "[ERROR] 코치의 이름은 2글자 이상, 4글자 이하여야 합니다.";

    List<Day>days;
    List<Coach> coachList;

    public Coaches(List<Day>days){
        this.days = days;
    }

    public void setCoaches(String coachesName){
        validate(coachesName);
        makeCoachList(coachesName);
    }

    private void makeCoachList(String coachesName) {
        String [] names = makeArray(coachesName);
        List<Coach>coachList = new ArrayList<>();
        for(String name : names){
            coachList.add(new Coach(name));
        }
        this.coachList = coachList;
    }

    private void validate(String coachesName) {
        String [] names = makeArray(coachesName);
        validateDivide(coachesName, names);
        validateNumberOfCoaches(names);
        validateEachName(names);
    }

    private String[] makeArray(String coachesName) {
        String[] tmpArray = coachesName.split(",");
        for(int i=0;i< tmpArray.length;i++){
            tmpArray[i] = tmpArray[i].replace(" ", "");
        }
        return tmpArray;
    }

    private void validateEachName(String[] coachesName) {
        for(String eachName : coachesName){
            if(eachName.length()<2||eachName.length()>4){
                throw new IllegalArgumentException(ERROR_NAME_LENGTH);
            }
        }
    }

    private void validateNumberOfCoaches(String[] coachesName) {
        if(coachesName.length<2||coachesName.length>5){
            throw new IllegalArgumentException(ERROR_LENGTH);
        }

    }

    private void validateDivide(String inputNames, String[] coachesName) {
        if (countChar(inputNames, ',')+1 != coachesName.length) {
            throw new IllegalArgumentException(ERROR_DIVIDE);
        }
    }

    private static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }

    public List<Coach> getCoaches() {
        return coachList;
    }

    public void findMenu(String menu) {
        if(menu.equals("")){
            return;
        }
        for(Day day : days){
            if(day.haveMenu(menu)){
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 없는 메뉴입니다.");
    }

    public List<Category> makeSelectedCategories() {
        List<Category>selectedCategories = new ArrayList<>();
        for(Day day : days){
            Category category = day.getCategory(Randoms.pickNumberInRange(1, 5));
            selectedCategories.add(category);
        }
        if(new HashSet<>(selectedCategories).size()<4){
            return makeSelectedCategories();
        }
        return selectedCategories;
    }

    public List<Menu> makeSelectedMenus(List<Category> selectedCategories) {
        List<Menu>selectedMenus = new ArrayList<>();
        for(Category category : selectedCategories){
            selectedMenus.add(category.getRandomMenu());
        }
        if(new HashSet<>(selectedMenus).size()!=5){
            return makeSelectedMenus(selectedCategories);
        }
        return selectedMenus;
    }

    public List<Day> getDays() {
        return days;
    }

    public String printAllDays() {
        List<String>allDays= new ArrayList<>();
        for(Day day : days){
            allDays.add(day.getDay());
        }
        return "[ 구분 | "
                + String.join(" | ", allDays)
                +  "]";
    }

    public List<List<Menu>> makeDailyMenus(List<Category> selectedCategories) {
        List<List<Menu>> selectedMenus = new ArrayList<>();
        for(Coach coach : coachList){
            List<Menu>eachCoachesSelectedMenu = makeEachCoachesMenu(selectedCategories, coach);
            selectedMenus.add(eachCoachesSelectedMenu);
        }
        return selectedMenus;
    }

    private List<Menu> makeEachCoachesMenu(List<Category> selectedCategories, Coach coach) {
        List<Menu>selectedMenus = makeSelectedMenus(selectedCategories);
        if(!coach.checkCanEat(selectedMenus)){
            return makeEachCoachesMenu(selectedCategories, coach);
        }
        return selectedMenus;
    }

    public Coach getCoach(int index) {
        return coachList.get(index);
    }
}
