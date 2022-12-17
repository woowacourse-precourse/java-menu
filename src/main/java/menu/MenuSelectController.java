package menu;

public class MenuSelectController {
    InputDriver inputDriver = new InputDriver();
    OutputDriver outputDriver = new OutputDriver();
    CoachRepo coachRepo = new CoachRepo();

    public void start() {
        outputDriver.printStartMessage();
        coachRepo.setCoachList(inputDriver.scanCoachName());
        setCoachCannotEatMenu();
        MenuSelectListMaker menuSelectListMaker = new MenuSelectListMaker(coachRepo);
        outputDriver.printResult(menuSelectListMaker.menuListStringReturn());
    }

    private void setCoachCannotEatMenu() {
        for (Coach coach : coachRepo.coachList){
            outputDriver.printScanCannotEatMenuMessage(coach.name);
            coachRepo.setCoachCannotEatMenu(coach.name,inputDriver.scanCannotEatMenu());
        }
    }
}
