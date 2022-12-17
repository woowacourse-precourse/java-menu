package menu;

public class Application {
    static Coach[] initiate() {
        String[] coachesInput = UserInterface.getCoachList();
        Coach[] coaches = new Coach[coachesInput.length];
        for (int i = 0; i < coachesInput.length; i++) {
            String[] hateMenus = UserInterface.getHateMenus(coachesInput[i]);
            coaches[i] = new Coach(coachesInput[i], hateMenus);
        }
        return coaches;
    }
    static String[] startRecommend(Coach[] coaches) {
        FoodRecommender foodRecommender = new FoodRecommender();
        return foodRecommender.recommend(coaches);
    }
    static void terminate(String[] categories, Coach[] coaches) {
        UserInterface.notifyTotalResult(categories, coaches);
    }
    public static void main(String[] args) {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        Coach[] coaches = initiate();
        String[] categories = startRecommend(coaches);
        terminate(categories, coaches);
    }
}
