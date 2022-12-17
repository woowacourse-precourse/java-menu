package menu;

public class Application {
	static InputView iv = new InputView();
    public static void main(String[] args) {
    	iv.askCoachName();
    	iv.askNotEatingMenu();
    	RecommendMenu rm = new RecommendMenu(iv.getCoachName(), iv.getNotEatingMenuForEachCoach());
    	rm.recommendProcess();
    	OutputView ov = new OutputView(rm.getCoachName(), rm.getCategoryForWeek(), rm.getResult());
    	ov.printResult();
    }
}
