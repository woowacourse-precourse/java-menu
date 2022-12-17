package menu;

import menu.domain.Coach;
import menu.domain.Food;
import menu.error.ErrorResource;
import menu.resource.Category;
import menu.resource.Day;

import java.util.ArrayList;
import java.util.List;

public class MenuGame {

    private static String JAPAN_FOOD  = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼";
    private static String KOREA_FOOD = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음";
    private static String CHINESE_FOOD ="깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";
    private static String ASIAN_FOOD ="팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜";
    private static String FOREIGN_FOOD = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니";
    private static int MAX_CANT_EAT = 2;
    private static int MIN_COACH = 2;
    private static int MAX_COACH =5;
    private static String NO_EXIST_CANT_EAT ="";
    private List<Food> foods = new ArrayList<>();
    private List<Coach> coaches = new ArrayList<>();
    private MenuRecommend menuRecommend;
    public MenuGame(){
        initiateFood();
    }

    public MenuRecommend getMenuRecommend() {
        return menuRecommend;
    }

    public void makeMenuRecommend(){
        menuRecommend = new MenuRecommend(coaches,foods);
    }
    public void makeCoaches(List<String> coaches){
        if(coaches.size()<MIN_COACH){
            throw new IllegalArgumentException(ErrorResource.ERROR_START+ ErrorResource.COACH_SMALL);
        }
        if(coaches.size()>MAX_COACH){
            throw new IllegalArgumentException(ErrorResource.ERROR_START+ ErrorResource.COACH_BIG);
        }
        for(int i=0;i<coaches.size();i++){
            makeEachCoach(coaches, i);
        }
    }
    private void makeEachCoach(List<String> coaches, int i) {
        try{
            Coach coach = new Coach(coaches.get(i));
            this.coaches.add(coach);
        }
        catch(IllegalArgumentException e){
            this.coaches.clear();
            throw e;
        }
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public List<List<String> > getCoachMenus(){
        List<List<String> > coachesMenus = new ArrayList<>();
        for(int i=0;i<coaches.size();i++){
            List<String> eachCoach = new ArrayList<>();
            eachCoach.add(coaches.get(i).getName());
            for(Day day: coaches.get(i).getFoodPerDay().keySet()){
                eachCoach.add(coaches.get(i).getFoodPerDay().get(day));
            }
            coachesMenus.add(eachCoach);
        }
        return coachesMenus;
    }

    public void addFoodCoachCantEat(Coach coach,List<String> foods){
        if(foods.size()>MAX_CANT_EAT){
            throw new IllegalArgumentException(ErrorResource.ERROR_START+ ErrorResource.TOO_MANY_CANT_EAT);
        }
        if(foods.get(0).equals(NO_EXIST_CANT_EAT)){
            return;
        }
        Food food = checkIfFoodExist(foods);
        coach.addCantEatFood(food);
    }

    private Food checkIfFoodExist(List<String> foods) {
        Food food = null;
        for(int i=0;i<this.foods.size();i++){
            if(foods.contains(this.foods.get(i).getName())){
                food = this.foods.get(i);
                break;
            }
        }
        if(food == null){
            throw new IllegalArgumentException(ErrorResource.ERROR_START+ ErrorResource.NO_EXIST_MENU);
        }
        return food;
    }

    private void initiateFood() {
        makeFoods(JAPAN_FOOD, Category.JAPAN);
        makeFoods(KOREA_FOOD,Category.KOREA);
        makeFoods(CHINESE_FOOD,Category.CHINESE);
        makeFoods(ASIAN_FOOD,Category.ASIAN);
        makeFoods(FOREIGN_FOOD,Category.FOREIGN);
    }

    public void makeFoods(String foodNames, Category category){
        String foodWithOutSpace = foodNames.replaceAll(" ","");
        List<String> splitFoodName = List.of(foodWithOutSpace.split(","));
        for(int i=0;i<splitFoodName.size();i++) {
            Food food = new Food(splitFoodName.get(i), category);
            foods.add(food);
        }
    }


}
