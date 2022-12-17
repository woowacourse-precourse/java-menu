package menu.service;
import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.*;


public class MenuService {

    private static MenuRecommendApp menuRecommendApp = new MenuRecommendApp();
    static final InputValidation inputValidation = new InputValidation();
    static final InputView inputView = new InputView();
    static final OutputView outputView = new OutputView();

    public void menuChoice(){
        menuRecommendApp.initializeCategory();

        outputView.printMenuRecommendStartMessage();

        outputView.printRequestCoachNameMessage();
        inputCoachNameAndCheckValidation(true,"");

        inputCanNotEatMenuAndCheckValidation();
        menuRecommendAndPrintResult();
    }

    private void inputCoachNameAndCheckValidation(boolean doRetryInputCoachName , String coachNameWithComma){
        while(doRetryInputCoachName){
            doRetryInputCoachName = false;
            coachNameWithComma = inputView.inputCoachNameWithComma();
            String[] coachNames = coachNameWithComma.split(",");

            if(!isValidCoachName(coachNames))
                doRetryInputCoachName = true;
            if(!isValidCoachCount(coachNames.length))
                doRetryInputCoachName = true;
        }
        menuRecommendApp.initializeCoach(coachNameWithComma);
    }

    private boolean isValidCoachName(String[] coachNames){
        for (int i = 0; i < coachNames.length; i++) {
            if(!inputValidation.isValidCoachName(coachNames[i])) {
                outputView.printInValidCoachNameLengthErrorMessage();
                return false;
            }
        }
        return true;
    }

    private boolean isValidCoachCount(int coachCount){
        if(!inputValidation.isValidCoachNumber(coachCount)){
            outputView.printInValidCoachCountErrorMessage();
            return false;
        }
        return true;
    }

    private void inputCanNotEatMenuAndCheckValidation(){
        for (Coach coach : menuRecommendApp.getCoaches()) {
            outputView.printRequestCoachCanNotEatMenuMessage(coach.name);
            boolean doRetryInputCanNotEatMenu = true;
            while(doRetryInputCanNotEatMenu){
                String inputResultCanNotEatMenuWithComma = inputView.inputCoachCanNotEatMenu();
                doRetryInputCanNotEatMenu = isNotValidCanNotEatMenuInput(inputResultCanNotEatMenuWithComma , coach);
            }
        }
    }

    private boolean isNotValidCanNotEatMenuInput(String inputResultCanNotEatMenuWithComma , Coach coach){
        if(inputResultCanNotEatMenuWithComma.length() == 0)
            return false;

        String[] canNotEatMenus = inputResultCanNotEatMenuWithComma.split(",");
        if(inputValidation.isValidCoachCanNotEatMenuCount(canNotEatMenus.length)){
            for (String canNotEatMenu : canNotEatMenus)
                coach.addNotEatMenu(canNotEatMenu);
            return false;
        }
        outputView.printInValidCoachCanNotEatMenuCountErrorMessage();
        return true;
    }

    private void menuRecommendAndPrintResult(){
        outputView.printMenuRecommendResultMessage();
        outputView.printDayOfTheWeekMessage();
        menuRecommend();
        outputView.printCategoryByDayOfTheWeek(menuRecommendApp.getCategoryByDayOfTheWeek());
        outputView.printRecommendedMenuByCoach(menuRecommendApp.getCoaches());
        outputView.printMenuRecommendFinishMessage();
    }

    public void menuRecommend(){
        for (DayOfTheWeek dayOfTheWeek : DayOfTheWeek.values()) {
            choiceCategory();
            for (Coach coach : menuRecommendApp.getCoaches()) {
                choiceMenu(coach , dayOfTheWeek.getNum());
            }
        }
    }

    private void choiceCategory(){
        while(true){
            Category category = menuRecommendApp.getCategories().get(Randoms.pickNumberInRange(1, 5)-1);

            if(!menuRecommendApp.isAppearCategoryMoreThanThree(category.getCategoryNumber())) {
                menuRecommendApp.addCategoryByDayOfTheWeek(category.getName());
                return;
            }
        }
    }

    private void choiceMenu(Coach coach , int dayOfTheWeekNum){
        while(true){
            String menu = Randoms.shuffle(menuRecommendApp.getCategories().get(dayOfTheWeekNum).getMenus()).get(0);
            if(coach.canEatMenu(menu)) {
                coach.addRecommendedMenu(menu);
                return;
            }
        }
    }
}
