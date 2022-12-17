package menu;

public class Application {
    static Coach[] initiate() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String[] coachesInput = UserInterface.getCoachList();
        Coach[] coaches = new Coach[coachesInput.length];
        for (int i = 0; i < coachesInput.length; i++) {
            System.out.println(coachesInput[i] + "(이)가 못 먹는 메뉴를 입력해 주세요.");
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
        Coach[] coaches = initiate();
        String[] categories = startRecommend(coaches);
        terminate(categories, coaches);
    }
}
